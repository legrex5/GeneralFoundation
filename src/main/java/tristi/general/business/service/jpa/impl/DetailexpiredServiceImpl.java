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

import tristi.general.bean.Detailexpired;
import tristi.general.bean.jpa.DetailexpiredEntity;
import tristi.general.business.service.DetailexpiredService;
import tristi.general.business.service.jpa.mapping.DetailexpiredServiceMapper;
import tristi.general.data.repository.jpa.DetailexpiredJpaRepository;

/**
 * Implementation of DetailexpiredService
 */
@Component
@Transactional
public class DetailexpiredServiceImpl implements DetailexpiredService {

	@Resource
	private DetailexpiredJpaRepository detailexpiredJpaRepository;

	@Resource
	private DetailexpiredServiceMapper detailexpiredServiceMapper;
	
	@Override
	public Detailexpired findById(String detailexpiredid) {
		DetailexpiredEntity detailexpiredEntity = detailexpiredJpaRepository.findOne(detailexpiredid);
		return detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntity);
	}

	@Override
	public List<Detailexpired> findAll() {
		Iterable<DetailexpiredEntity> entities = detailexpiredJpaRepository.findAll();
		List<Detailexpired> beans = new ArrayList<Detailexpired>();
		for(DetailexpiredEntity detailexpiredEntity : entities) {
			beans.add(detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntity));
		}
		return beans;
	}

	@Override
	public Detailexpired save(Detailexpired detailexpired) {
		return update(detailexpired) ;
	}

	@Override
	public Detailexpired create(Detailexpired detailexpired) {
		DetailexpiredEntity detailexpiredEntity = detailexpiredJpaRepository.findOne(detailexpired.getDetailexpiredid());
		if( detailexpiredEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		detailexpiredEntity = new DetailexpiredEntity();
		detailexpiredServiceMapper.mapDetailexpiredToDetailexpiredEntity(detailexpired, detailexpiredEntity);
		DetailexpiredEntity detailexpiredEntitySaved = detailexpiredJpaRepository.save(detailexpiredEntity);
		return detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntitySaved);
	}

	@Override
	public Detailexpired update(Detailexpired detailexpired) {
		DetailexpiredEntity detailexpiredEntity = detailexpiredJpaRepository.findOne(detailexpired.getDetailexpiredid());
		detailexpiredServiceMapper.mapDetailexpiredToDetailexpiredEntity(detailexpired, detailexpiredEntity);
		DetailexpiredEntity detailexpiredEntitySaved = detailexpiredJpaRepository.save(detailexpiredEntity);
		return detailexpiredServiceMapper.mapDetailexpiredEntityToDetailexpired(detailexpiredEntitySaved);
	}

	@Override
	public void delete(String detailexpiredid) {
		detailexpiredJpaRepository.delete(detailexpiredid);
	}

	public DetailexpiredJpaRepository getDetailexpiredJpaRepository() {
		return detailexpiredJpaRepository;
	}

	public void setDetailexpiredJpaRepository(DetailexpiredJpaRepository detailexpiredJpaRepository) {
		this.detailexpiredJpaRepository = detailexpiredJpaRepository;
	}

	public DetailexpiredServiceMapper getDetailexpiredServiceMapper() {
		return detailexpiredServiceMapper;
	}

	public void setDetailexpiredServiceMapper(DetailexpiredServiceMapper detailexpiredServiceMapper) {
		this.detailexpiredServiceMapper = detailexpiredServiceMapper;
	}

	@Override
	public boolean exists(String detailexpiredid) {
		return detailexpiredJpaRepository.exists(detailexpiredid);
	}

	@Override
	public long count() {
		return detailexpiredJpaRepository.count();
	}

}
