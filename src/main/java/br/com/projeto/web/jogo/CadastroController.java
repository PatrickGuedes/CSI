package br.com.projeto.web.jogo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.service.PlayerService;


@Controller
public class CadastroController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlayerService service;


	@RequestMapping("/jogo/cadastrar")
	public String newPlayer() throws ServletException, IOException {
		
		if (service.newPlayer() == false) {
			return "redirect:/jogo/cadastro.jsp";
		}
		
		return "redirect:/jogo/";
	}	
	
}