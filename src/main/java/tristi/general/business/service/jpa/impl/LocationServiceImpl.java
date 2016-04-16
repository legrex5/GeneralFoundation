/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tristi.general.bean.Location;
import tristi.general.bean.jpa.LocationEntity;
import tristi.general.business.service.LocationService;
import tristi.general.business.service.jpa.mapping.LocationServiceMapper;
import tristi.general.data.repository.jpa.LocationJpaRepository;

/**
 * Implementation of LocationService
 */
@Component
@Transactional
public class LocationServiceImpl implements LocationService {

	@Resource
	private LocationJpaRepository locationJpaRepository;

	@Resource
	private LocationServiceMapper locationServiceMapper;
	
	@Override
	public Location findById(String locationid) {
		LocationEntity locationEntity = locationJpaRepository.findOne(locationid);
		return locationServiceMapper.mapLocationEntityToLocation(locationEntity);
	}

	@Override
	public List<Location> findAll() {
		Iterable<LocationEntity> entities = locationJpaRepository.findAll();
		List<Location> beans = new ArrayList<Location>();
		for(LocationEntity locationEntity : entities) {
			beans.add(locationServiceMapper.mapLocationEntityToLocation(locationEntity));
		}
		return beans;
	}

	@Override
	public Location save(Location location) {
		return update(location) ;
	}

	@Override
	public Location create(Location location) {
		LocationEntity locationEntity = locationJpaRepository.findOne(location.getLocationid());
		if( locationEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		locationEntity = new LocationEntity();
		locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
		LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
		return locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved);
	}

	@Override
	public Location update(Location location) {
		LocationEntity locationEntity = locationJpaRepository.findOne(location.getLocationid());
		locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
		LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
		return locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved);
	}

	@Override
	public void delete(String locationid) {
		locationJpaRepository.delete(locationid);
	}

	public LocationJpaRepository getLocationJpaRepository() {
		return locationJpaRepository;
	}

	public void setLocationJpaRepository(LocationJpaRepository locationJpaRepository) {
		this.locationJpaRepository = locationJpaRepository;
	}

	public LocationServiceMapper getLocationServiceMapper() {
		return locationServiceMapper;
	}

	public void setLocationServiceMapper(LocationServiceMapper locationServiceMapper) {
		this.locationServiceMapper = locationServiceMapper;
	}

	@Override
	public boolean exists(String locationid) {
		return locationJpaRepository.exists(locationid);
	}

	@Override
	public long count() {
		return locationJpaRepository.count();
	}

}
