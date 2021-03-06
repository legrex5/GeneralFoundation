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

import tristi.general.bean.Location;
import tristi.general.bean.jpa.LocationEntity;

import java.util.Date;
import java.util.List;

import tristi.general.business.service.jpa.impl.LocationServiceImpl;
import tristi.general.business.service.jpa.mapping.LocationServiceMapper;
import tristi.general.data.repository.jpa.LocationJpaRepository;
import tristi.general.test.LocationFactoryForTest;
import tristi.general.test.LocationEntityFactoryForTest;
import tristi.general.test.MockValues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of LocationService
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

	@InjectMocks
	private LocationServiceImpl locationService;
	@Mock
	private LocationJpaRepository locationJpaRepository;
	@Mock
	private LocationServiceMapper locationServiceMapper;
	
	private LocationFactoryForTest locationFactoryForTest = new LocationFactoryForTest();

	private LocationEntityFactoryForTest locationEntityFactoryForTest = new LocationEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		String locationid = mockValues.nextString(255);
		
		LocationEntity locationEntity = locationJpaRepository.findOne(locationid);
		
		Location location = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity)).thenReturn(location);

		// When
		Location locationFound = locationService.findById(locationid);

		// Then
		assertEquals(location.getLocationid(),locationFound.getLocationid());
	}

	@Test
	public void findAll() {
		// Given
		List<LocationEntity> locationEntitys = new ArrayList<LocationEntity>();
		LocationEntity locationEntity1 = locationEntityFactoryForTest.newLocationEntity();
		locationEntitys.add(locationEntity1);
		LocationEntity locationEntity2 = locationEntityFactoryForTest.newLocationEntity();
		locationEntitys.add(locationEntity2);
		when(locationJpaRepository.findAll()).thenReturn(locationEntitys);
		
		Location location1 = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity1)).thenReturn(location1);
		Location location2 = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity2)).thenReturn(location2);

		// When
		List<Location> locationsFounds = locationService.findAll();

		// Then
		assertTrue(location1 == locationsFounds.get(0));
		assertTrue(location2 == locationsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocationid())).thenReturn(null);
		
		locationEntity = new LocationEntity();
		locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
		LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
		
		Location locationSaved = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved)).thenReturn(locationSaved);

		// When
		Location locationResult = locationService.create(location);

		// Then
		assertTrue(locationResult == locationSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocationid())).thenReturn(locationEntity);

		// When
		Exception exception = null;
		try {
			locationService.create(location);
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
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocationid())).thenReturn(locationEntity);
		
		LocationEntity locationEntitySaved = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.save(locationEntity)).thenReturn(locationEntitySaved);
		
		Location locationSaved = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved)).thenReturn(locationSaved);

		// When
		Location locationResult = locationService.update(location);

		// Then
		verify(locationServiceMapper).mapLocationToLocationEntity(location, locationEntity);
		assertTrue(locationResult == locationSaved);
	}

	@Test
	public void delete() {
		// Given
		String locationid = mockValues.nextString(255);

		// When
		locationService.delete(locationid);

		// Then
		verify(locationJpaRepository).delete(locationid);
		
	}

}
