/*
 * Created on 6 Dec 2015 ( Time 04:08:59 )
 * 
 */
package tristi.general.business.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tristi.general.bean.Salesorderdtl;
import tristi.general.bean.jpa.SalesorderdtlEntity;
import tristi.general.business.service.SalesorderdtlService;
import tristi.general.business.service.jpa.mapping.SalesorderdtlServiceMapper;
import tristi.general.data.repository.jpa.SalesorderdtlJpaRepository;

/**
 * Implementation of SalesorderdtlService
 */
@Component
@Transactional
public class SalesorderdtlServiceImpl implements SalesorderdtlService {

	@Resource
	private SalesorderdtlJpaRepository salesorderdtlJpaRepository;

	@Resource
	private SalesorderdtlServiceMapper salesorderdtlServiceMapper;
	
	@Override
	public Salesorderdtl findById(String salesorderdtlid) {
		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlJpaRepository.findOne(salesorderdtlid);
		return salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntity);
	}

	@Override
	public List<Salesorderdtl> findAll() {
		Iterable<SalesorderdtlEntity> entities = salesorderdtlJpaRepository.findAll();
		List<Salesorderdtl> beans = new ArrayList<Salesorderdtl>();
		for(SalesorderdtlEntity salesorderdtlEntity : entities) {
			beans.add(salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntity));
		}
		return beans;
	}

	@Override
	public Salesorderdtl save(Salesorderdtl salesorderdtl) {
		return update(salesorderdtl) ;
	}

	@Override
	public Salesorderdtl create(Salesorderdtl salesorderdtl) {
		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlJpaRepository.findOne(salesorderdtl.getSalesorderdtlid());
		if( salesorderdtlEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		salesorderdtlEntity = new SalesorderdtlEntity();
		salesorderdtlServiceMapper.mapSalesorderdtlToSalesorderdtlEntity(salesorderdtl, salesorderdtlEntity);
		SalesorderdtlEntity salesorderdtlEntitySaved = salesorderdtlJpaRepository.save(salesorderdtlEntity);
		return salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntitySaved);
	}

	@Override
	public Salesorderdtl update(Salesorderdtl salesorderdtl) {
		SalesorderdtlEntity salesorderdtlEntity = salesorderdtlJpaRepository.findOne(salesorderdtl.getSalesorderdtlid());
		salesorderdtlServiceMapper.mapSalesorderdtlToSalesorderdtlEntity(salesorderdtl, salesorderdtlEntity);
		SalesorderdtlEntity salesorderdtlEntitySaved = salesorderdtlJpaRepository.save(salesorderdtlEntity);
		return salesorderdtlServiceMapper.mapSalesorderdtlEntityToSalesorderdtl(salesorderdtlEntitySaved);
	}

	@Override
	public void delete(String salesorderdtlid) {
		salesorderdtlJpaRepository.delete(salesorderdtlid);
	}

	public SalesorderdtlJpaRepository getSalesorderdtlJpaRepository() {
		return salesorderdtlJpaRepository;
	}

	public void setSalesorderdtlJpaRepository(SalesorderdtlJpaRepository salesorderdtlJpaRepository) {
		this.salesorderdtlJpaRepository = salesorderdtlJpaRepository;
	}

	public SalesorderdtlServiceMapper getSalesorderdtlServiceMapper() {
		return salesorderdtlServiceMapper;
	}

	public void setSalesorderdtlServiceMapper(SalesorderdtlServiceMapper salesorderdtlServiceMapper) {
		this.salesorderdtlServiceMapper = salesorderdtlServiceMapper;
	}

	@Override
	public boolean exists(String salesorderdtlid) {
		return salesorderdtlJpaRepository.exists(salesorderdtlid);
	}

	@Override
	public long count() {
		return salesorderdtlJpaRepository.count();
	}

}
