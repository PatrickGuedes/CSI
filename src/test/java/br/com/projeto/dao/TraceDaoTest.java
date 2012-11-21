package br.com.projeto.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.Trace;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class TraceDaoTest {
	
	@Autowired
	private TraceDao traceDao;
	// ID do local que deve existir
	private final Integer locationId = 1;
	// Quantida de locais que o caso deve possuir
	private final int numTraces = 2;
	// ID da pista que deve existir
	private final Integer traceId = 1;
	
	@Test
	public void tracesByLocation() {
		List<Trace> traces = traceDao.tracesByLocation(locationId);
		Assert.assertEquals(numTraces, traces.size());
	}
	
	@Test
	public void findById() {
		Trace entity = traceDao.findById(traceId);
		
		if (entity == null) {
			Assert.fail("O ID utilizado para testar a pista nao existe");
		}
		
		Assert.assertEquals(traceId, entity.getId());
	}
	
}
