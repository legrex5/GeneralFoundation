/*
 * Created on 6 Dec 2015 ( Time 04:08:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import tristi.general.bean.Salesorderdtl;
import tristi.general.bean.jpa.SalesorderdtlEntity;

import java.util.Date;

import tristi.general.business.service.jpa.impl.SalesorderdtlServiceImpl;
import tristi.general.business.service.jpa.mapping.SalesorderdtlServiceMapper;
import tristi.general.data.repository.jpa.SalesorderdtlJpaRepository;
import tristi.general.test.SalesorderdtlFactoryForTest;
import tristi.general.test.SalesorderdtlEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of SalesorderdtlService
 */
@RunWith(MockitoJUnitRunner.class)
public class SalesorderdtlServiceImplTest {

	@InjectMocks
	private SalesorderdtlServiceImpl salesorderdtlService;
	@Mock
	private SalesorderdtlJpaRepository salesorderdtlJpaRepository;
	@Mock
	private SalesorderdtlServiceMapper salesorderdtlServiceMapper;
	
	private SalesorderdtlFactoryForTest salesorderdtlFactoryForTest = new SalesorderdtlFactoryForTest();

	private SalesorderdtlEntityFactoryForTest salesorderdtlEntityFactoryForTest = new SalesorderdtlEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String salesorderdtlid = mockValues.nextString(255);
		
		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlJpaRepository.findOne(salesorderdtlid);
		
		Salesorderdtl salesorderdtl = salesorderdtlFactoryForTest.newSalesorderdtl();
		when(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntity)).thenReturn(salesorderdtl);

		// When
		Salesorderdtl salesorderdtlFound = salesorderdtlService.findById(salesorderdtlid);

		// Then
		assertEquals(salesorderdtl.getSalesorderdtlid(),salesorderdtlFound.getSalesorderdtlid());
	}

	@Test
	public void findAll() {
		// Given
		List<SalesorderdtlEntity> salesorderdtlEntitys = new ArrayList<SalesorderdtlEntity>();
		SalesorderdtlEntity salesorderdtlEntity1 = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		salesorderdtlEntitys.add(salesorderdtlEntity1);
		SalesorderdtlEntity salesorderdtlEntity2 = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		salesorderdtlEntitys.add(salesorderdtlEntity2);
		when(salesorderdtlJpaRepository.findAll()).thenReturn(salesorderdtlEntitys);
		
		Salesorderdtl salesorderdtl1 = salesorderdtlFactoryForTest.newSalesorderdtl();
		when(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntity1)).thenReturn(salesorderdtl1);
		Salesorderdtl salesorderdtl2 = salesorderdtlFactoryForTest.newSalesorderdtl();
		when(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntity2)).thenReturn(salesorderdtl2);

		// When
		List<Salesorderdtl> salesorderdtlsFounds = salesorderdtlService.findAll();

		// Then
		assertTrue(salesorderdtl1 == salesorderdtlsFounds.get(0));
		assertTrue(salesorderdtl2 == salesorderdtlsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Salesorderdtl salesorderdtl = salesorderdtlFactoryForTest.newSalesorderdtl();

		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		when(salesorderdtlJpaRepository.findOne(salesorderdtl.getSalesorderdtlid())).thenReturn(null);
		
		salesorderdtlEntity = new SalesorderdtlEntity();
		salesorderdtlServiceMapper.mapSalesorderdtlToSalesorderdtlEntity(salesorderdtl, salesorderdtlEntity);
		SalesorderdtlEntity salesorderdtlEntitySaved = salesorderdtlJpaRepository.save(salesorderdtlEntity);
		
		Salesorderdtl salesorderdtlSaved = salesorderdtlFactoryForTest.newSalesorderdtl();
		when(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntitySaved)).thenReturn(salesorderdtlSaved);

		// When
		Salesorderdtl salesorderdtlResult = salesorderdtlService.create(salesorderdtl);

		// Then
		assertTrue(salesorderdtlResult == salesorderdtlSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Salesorderdtl salesorderdtl = salesorderdtlFactoryForTest.newSalesorderdtl();

		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		when(salesorderdtlJpaRepository.findOne(salesorderdtl.getSalesorderdtlid())).thenReturn(salesorderdtlEntity);

		// When
		Exception exception = null;
		try {
			salesorderdtlService.create(salesorderdtl);
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
		Salesorderdtl salesorderdtl = salesorderdtlFactoryForTest.newSalesorderdtl();

		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		when(salesorderdtlJpaRepository.findOne(salesorderdtl.getSalesorderdtlid())).thenReturn(salesorderdtlEntity);
		
		SalesorderdtlEntity salesorderdtlEntitySaved = salesorderdtlEntityFactoryForTest.newSalesorderdtlEntity();
		when(salesorderdtlJpaRepository.save(salesorderdtlEntity)).thenReturn(salesorderdtlEntitySaved);
		
		Salesorderdtl salesorderdtlSaved = salesorderdtlFactoryForTest.newSalesorderdtl();
		when(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntitySaved)).thenReturn(salesorderdtlSaved);

		// When
		Salesorderdtl salesorderdtlResult = salesorderdtlService.update(salesorderdtl);

		// Then
		verify(salesorderdtlServiceMapper).mapSalesorderdtlToSalesorderdtlEntity(salesorderdtl, salesorderdtlEntity);
		assertTrue(salesorderdtlResult == salesorderdtlSaved);
	}

	@Test
	public void delete() {
		// Given
		String salesorderdtlid = mockValues.nextString(255);

		// When
		salesorderdtlService.delete(salesorderdtlid);

		// Then
		verify(salesorderdtlJpaRepository).delete(salesorderdtlid);
		
	}

}
