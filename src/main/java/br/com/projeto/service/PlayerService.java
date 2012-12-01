package br.com.projeto.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.LocationDao;
import br.com.projeto.dao.PlayerDao;
import br.com.projeto.dao.PlayerTraceDao;
import br.com.projeto.entity.Case;
import br.com.projeto.entity.Location;
import br.com.projeto.entity.Player;
import br.com.projeto.entity.PlayerTrace;
import br.com.projeto.entity.Trace;
import br.com.projeto.util.CryptUtils;

@Service
public class PlayerService {

	@Autowired
	private PlayerDao dao;
	@Autowired
	private LocationDao locationDao;	
	@Autowired
	private PlayerTraceDao playerTraceDao;	
	
	public Player login(String username, String password) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		
		Player player = dao.login(username, CryptUtils.md5(password));
		
		// nao conseguiu autenticar
		if (player == null) {
			session.setAttribute("LoginMessage", "Usuário ou senha inválido.");
			return null;
		}
		
		session.setAttribute("Player", player);
		
		return player;
	}
	
	
	public void logout() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.removeAttribute("Player");
	}

	
	public boolean newPlayer() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		
		Player player = new Player();
		
		player.setUsername(attr.getRequest().getParameter("username"));
		player.setPassword( CryptUtils.md5(attr.getRequest().getParameter("password")) );
		player.setXp(0);
		player.setEnergy(100);

		boolean result = dao.insert(player);
		
		if (result) {
			session.setAttribute("LoginMessage", "Cadastro realizado com sucesso.");
		} else {
			session.setAttribute("CadastroMessage", "Preencha corretamente o cadastro.");
		}
		
		return result;
	}
	
	public boolean hasOpenCase() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		return (player.getCaseOpen() != null);
	}
	
	public void openCase() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return;
		
		player.setCaseOpen(Integer.parseInt(attr.getRequest().getParameter("caseId")));
		
		dao.update(player);
	}
	
	public void getCases() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return;
		
		List<Case> cases = dao.getCases(player.getId());

		session.setAttribute("Cases", cases);
	}
	
	public void getLocations() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return;
		
		if (player.getCaseOpen() == null) return;

		session.setAttribute("Locations", locationDao.locationsByCase(player.getCaseOpen()));
	}

	public boolean getTraces(Integer locationId) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		if (player.getCaseOpen() == null) return false;

		Location locationObj = locationDao.findById(locationId); 
		
		// nao tem energia suficiente
		if (player.getEnergy() < locationObj.getEnergy()) {
			session.setAttribute("NoEnergy", true);
			return false;
		}
		
		// atualiza a energia
		player.setEnergy( player.getEnergy() - locationObj.getEnergy() );
		
		dao.update(player);

		session.setAttribute("NoEnergy", false);
		session.setAttribute("Traces", dao.getLocationTraces(player.getId(), locationId));
		
		return true;
	}

	public void getLabTraces() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return;

		session.setAttribute("LabTraces", dao.getTracesToProcess(player.getId()));		
	}
	
	public boolean drinkCoffee() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		// ganha energia
		player.setEnergy( player.getEnergy() + 30 );
		dao.update(player);

		return true;
	}
	
	public boolean foundTrace(Integer traceId) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		PlayerTrace playerTrace = new PlayerTrace();
		playerTrace.setPlayerId(player.getId());
		playerTrace.setTraceId(traceId);
		playerTrace.setProcessed(false);
		
		playerTraceDao.insert(playerTrace);
		
		return true;
	}

	public boolean processTraces() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		List<Trace> traces = dao.getTracesToProcess(player.getId());
		
		for (Trace t : traces) {
			playerTraceDao.setProcessed(player.getId(), t.getId());
			player.setXp( player.getXp() + t.getXp() );
		}
		
		dao.update(player);
		
		return true;
	}

	public boolean isCaseSolved() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);

		Player player = (Player) session.getAttribute("Player");
		
		if (player == null) return false;
		
		return dao.isCaseSolved(player.getId(), player.getCaseOpen());
	}
}
