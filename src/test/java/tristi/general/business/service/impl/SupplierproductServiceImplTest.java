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

import tristi.general.bean.Supplierproduct;
import tristi.general.bean.jpa.SupplierproductEntity;

import java.util.Date;

import tristi.general.business.service.jpa.impl.SupplierproductServiceImpl;
import tristi.general.business.service.jpa.mapping.SupplierproductServiceMapper;
import tristi.general.data.repository.jpa.SupplierproductJpaRepository;
import tristi.general.test.SupplierproductFactoryForTest;
import tristi.general.test.SupplierproductEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of SupplierproductService
 */
@RunWith(MockitoJUnitRunner.class)
public class SupplierproductServiceImplTest {

	@InjectMocks
	private SupplierproductServiceImpl supplierproductService;
	@Mock
	private SupplierproductJpaRepository supplierproductJpaRepository;
	@Mock
	private SupplierproductServiceMapper supplierproductServiceMapper;
	
	private SupplierproductFactoryForTest supplierproductFactoryForTest = new SupplierproductFactoryForTest();

	private SupplierproductEntityFactoryForTest supplierproductEntityFactoryForTest = new SupplierproductEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String supplierproductid = mockValues.nextString(255);
		
		SupplierproductEntity supplierproductEntity = supplierproductJpaRepository.findOne(supplierproductid);
		
		Supplierproduct supplierproduct = supplierproductFactoryForTest.newSupplierproduct();
		when(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntity)).thenReturn(supplierproduct);

		// When
		Supplierproduct supplierproductFound = supplierproductService.findById(supplierproductid);

		// Then
		assertEquals(supplierproduct.getSupplierproductid(),supplierproductFound.getSupplierproductid());
	}

	@Test
	public void findAll() {
		// Given
		List<SupplierproductEntity> supplierproductEntitys = new ArrayList<SupplierproductEntity>();
		SupplierproductEntity supplierproductEntity1 = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		supplierproductEntitys.add(supplierproductEntity1);
		SupplierproductEntity supplierproductEntity2 = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		supplierproductEntitys.add(supplierproductEntity2);
		when(supplierproductJpaRepository.findAll()).thenReturn(supplierproductEntitys);
		
		Supplierproduct supplierproduct1 = supplierproductFactoryForTest.newSupplierproduct();
		when(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntity1)).thenReturn(supplierproduct1);
		Supplierproduct supplierproduct2 = supplierproductFactoryForTest.newSupplierproduct();
		when(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntity2)).thenReturn(supplierproduct2);

		// When
		List<Supplierproduct> supplierproductsFounds = supplierproductService.findAll();

		// Then
		assertTrue(supplierproduct1 == supplierproductsFounds.get(0));
		assertTrue(supplierproduct2 == supplierproductsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Supplierproduct supplierproduct = supplierproductFactoryForTest.newSupplierproduct();

		SupplierproductEntity supplierproductEntity = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		when(supplierproductJpaRepository.findOne(supplierproduct.getSupplierproductid())).thenReturn(null);
		
		supplierproductEntity = new SupplierproductEntity();
		supplierproductServiceMapper.mapSupplierproductToSupplierproductEntity(supplierproduct, supplierproductEntity);
		SupplierproductEntity supplierproductEntitySaved = supplierproductJpaRepository.save(supplierproductEntity);
		
		Supplierproduct supplierproductSaved = supplierproductFactoryForTest.newSupplierproduct();
		when(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntitySaved)).thenReturn(supplierproductSaved);

		// When
		Supplierproduct supplierproductResult = supplierproductService.create(supplierproduct);

		// Then
		assertTrue(supplierproductResult == supplierproductSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Supplierproduct supplierproduct = supplierproductFactoryForTest.newSupplierproduct();

		SupplierproductEntity supplierproductEntity = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		when(supplierproductJpaRepository.findOne(supplierproduct.getSupplierproductid())).thenReturn(supplierproductEntity);

		// When
		Exception exception = null;
		try {
			supplierproductService.create(supplierproduct);
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
		Supplierproduct supplierproduct = supplierproductFactoryForTest.newSupplierproduct();

		SupplierproductEntity supplierproductEntity = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		when(supplierproductJpaRepository.findOne(supplierproduct.getSupplierproductid())).thenReturn(supplierproductEntity);
		
		SupplierproductEntity supplierproductEntitySaved = supplierproductEntityFactoryForTest.newSupplierproductEntity();
		when(supplierproductJpaRepository.save(supplierproductEntity)).thenReturn(supplierproductEntitySaved);
		
		Supplierproduct supplierproductSaved = supplierproductFactoryForTest.newSupplierproduct();
		when(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntitySaved)).thenReturn(supplierproductSaved);

		// When
		Supplierproduct supplierproductResult = supplierproductService.update(supplierproduct);

		// Then
		verify(supplierproductServiceMapper).mapSupplierproductToSupplierproductEntity(supplierproduct, supplierproductEntity);
		assertTrue(supplierproductResult == supplierproductSaved);
	}

	@Test
	public void delete() {
		// Given
		String supplierproductid = mockValues.nextString(255);

		// When
		supplierproductService.delete(supplierproductid);

		// Then
		verify(supplierproductJpaRepository).delete(supplierproductid);
		
	}

}