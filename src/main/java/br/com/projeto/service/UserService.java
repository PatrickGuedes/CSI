package br.com.projeto.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.Case;
import br.com.projeto.entity.User;
import br.com.projeto.util.Constants;
import br.com.projeto.util.CryptUtils;

/**
 * @author Andre Santos
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserDao dao;

	
	public User login(String login,String password){

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		
		User user = dao.get(login, CryptUtils.md5(password));
		
		if (user == null) {
			return null;
		}
		
		session.setAttribute(Constants.USER_ADMIN, user);
		
		return user;

	}

	public void usuarios(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		List<User> users = dao.usuarios();
		session.setAttribute("Users", users);
	}

}
