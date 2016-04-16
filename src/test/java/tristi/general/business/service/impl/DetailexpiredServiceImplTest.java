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

import tristi.general.bean.Detailexpired;
import tristi.general.bean.jpa.DetailexpiredEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.DetailexpiredServiceImpl;
import tristi.general.business.service.jpa.mapping.DetailexpiredServiceMapper;
import tristi.general.data.repository.jpa.DetailexpiredJpaRepository;
import tristi.general.test.DetailexpiredFactoryForTest;
import tristi.general.test.DetailexpiredEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of DetailexpiredService
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailexpiredServiceImplTest {

	@InjectMocks
	private DetailexpiredServiceImpl detailexpiredService;
	@Mock
	private DetailexpiredJpaRepository detailexpiredJpaRepository;
	@Mock
	private DetailexpiredServiceMapper detailexpiredServiceMapper;
	
	private DetailexpiredFactoryForTest detailexpiredFactoryForTest = new DetailexpiredFactoryForTest();

	private DetailexpiredEntityFactoryForTest detailexpiredEntityFactoryForTest = new DetailexpiredEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String detailexpiredid = mockValues.nextString(255);
		
		DetailexpiredEntity detailexpiredEntity = detailexpiredJpaRepository.findOne(detailexpiredid);
		
		Detailexpired detailexpired = detailexpiredFactoryForTest.newDetailexpired();
		when(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntity)).thenReturn(detailexpired);

		// When
		Detailexpired detailexpiredFound = detailexpiredService.findById(detailexpiredid);

		// Then
		assertEquals(detailexpired.getDetailexpiredid(),detailexpiredFound.getDetailexpiredid());
	}

	@Test
	public void findAll() {
		// Given
		List<DetailexpiredEntity> detailexpiredEntitys = new ArrayList<DetailexpiredEntity>();
		DetailexpiredEntity detailexpiredEntity1 = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		detailexpiredEntitys.add(detailexpiredEntity1);
		DetailexpiredEntity detailexpiredEntity2 = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		detailexpiredEntitys.add(detailexpiredEntity2);
		when(detailexpiredJpaRepository.findAll()).thenReturn(detailexpiredEntitys);
		
		Detailexpired detailexpired1 = detailexpiredFactoryForTest.newDetailexpired();
		when(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntity1)).thenReturn(detailexpired1);
		Detailexpired detailexpired2 = detailexpiredFactoryForTest.newDetailexpired();
		when(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntity2)).thenReturn(detailexpired2);

		// When
		List<Detailexpired> detailexpiredsFounds = detailexpiredService.findAll();

		// Then
		assertTrue(detailexpired1 == detailexpiredsFounds.get(0));
		assertTrue(detailexpired2 == detailexpiredsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Detailexpired detailexpired = detailexpiredFactoryForTest.newDetailexpired();

		DetailexpiredEntity detailexpiredEntity = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		when(detailexpiredJpaRepository.findOne(detailexpired.getDetailexpiredid())).thenReturn(null);
		
		detailexpiredEntity = new DetailexpiredEntity();
		detailexpiredServiceMapper.mapDetailexpiredToDetailexpiredEntity(detailexpired, detailexpiredEntity);
		DetailexpiredEntity detailexpiredEntitySaved = detailexpiredJpaRepository.save(detailexpiredEntity);
		
		Detailexpired detailexpiredSaved = detailexpiredFactoryForTest.newDetailexpired();
		when(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntitySaved)).thenReturn(detailexpiredSaved);

		// When
		Detailexpired detailexpiredResult = detailexpiredService.create(detailexpired);

		// Then
		assertTrue(detailexpiredResult == detailexpiredSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Detailexpired detailexpired = detailexpiredFactoryForTest.newDetailexpired();

		DetailexpiredEntity detailexpiredEntity = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		when(detailexpiredJpaRepository.findOne(detailexpired.getDetailexpiredid())).thenReturn(detailexpiredEntity);

		// When
		Exception exception = null;
		try {
			detailexpiredService.create(detailexpired);
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
		Detailexpired detailexpired = detailexpiredFactoryForTest.newDetailexpired();

		DetailexpiredEntity detailexpiredEntity = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		when(detailexpiredJpaRepository.findOne(detailexpired.getDetailexpiredid())).thenReturn(detailexpiredEntity);
		
		DetailexpiredEntity detailexpiredEntitySaved = detailexpiredEntityFactoryForTest.newDetailexpiredEntity();
		when(detailexpiredJpaRepository.save(detailexpiredEntity)).thenReturn(detailexpiredEntitySaved);
		
		Detailexpired detailexpiredSaved = detailexpiredFactoryForTest.newDetailexpired();
		when(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntitySaved)).thenReturn(detailexpiredSaved);

		// When
		Detailexpired detailexpiredResult = detailexpiredService.update(detailexpired);

		// Then
		verify(detailexpiredServiceMapper).mapDetailexpiredToDetailexpiredEntity(detailexpired, detailexpiredEntity);
		assertTrue(detailexpiredResult == detailexpiredSaved);
	}

	@Test
	public void delete() {
		// Given
		String detailexpiredid = mockValues.nextString(255);

		// When
		detailexpiredService.delete(detailexpiredid);

		// Then
		verify(detailexpiredJpaRepository).delete(detailexpiredid);
		
	}

}
