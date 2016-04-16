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

import tristi.general.bean.Salesorder;
import tristi.general.bean.jpa.SalesorderEntity;
import tristi.general.business.service.SalesorderService;
import tristi.general.business.service.jpa.mapping.SalesorderServiceMapper;
import tristi.general.data.repository.jpa.SalesorderJpaRepository;

/**
 * Implementation of SalesorderService
 */
@Component
@Transactional
public class SalesorderServiceImpl implements SalesorderService {

	@Resource
	private SalesorderJpaRepository salesorderJpaRepository;

	@Resource
	private SalesorderServiceMapper salesorderServiceMapper;
	
	@Override
	public Salesorder findById(String salesorderid) {
		SalesorderEntity salesorderEntity = salesorderJpaRepository.findOne(salesorderid);
		return salesorderServiceMapper.mapSalesorderEntityToSalesorder(salesorderEntity);
	}

	@Override
	public List<Salesorder> findAll() {
		Iterable<SalesorderEntity> entities = salesorderJpaRepository.findAll();
		List<Salesorder> beans = new ArrayList<Salesorder>();
		for(SalesorderEntity salesorderEntity : entities) {
			beans.add(salesorderServiceMapper.mapSalesorderEntityToSalesorder(salesorderEntity));
		}
		return beans;
	}

	@Override
	public Salesorder save(Salesorder salesorder) {
		return update(salesorder) ;
	}

	@Override
	public Salesorder create(Salesorder salesorder) {
		SalesorderEntity salesorderEntity = salesorderJpaRepository.findOne(salesorder.getSalesorderid());
		if( salesorderEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		salesorderEntity = new SalesorderEntity();
		salesorderServiceMapper.mapSalesorderToSalesorderEntity(salesorder, salesorderEntity);
		SalesorderEntity salesorderEntitySaved = salesorderJpaRepository.save(salesorderEntity);
		return salesorderServiceMapper.mapSalesorderEntityToSalesorder(salesorderEntitySaved);
	}

	@Override
	public Salesorder update(Salesorder salesorder) {
		SalesorderEntity salesorderEntity = salesorderJpaRepository.findOne(salesorder.getSalesorderid());
		salesorderServiceMapper.mapSalesorderToSalesorderEntity(salesorder, salesorderEntity);
		SalesorderEntity salesorderEntitySaved = salesorderJpaRepository.save(salesorderEntity);
		return salesorderServiceMapper.mapSalesorderEntityToSalesorder(salesorderEntitySaved);
	}

	@Override
	public void delete(String salesorderid) {
		salesorderJpaRepository.delete(salesorderid);
	}

	public SalesorderJpaRepository getSalesorderJpaRepository() {
		return salesorderJpaRepository;
	}

	public void setSalesorderJpaRepository(SalesorderJpaRepository salesorderJpaRepository) {
		this.salesorderJpaRepository = salesorderJpaRepository;
	}

	public SalesorderServiceMapper getSalesorderServiceMapper() {
		return salesorderServiceMapper;
	}

	public void setSalesorderServiceMapper(SalesorderServiceMapper salesorderServiceMapper) {
		this.salesorderServiceMapper = salesorderServiceMapper;
	}

	@Override
	public boolean exists(String salesorderid) {
		return salesorderJpaRepository.exists(salesorderid);
	}

	@Override
	public long count() {
		return salesorderJpaRepository.count();
	}

}
