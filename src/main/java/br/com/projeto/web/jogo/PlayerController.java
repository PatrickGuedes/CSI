package br.com.projeto.web.jogo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import br.com.projeto.service.PlayerService;

@Controller
public class PlayerController {

	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private PlayerService service;

	@RequestMapping("/jogo/cases")
	public String homeCases() throws ServletException, IOException {
		return "redirect:/jogo/cases.jsp";
	}	
	
}