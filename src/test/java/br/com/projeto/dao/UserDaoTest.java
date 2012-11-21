package br.com.projeto.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class UserDaoTest {

	
			
	@Autowired
	private UserDao userDao;
	private final Integer userId = 1;
	
	@Test
	public void testGet() {
		String user = "admin";
		String pass = "1234";
		
		User result = userDao.get(user, pass);
		//User entity = userDao.
	}
	

}

