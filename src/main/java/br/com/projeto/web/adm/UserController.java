package br.com.projeto.web.adm;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.service.UserService;
import br.com.projeto.util.Constants;

@Controller
public class UserController {
private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;


	@RequestMapping("/adm/user")
	public String listar() throws ServletException, IOException {
		service.usuarios();
		return "/adm/user.jsp";
	}
}
