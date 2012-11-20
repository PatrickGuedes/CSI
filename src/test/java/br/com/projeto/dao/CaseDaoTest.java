package br.com.projeto.dao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Case;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class CaseDaoTest {
	
	@Autowired
	private CaseDao caseDao;
	private int numCases;
	
	@Before
	public void init() {
		numCases = caseDao.totalCases();
		System.out.println("Total de casos iniciais: " + numCases);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void createNewCase() {
		Case entity = new Case();
		entity.setSubject("Caso JUnit");
		entity.setDescription("Descricao do caso Junit");
		
		caseDao.insert(entity);
		
		Assert.assertEquals(caseDao.totalCases(), numCases+1);
	}
	

}
