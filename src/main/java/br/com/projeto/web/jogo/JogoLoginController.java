package br.com.projeto.web.jogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.entity.Player;
import br.com.projeto.service.PlayerService;


@Controller
public class JogoLoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlayerService service;

	@RequestMapping("/jogo/login")
	public String login(@RequestParam(value="login",required=false) String login,
						 @RequestParam(value="password",required=false) String password) throws ServletException, IOException {
		
		Player player = service.login(login, password);
		
		if (player == null) {
			return "redirect:/jogo/";
		}

		return "redirect:/jogo/cases.action";
	}

	
	@RequestMapping("/jogo/logout")
	public String logout(HttpSession session) throws Exception {
		service.logout();
		return "redirect:/jogo";
	}
	
	
}