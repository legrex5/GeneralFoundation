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

import tristi.general.bean.Productuom;
import tristi.general.bean.jpa.ProductuomEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.ProductuomServiceImpl;
import tristi.general.business.service.jpa.mapping.ProductuomServiceMapper;
import tristi.general.data.repository.jpa.ProductuomJpaRepository;
import tristi.general.test.ProductuomFactoryForTest;
import tristi.general.test.ProductuomEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ProductuomService
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductuomServiceImplTest {

	@InjectMocks
	private ProductuomServiceImpl productuomService;
	@Mock
	private ProductuomJpaRepository productuomJpaRepository;
	@Mock
	private ProductuomServiceMapper productuomServiceMapper;
	
	private ProductuomFactoryForTest productuomFactoryForTest = new ProductuomFactoryForTest();

	private ProductuomEntityFactoryForTest productuomEntityFactoryForTest = new ProductuomEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String productuomid = mockValues.nextString(255);
		
		ProductuomEntity productuomEntity = productuomJpaRepository.findOne(productuomid);
		
		Productuom productuom = productuomFactoryForTest.newProductuom();
		when(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntity)).thenReturn(productuom);

		// When
		Productuom productuomFound = productuomService.findById(productuomid);

		// Then
		assertEquals(productuom.getProductuomid(),productuomFound.getProductuomid());
	}

	@Test
	public void findAll() {
		// Given
		List<ProductuomEntity> productuomEntitys = new ArrayList<ProductuomEntity>();
		ProductuomEntity productuomEntity1 = productuomEntityFactoryForTest.newProductuomEntity();
		productuomEntitys.add(productuomEntity1);
		ProductuomEntity productuomEntity2 = productuomEntityFactoryForTest.newProductuomEntity();
		productuomEntitys.add(productuomEntity2);
		when(productuomJpaRepository.findAll()).thenReturn(productuomEntitys);
		
		Productuom productuom1 = productuomFactoryForTest.newProductuom();
		when(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntity1)).thenReturn(productuom1);
		Productuom productuom2 = productuomFactoryForTest.newProductuom();
		when(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntity2)).thenReturn(productuom2);

		// When
		List<Productuom> productuomsFounds = productuomService.findAll();

		// Then
		assertTrue(productuom1 == productuomsFounds.get(0));
		assertTrue(productuom2 == productuomsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Productuom productuom = productuomFactoryForTest.newProductuom();

		ProductuomEntity productuomEntity = productuomEntityFactoryForTest.newProductuomEntity();
		when(productuomJpaRepository.findOne(productuom.getProductuomid())).thenReturn(null);
		
		productuomEntity = new ProductuomEntity();
		productuomServiceMapper.mapProductuomToProductuomEntity(productuom, productuomEntity);
		ProductuomEntity productuomEntitySaved = productuomJpaRepository.save(productuomEntity);
		
		Productuom productuomSaved = productuomFactoryForTest.newProductuom();
		when(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntitySaved)).thenReturn(productuomSaved);

		// When
		Productuom productuomResult = productuomService.create(productuom);

		// Then
		assertTrue(productuomResult == productuomSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Productuom productuom = productuomFactoryForTest.newProductuom();

		ProductuomEntity productuomEntity = productuomEntityFactoryForTest.newProductuomEntity();
		when(productuomJpaRepository.findOne(productuom.getProductuomid())).thenReturn(productuomEntity);

		// When
		Exception exception = null;
		try {
			productuomService.create(productuom);
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
		Productuom productuom = productuomFactoryForTest.newProductuom();

		ProductuomEntity productuomEntity = productuomEntityFactoryForTest.newProductuomEntity();
		when(productuomJpaRepository.findOne(productuom.getProductuomid())).thenReturn(productuomEntity);
		
		ProductuomEntity productuomEntitySaved = productuomEntityFactoryForTest.newProductuomEntity();
		when(productuomJpaRepository.save(productuomEntity)).thenReturn(productuomEntitySaved);
		
		Productuom productuomSaved = productuomFactoryForTest.newProductuom();
		when(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntitySaved)).thenReturn(productuomSaved);

		// When
		Productuom productuomResult = productuomService.update(productuom);

		// Then
		verify(productuomServiceMapper).mapProductuomToProductuomEntity(productuom, productuomEntity);
		assertTrue(productuomResult == productuomSaved);
	}

	@Test
	public void delete() {
		// Given
		String productuomid = mockValues.nextString(255);

		// When
		productuomService.delete(productuomid);

		// Then
		verify(productuomJpaRepository).delete(productuomid);
		
	}

}