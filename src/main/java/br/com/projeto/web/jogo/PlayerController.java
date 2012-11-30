package br.com.projeto.web.jogo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String openCase() {
		service.openCase();
		return "redirect:/jogo/locations.action";
	}
	
	@RequestMapping("/jogo/locations")
	public String locations() {
		service.getLocations();
		return "/jogo/locations.jsp";
	}

	@RequestMapping("/jogo/traces")
	public String traces() {
		service.getTraces();
		return "/jogo/traces.jsp";
	}

}