package br.com.projeto.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.User;
import br.com.projeto.util.CryptUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class UserDaoTest {
			
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGet() {
		String user = "admin";
		String pass = "123456";
		
		User result = userDao.get(user, CryptUtils.md5(pass));
		
		Assert.assertNotNull(result);
	}
	

}

