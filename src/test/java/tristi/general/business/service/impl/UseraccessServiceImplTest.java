/*
 * Created on 6 Dec 2015 ( Time 04:09:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import tristi.general.bean.Useraccess;
import tristi.general.bean.jpa.UseraccessEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.UseraccessServiceImpl;
import tristi.general.business.service.jpa.mapping.UseraccessServiceMapper;
import tristi.general.data.repository.jpa.UseraccessJpaRepository;
import tristi.general.test.UseraccessFactoryForTest;
import tristi.general.test.UseraccessEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of UseraccessService
 */
@RunWith(MockitoJUnitRunner.class)
public class UseraccessServiceImplTest {

	@InjectMocks
	private UseraccessServiceImpl useraccessService;
	@Mock
	private UseraccessJpaRepository useraccessJpaRepository;
	@Mock
	private UseraccessServiceMapper useraccessServiceMapper;
	
	private UseraccessFactoryForTest useraccessFactoryForTest = new UseraccessFactoryForTest();

	private UseraccessEntityFactoryForTest useraccessEntityFactoryForTest = new UseraccessEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String userid = mockValues.nextString(255);
		
		UseraccessEntity useraccessEntity = useraccessJpaRepository.findOne(userid);
		
		Useraccess useraccess = useraccessFactoryForTest.newUseraccess();
		when(useraccessServiceMapper.mapUseraccessEntityToUseraccess(useraccessEntity)).thenReturn(useraccess);

		// When
		Useraccess useraccessFound = useraccessService.findById(userid);

		// Then
		assertEquals(useraccess.getUserid(),useraccessFound.getUserid());
	}

	@Test
	public void findAll() {
		// Given
		List<UseraccessEntity> useraccessEntitys = new ArrayList<UseraccessEntity>();
		UseraccessEntity useraccessEntity1 = useraccessEntityFactoryForTest.newUseraccessEntity();
		useraccessEntitys.add(useraccessEntity1);
		UseraccessEntity useraccessEntity2 = useraccessEntityFactoryForTest.newUseraccessEntity();
		useraccessEntitys.add(useraccessEntity2);
		when(useraccessJpaRepository.findAll()).thenReturn(useraccessEntitys);
		
		Useraccess useraccess1 = useraccessFactoryForTest.newUseraccess();
		when(useraccessServiceMapper.mapUseraccessEntityToUseraccess(useraccessEntity1)).thenReturn(useraccess1);
		Useraccess useraccess2 = useraccessFactoryForTest.newUseraccess();
		when(useraccessServiceMapper.mapUseraccessEntityToUseraccess(useraccessEntity2)).thenReturn(useraccess2);

		// When
		List<Useraccess> useraccesssFounds = useraccessService.findAll();

		// Then
		assertTrue(useraccess1 == useraccesssFounds.get(0));
		assertTrue(useraccess2 == useraccesssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Useraccess useraccess = useraccessFactoryForTest.newUseraccess();

		UseraccessEntity useraccessEntity = useraccessEntityFactoryForTest.newUseraccessEntity();
		when(useraccessJpaRepository.findOne(useraccess.getUserid())).thenReturn(null);
		
		useraccessEntity = new UseraccessEntity();
		useraccessServiceMapper.mapUseraccessToUseraccessEntity(useraccess, useraccessEntity);
		UseraccessEntity useraccessEntitySaved = useraccessJpaRepository.save(useraccessEntity);
		
		Useraccess useraccessSaved = useraccessFactoryForTest.newUseraccess();
		when(useraccessServiceMapper.mapUseraccessEntityToUseraccess(useraccessEntitySaved)).thenReturn(useraccessSaved);

		// When
		Useraccess useraccessResult = useraccessService.create(useraccess);

		// Then
		assertTrue(useraccessResult == useraccessSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Useraccess useraccess = useraccessFactoryForTest.newUseraccess();

		UseraccessEntity useraccessEntity = useraccessEntityFactoryForTest.newUseraccessEntity();
		when(useraccessJpaRepository.findOne(useraccess.getUserid())).thenReturn(useraccessEntity);

		// When
		Exception exception = null;
		try {
			useraccessService.create(useraccess);
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
		Useraccess useraccess = useraccessFactoryForTest.newUseraccess();

		UseraccessEntity useraccessEntity = useraccessEntityFactoryForTest.newUseraccessEntity();
		when(useraccessJpaRepository.findOne(useraccess.getUserid())).thenReturn(useraccessEntity);
		
		UseraccessEntity useraccessEntitySaved = useraccessEntityFactoryForTest.newUseraccessEntity();
		when(useraccessJpaRepository.save(useraccessEntity)).thenReturn(useraccessEntitySaved);
		
		Useraccess useraccessSaved = useraccessFactoryForTest.newUseraccess();
		when(useraccessServiceMapper.mapUseraccessEntityToUseraccess(useraccessEntitySaved)).thenReturn(useraccessSaved);

		// When
		Useraccess useraccessResult = useraccessService.update(useraccess);

		// Then
		verify(useraccessServiceMapper).mapUseraccessToUseraccessEntity(useraccess, useraccessEntity);
		assertTrue(useraccessResult == useraccessSaved);
	}

	@Test
	public void delete() {
		// Given
		String userid = mockValues.nextString(255);

		// When
		useraccessService.delete(userid);

		// Then
		verify(useraccessJpaRepository).delete(userid);
		
	}

}
