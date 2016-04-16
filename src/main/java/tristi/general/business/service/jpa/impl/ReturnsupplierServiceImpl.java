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

import tristi.general.bean.Returnsupplier;
import tristi.general.bean.jpa.ReturnsupplierEntity;
import tristi.general.business.service.ReturnsupplierService;
import tristi.general.business.service.jpa.mapping.ReturnsupplierServiceMapper;
import tristi.general.data.repository.jpa.ReturnsupplierJpaRepository;

/**
 * Implementation of ReturnsupplierService
 */
@Component
@Transactional
public class ReturnsupplierServiceImpl implements ReturnsupplierService {

	@Resource
	private ReturnsupplierJpaRepository returnsupplierJpaRepository;

	@Resource
	private ReturnsupplierServiceMapper returnsupplierServiceMapper;
	
	@Override
	public Returnsupplier findById(String returnsupplierid) {
		ReturnsupplierEntity returnsupplierEntity = returnsupplierJpaRepository.findOne(returnsupplierid);
		return returnsupplierServiceMapper.mapReturnsupplierEntityToReturnsupplier(returnsupplierEntity);
	}

	@Override
	public List<Returnsupplier> findAll() {
		Iterable<ReturnsupplierEntity> entities = returnsupplierJpaRepository.findAll();
		List<Returnsupplier> beans = new ArrayList<Returnsupplier>();
		for(ReturnsupplierEntity returnsupplierEntity : entities) {
			beans.add(returnsupplierServiceMapper.mapReturnsupplierEntityToReturnsupplier(returnsupplierEntity));
		}
		return beans;
	}

	@Override
	public Returnsupplier save(Returnsupplier returnsupplier) {
		return update(returnsupplier) ;
	}

	@Override
	public Returnsupplier create(Returnsupplier returnsupplier) {
		ReturnsupplierEntity returnsupplierEntity = returnsupplierJpaRepository.findOne(returnsupplier.getReturnsupplierid());
		if( returnsupplierEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		returnsupplierEntity = new ReturnsupplierEntity();
		returnsupplierServiceMapper.mapReturnsupplierToReturnsupplierEntity(returnsupplier, returnsupplierEntity);
		ReturnsupplierEntity returnsupplierEntitySaved = returnsupplierJpaRepository.save(returnsupplierEntity);
		return returnsupplierServiceMapper.mapReturnsupplierEntityToReturnsupplier(returnsupplierEntitySaved);
	}

	@Override
	public Returnsupplier update(Returnsupplier returnsupplier) {
		ReturnsupplierEntity returnsupplierEntity = returnsupplierJpaRepository.findOne(returnsupplier.getReturnsupplierid());
		returnsupplierServiceMapper.mapReturnsupplierToReturnsupplierEntity(returnsupplier, returnsupplierEntity);
		ReturnsupplierEntity returnsupplierEntitySaved = returnsupplierJpaRepository.save(returnsupplierEntity);
		return returnsupplierServiceMapper.mapReturnsupplierEntityToReturnsupplier(returnsupplierEntitySaved);
	}

	@Override
	public void delete(String returnsupplierid) {
		returnsupplierJpaRepository.delete(returnsupplierid);
	}

	public ReturnsupplierJpaRepository getReturnsupplierJpaRepository() {
		return returnsupplierJpaRepository;
	}

	public void setReturnsupplierJpaRepository(ReturnsupplierJpaRepository returnsupplierJpaRepository) {
		this.returnsupplierJpaRepository = returnsupplierJpaRepository;
	}

	public ReturnsupplierServiceMapper getReturnsupplierServiceMapper() {
		return returnsupplierServiceMapper;
	}

	public void setReturnsupplierServiceMapper(ReturnsupplierServiceMapper returnsupplierServiceMapper) {
		this.returnsupplierServiceMapper = returnsupplierServiceMapper;
	}

	@Override
	public boolean exists(String returnsupplierid) {
		return returnsupplierJpaRepository.exists(returnsupplierid);
	}

	@Override
	public long count() {
		return returnsupplierJpaRepository.count();
	}

}
