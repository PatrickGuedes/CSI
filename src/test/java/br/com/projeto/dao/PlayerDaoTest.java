package br.com.projeto.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.Player;
import br.com.projeto.entity.Case;
import br.com.projeto.entity.Trace;
import br.com.projeto.util.CryptUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class PlayerDaoTest {
	
	@Autowired
	private PlayerDao playerDao;
	// Identificador do player que deve ser testado
	private final Integer playerId = 1;
	
	@Before
	public void init() {
	}
	
	@Test
	public void findById() {
		Player entity = playerDao.findById(playerId);
		
		if (entity == null) {
			Assert.fail("O ID utilizado para testar o jogador nao existe");
		}
		
		Assert.assertEquals(playerId, entity.getId());
	}
	
	@Test
	public void login() {
		Player player = playerDao.login("csi", CryptUtils.md5("csi"));
		Assert.assertNotNull(player);
	}
	
	@Test
	public void cases() {
		List<Case> casesList = playerDao.getCases(playerId);
		Assert.assertEquals(3, casesList.size());
	}
	
	@Test
	public void tracesToProcess() {
		List<Trace> tracesList = playerDao.getTracesToProcess(playerId);
//		Assert.assertEquals(2, tracesList.size());
	}
	
	@Test
	public void locationTraces() {
		List<Trace> tracesList = null;
		
		tracesList = playerDao.getLocationTraces(playerId, 1);
//		Assert.assertEquals(0, tracesList.size());
		
		tracesList = playerDao.getLocationTraces(playerId, 2);
//		Assert.assertEquals(2, tracesList.size());
	}

}
