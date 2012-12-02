package br.com.projeto.web.jogo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto.service.PlayerService;

@Controller
public class PlayerController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlayerService service;

	@RequestMapping("/jogo/cases")
	public String homeCases() throws ServletException, IOException {
		if (service.hasOpenCase()) {
			return "redirect:/jogo/locations.action";			
		}
		
		service.getCases();
		
		return "/jogo/cases.jsp";
	}
	
	@RequestMapping("/jogo/openCase")
	public String openCase(@RequestParam(value="caseId", required=true) String caseId) {
		service.openCase(Integer.parseInt(caseId));
		return "redirect:/jogo/locations.action";
	}
	
	@RequestMapping("/jogo/locations")
	public String locations() {
		service.getLocations();
		return "/jogo/locations.jsp";
	}

	@RequestMapping("/jogo/traces")
	public String traces(@RequestParam(value="locationId", required=true) String locationId) {
		
		if (service.getTraces(Integer.parseInt(locationId)) == false) {
			return "/jogo/locations.action";
		}
		
		return "/jogo/traces.jsp";
	}
	
	@RequestMapping("/jogo/lab")
	public String lab() {
		service.getLabTraces();
		return "/jogo/lab.jsp";
	}
	
	@RequestMapping("/jogo/drinkCoffee")
	public @ResponseBody String drinkCoffee() {
		if (service.drinkCoffee()) {
			return "E";
		}
		return "W";
	}

	@RequestMapping("/jogo/foundTrace")
	public @ResponseBody String foundTrace(@RequestParam(value="traceId", required=true) String traceId) {
		
		try {
			if (service.foundTrace(Integer.parseInt(traceId))) {
				return "P";
			}
		} catch (Exception e) {
			
		}
		
		return "N";
	}

	@RequestMapping("/jogo/processTraces")
	public @ResponseBody String processTraces() {
		
		try {
			if (service.processTraces()) {
				String caseSolved;
				
				if (service.isCaseSolved()) {
					//caseSolved = "true";
					return "R";
				} else {
					//caseSolved = "false";
					return "F";
				}
				
			}
		} catch (Exception e) {}
		
		return "E";
	}
	
}