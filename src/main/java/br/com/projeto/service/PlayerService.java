package br.com.projeto.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.PlayerDao;
import br.com.projeto.entity.Player;
import br.com.projeto.util.CryptUtils;

@Service
public class PlayerService {

	@Autowired
	private PlayerDao dao;
	
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

	
//	public Player cadastrar(String login,String password){

//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		HttpSession session = attr.getRequest().getSession(true);
		
//		User user = dao.get(login, CryptUtils.md5(password));
//		
//		if (user == null) {
//			return null;
//		}
//		
//		session.setAttribute(Constants.USER_ADMIN, user);
		
//		return user;

//	}

	

}
