package br.com.projeto.web.adm;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.service.UserService;

@Controller
public class UserController {
private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;

	@RequestMapping("/adm/user")
	public String list() throws ServletException, IOException {
		service.allUsers();
		return "/adm/user.jsp";
	}
	
	@RequestMapping("/adm/user/add")
	public ModelAndView add(@RequestParam(value="login",required=true) String login,
			                @RequestParam(value="password",required=true) String password) throws ServletException, IOException {
//		service.addUser(login, password);
        Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("FlashMessage", "Usuário adicionado com sucesso");
		
		return new ModelAndView("/adm/user.jsp", "model", map);
	}
	
	@RequestMapping("/adm/user/edit")
	public ModelAndView edit(@RequestParam(value="userId",required=true) String userId) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("User", service.editUser(Long.parseLong(userId)));
		
		return new ModelAndView("/adm/userEdit.jsp", "model", map);
	}
	
	@RequestMapping("/adm/user/rm")
	public String remove(@RequestParam(value="userId",required=true) String userId) throws ServletException, IOException {
		return "/adm/user.jsp";
	}
	
	@RequestMapping("/adm/user/update")
	public String update(@RequestParam(value="userId",required=true) String userId) throws ServletException, IOException {
		return "/adm/user.jsp";
	}
}
