/*
 * Created on 6 Dec 2015 ( Time 04:08:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import tristi.general.bean.Pricehistory;
import tristi.general.bean.jpa.PricehistoryEntity;

import java.util.Date;

import tristi.general.business.service.jpa.impl.PricehistoryServiceImpl;
import tristi.general.business.service.jpa.mapping.PricehistoryServiceMapper;
import tristi.general.data.repository.jpa.PricehistoryJpaRepository;
import tristi.general.test.PricehistoryFactoryForTest;
import tristi.general.test.PricehistoryEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of PricehistoryService
 */
@RunWith(MockitoJUnitRunner.class)
public class PricehistoryServiceImplTest {

	@InjectMocks
	private PricehistoryServiceImpl pricehistoryService;
	@Mock
	private PricehistoryJpaRepository pricehistoryJpaRepository;
	@Mock
	private PricehistoryServiceMapper pricehistoryServiceMapper;
	
	private PricehistoryFactoryForTest pricehistoryFactoryForTest = new PricehistoryFactoryForTest();

	private PricehistoryEntityFactoryForTest pricehistoryEntityFactoryForTest = new PricehistoryEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String pricehistoryid = mockValues.nextString(255);
		
		PricehistoryEntity pricehistoryEntity = pricehistoryJpaRepository.findOne(pricehistoryid);
		
		Pricehistory pricehistory = pricehistoryFactoryForTest.newPricehistory();
		when(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntity)).thenReturn(pricehistory);

		// When
		Pricehistory pricehistoryFound = pricehistoryService.findById(pricehistoryid);

		// Then
		assertEquals(pricehistory.getPricehistoryid(),pricehistoryFound.getPricehistoryid());
	}

	@Test
	public void findAll() {
		// Given
		List<PricehistoryEntity> pricehistoryEntitys = new ArrayList<PricehistoryEntity>();
		PricehistoryEntity pricehistoryEntity1 = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		pricehistoryEntitys.add(pricehistoryEntity1);
		PricehistoryEntity pricehistoryEntity2 = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		pricehistoryEntitys.add(pricehistoryEntity2);
		when(pricehistoryJpaRepository.findAll()).thenReturn(pricehistoryEntitys);
		
		Pricehistory pricehistory1 = pricehistoryFactoryForTest.newPricehistory();
		when(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntity1)).thenReturn(pricehistory1);
		Pricehistory pricehistory2 = pricehistoryFactoryForTest.newPricehistory();
		when(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntity2)).thenReturn(pricehistory2);

		// When
		List<Pricehistory> pricehistorysFounds = pricehistoryService.findAll();

		// Then
		assertTrue(pricehistory1 == pricehistorysFounds.get(0));
		assertTrue(pricehistory2 == pricehistorysFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Pricehistory pricehistory = pricehistoryFactoryForTest.newPricehistory();

		PricehistoryEntity pricehistoryEntity = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		when(pricehistoryJpaRepository.findOne(pricehistory.getPricehistoryid())).thenReturn(null);
		
		pricehistoryEntity = new PricehistoryEntity();
		pricehistoryServiceMapper.mapPricehistoryToPricehistoryEntity(pricehistory, pricehistoryEntity);
		PricehistoryEntity pricehistoryEntitySaved = pricehistoryJpaRepository.save(pricehistoryEntity);
		
		Pricehistory pricehistorySaved = pricehistoryFactoryForTest.newPricehistory();
		when(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntitySaved)).thenReturn(pricehistorySaved);

		// When
		Pricehistory pricehistoryResult = pricehistoryService.create(pricehistory);

		// Then
		assertTrue(pricehistoryResult == pricehistorySaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Pricehistory pricehistory = pricehistoryFactoryForTest.newPricehistory();

		PricehistoryEntity pricehistoryEntity = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		when(pricehistoryJpaRepository.findOne(pricehistory.getPricehistoryid())).thenReturn(pricehistoryEntity);

		// When
		Exception exception = null;
		try {
			pricehistoryService.create(pricehistory);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		Pricehistory pricehistory = pricehistoryFactoryForTest.newPricehistory();

		PricehistoryEntity pricehistoryEntity = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		when(pricehistoryJpaRepository.findOne(pricehistory.getPricehistoryid())).thenReturn(pricehistoryEntity);
		
		PricehistoryEntity pricehistoryEntitySaved = pricehistoryEntityFactoryForTest.newPricehistoryEntity();
		when(pricehistoryJpaRepository.save(pricehistoryEntity)).thenReturn(pricehistoryEntitySaved);
		
		Pricehistory pricehistorySaved = pricehistoryFactoryForTest.newPricehistory();
		when(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntitySaved)).thenReturn(pricehistorySaved);

		// When
		Pricehistory pricehistoryResult = pricehistoryService.update(pricehistory);

		// Then
		verify(pricehistoryServiceMapper).mapPricehistoryToPricehistoryEntity(pricehistory, pricehistoryEntity);
		assertTrue(pricehistoryResult == pricehistorySaved);
	}

	@Test
	public void delete() {
		// Given
		String pricehistoryid = mockValues.nextString(255);

		// When
		pricehistoryService.delete(pricehistoryid);

		// Then
		verify(pricehistoryJpaRepository).delete(pricehistoryid);
		
	}

}
