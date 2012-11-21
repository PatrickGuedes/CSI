package br.com.projeto.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.Case;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class CaseDaoTest {
	
	@Autowired
	private CaseDao caseDao;
	// numero total de casos que existem
	private int numCases;
	// Id do caso que deve ser utilizado par teste
	private final Integer caseId = 1;
	
	@Before
	public void init() {
		numCases = caseDao.total();
	}

	@Test
	public void allCases() {
		List<Case> allCases = caseDao.allCases();
		Assert.assertEquals(numCases, allCases.size());
	}
	
	@Test
	public void findById() {
		Case entity = caseDao.findById(caseId);
		
		if (entity == null) {
			Assert.fail("O ID utilizado para testar o caso nao existe");
		}
		
		Assert.assertEquals(caseId, entity.getId());
	}
	

}
