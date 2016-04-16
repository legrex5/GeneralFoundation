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

import tristi.general.bean.Purchaseorder;
import tristi.general.bean.jpa.PurchaseorderEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.PurchaseorderServiceImpl;
import tristi.general.business.service.jpa.mapping.PurchaseorderServiceMapper;
import tristi.general.data.repository.jpa.PurchaseorderJpaRepository;
import tristi.general.test.PurchaseorderFactoryForTest;
import tristi.general.test.PurchaseorderEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of PurchaseorderService
 */
@RunWith(MockitoJUnitRunner.class)
public class PurchaseorderServiceImplTest {

	@InjectMocks
	private PurchaseorderServiceImpl purchaseorderService;
	@Mock
	private PurchaseorderJpaRepository purchaseorderJpaRepository;
	@Mock
	private PurchaseorderServiceMapper purchaseorderServiceMapper;
	
	private PurchaseorderFactoryForTest purchaseorderFactoryForTest = new PurchaseorderFactoryForTest();

	private PurchaseorderEntityFactoryForTest purchaseorderEntityFactoryForTest = new PurchaseorderEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String purchaseorderid = mockValues.nextString(255);
		
		PurchaseorderEntity purchaseorderEntity = purchaseorderJpaRepository.findOne(purchaseorderid);
		
		Purchaseorder purchaseorder = purchaseorderFactoryForTest.newPurchaseorder();
		when(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntity)).thenReturn(purchaseorder);

		// When
		Purchaseorder purchaseorderFound = purchaseorderService.findById(purchaseorderid);

		// Then
		assertEquals(purchaseorder.getPurchaseorderid(),purchaseorderFound.getPurchaseorderid());
	}

	@Test
	public void findAll() {
		// Given
		List<PurchaseorderEntity> purchaseorderEntitys = new ArrayList<PurchaseorderEntity>();
		PurchaseorderEntity purchaseorderEntity1 = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		purchaseorderEntitys.add(purchaseorderEntity1);
		PurchaseorderEntity purchaseorderEntity2 = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		purchaseorderEntitys.add(purchaseorderEntity2);
		when(purchaseorderJpaRepository.findAll()).thenReturn(purchaseorderEntitys);
		
		Purchaseorder purchaseorder1 = purchaseorderFactoryForTest.newPurchaseorder();
		when(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntity1)).thenReturn(purchaseorder1);
		Purchaseorder purchaseorder2 = purchaseorderFactoryForTest.newPurchaseorder();
		when(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntity2)).thenReturn(purchaseorder2);

		// When
		List<Purchaseorder> purchaseordersFounds = purchaseorderService.findAll();

		// Then
		assertTrue(purchaseorder1 == purchaseordersFounds.get(0));
		assertTrue(purchaseorder2 == purchaseordersFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Purchaseorder purchaseorder = purchaseorderFactoryForTest.newPurchaseorder();

		PurchaseorderEntity purchaseorderEntity = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		when(purchaseorderJpaRepository.findOne(purchaseorder.getPurchaseorderid())).thenReturn(null);
		
		purchaseorderEntity = new PurchaseorderEntity();
		purchaseorderServiceMapper.mapPurchaseorderToPurchaseorderEntity(purchaseorder, purchaseorderEntity);
		PurchaseorderEntity purchaseorderEntitySaved = purchaseorderJpaRepository.save(purchaseorderEntity);
		
		Purchaseorder purchaseorderSaved = purchaseorderFactoryForTest.newPurchaseorder();
		when(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntitySaved)).thenReturn(purchaseorderSaved);

		// When
		Purchaseorder purchaseorderResult = purchaseorderService.create(purchaseorder);

		// Then
		assertTrue(purchaseorderResult == purchaseorderSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Purchaseorder purchaseorder = purchaseorderFactoryForTest.newPurchaseorder();

		PurchaseorderEntity purchaseorderEntity = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		when(purchaseorderJpaRepository.findOne(purchaseorder.getPurchaseorderid())).thenReturn(purchaseorderEntity);

		// When
		Exception exception = null;
		try {
			purchaseorderService.create(purchaseorder);
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
		Purchaseorder purchaseorder = purchaseorderFactoryForTest.newPurchaseorder();

		PurchaseorderEntity purchaseorderEntity = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		when(purchaseorderJpaRepository.findOne(purchaseorder.getPurchaseorderid())).thenReturn(purchaseorderEntity);
		
		PurchaseorderEntity purchaseorderEntitySaved = purchaseorderEntityFactoryForTest.newPurchaseorderEntity();
		when(purchaseorderJpaRepository.save(purchaseorderEntity)).thenReturn(purchaseorderEntitySaved);
		
		Purchaseorder purchaseorderSaved = purchaseorderFactoryForTest.newPurchaseorder();
		when(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntitySaved)).thenReturn(purchaseorderSaved);

		// When
		Purchaseorder purchaseorderResult = purchaseorderService.update(purchaseorder);

		// Then
		verify(purchaseorderServiceMapper).mapPurchaseorderToPurchaseorderEntity(purchaseorder, purchaseorderEntity);
		assertTrue(purchaseorderResult == purchaseorderSaved);
	}

	@Test
	public void delete() {
		// Given
		String purchaseorderid = mockValues.nextString(255);

		// When
		purchaseorderService.delete(purchaseorderid);

		// Then
		verify(purchaseorderJpaRepository).delete(purchaseorderid);
		
	}

}