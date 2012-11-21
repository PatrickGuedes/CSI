package br.com.projeto.dao;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.entity.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})
public class LocationDaoTest {
	
	@Autowired
	private LocationDao locationDao;
	// ID do caso para realizar os testes
	private final int caseId = 1;
	// Quantida de locais que o caso deve possuir
	private final int numLocations = 2;
	// ID do local que deve existir para o caso escolhido
	private final Integer locationId = 1;
	
	@Test
	public void locationsByCase() {
		List<Location> locations = locationDao.locationsByCase(caseId);
		Assert.assertEquals(numLocations, locations.size());
	}
	
	@Test
	public void findById() {
		Location entity = locationDao.findById(locationId);
		
		if (entity == null) {
			Assert.fail("O ID utilizado para testar o local nao existe");
		}
		
		Assert.assertEquals(locationId, entity.getId());
	}
	
}
