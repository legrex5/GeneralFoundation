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

import tristi.general.bean.Salesordercorrection;
import tristi.general.bean.jpa.SalesordercorrectionEntity;
import tristi.general.business.service.SalesordercorrectionService;
import tristi.general.business.service.jpa.mapping.SalesordercorrectionServiceMapper;
import tristi.general.data.repository.jpa.SalesordercorrectionJpaRepository;

/**
 * Implementation of SalesordercorrectionService
 */
@Component
@Transactional
public class SalesordercorrectionServiceImpl implements SalesordercorrectionService {

	@Resource
	private SalesordercorrectionJpaRepository salesordercorrectionJpaRepository;

	@Resource
	private SalesordercorrectionServiceMapper salesordercorrectionServiceMapper;
	
	@Override
	public Salesordercorrection findById(String salesordercorrectionid) {
		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionJpaRepository.findOne(salesordercorrectionid);
		return salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntity);
	}

	@Override
	public List<Salesordercorrection> findAll() {
		Iterable<SalesordercorrectionEntity> entities = salesordercorrectionJpaRepository.findAll();
		List<Salesordercorrection> beans = new ArrayList<Salesordercorrection>();
		for(SalesordercorrectionEntity salesordercorrectionEntity : entities) {
			beans.add(salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntity));
		}
		return beans;
	}

	@Override
	public Salesordercorrection save(Salesordercorrection salesordercorrection) {
		return update(salesordercorrection) ;
	}

	@Override
	public Salesordercorrection create(Salesordercorrection salesordercorrection) {
		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionJpaRepository.findOne(salesordercorrection.getSalesordercorrectionid());
		if( salesordercorrectionEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		salesordercorrectionEntity = new SalesordercorrectionEntity();
		salesordercorrectionServiceMapper.mapSalesordercorrectionToSalesordercorrectionEntity(salesordercorrection, salesordercorrectionEntity);
		SalesordercorrectionEntity salesordercorrectionEntitySaved = salesordercorrectionJpaRepository.save(salesordercorrectionEntity);
		return salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntitySaved);
	}

	@Override
	public Salesordercorrection update(Salesordercorrection salesordercorrection) {
		SalesordercorrectionEntity salesordercorrectionEntity = salesordercorrectionJpaRepository.findOne(salesordercorrection.getSalesordercorrectionid());
		salesordercorrectionServiceMapper.mapSalesordercorrectionToSalesordercorrectionEntity(salesordercorrection, salesordercorrectionEntity);
		SalesordercorrectionEntity salesordercorrectionEntitySaved = salesordercorrectionJpaRepository.save(salesordercorrectionEntity);
		return salesordercorrectionServiceMapper.mapSalesordercorrectionEntityToSalesordercorrection(salesordercorrectionEntitySaved);
	}

	@Override
	public void delete(String salesordercorrectionid) {
		salesordercorrectionJpaRepository.delete(salesordercorrectionid);
	}

	public SalesordercorrectionJpaRepository getSalesordercorrectionJpaRepository() {
		return salesordercorrectionJpaRepository;
	}

	public void setSalesordercorrectionJpaRepository(SalesordercorrectionJpaRepository salesordercorrectionJpaRepository) {
		this.salesordercorrectionJpaRepository = salesordercorrectionJpaRepository;
	}

	public SalesordercorrectionServiceMapper getSalesordercorrectionServiceMapper() {
		return salesordercorrectionServiceMapper;
	}

	public void setSalesordercorrectionServiceMapper(SalesordercorrectionServiceMapper salesordercorrectionServiceMapper) {
		this.salesordercorrectionServiceMapper = salesordercorrectionServiceMapper;
	}

	@Override
	public boolean exists(String salesordercorrectionid) {
		return salesordercorrectionJpaRepository.exists(salesordercorrectionid);
	}

	@Override
	public long count() {
		return salesordercorrectionJpaRepository.count();
	}

}
