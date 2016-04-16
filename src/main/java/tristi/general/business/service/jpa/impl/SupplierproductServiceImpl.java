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

import tristi.general.bean.Supplierproduct;
import tristi.general.bean.jpa.SupplierproductEntity;
import tristi.general.business.service.SupplierproductService;
import tristi.general.business.service.jpa.mapping.SupplierproductServiceMapper;
import tristi.general.data.repository.jpa.SupplierproductJpaRepository;

/**
 * Implementation of SupplierproductService
 */
@Component
@Transactional
public class SupplierproductServiceImpl implements SupplierproductService {

	@Resource
	private SupplierproductJpaRepository supplierproductJpaRepository;

	@Resource
	private SupplierproductServiceMapper supplierproductServiceMapper;
	
	@Override
	public Supplierproduct findById(String supplierproductid) {
		SupplierproductEntity supplierproductEntity = supplierproductJpaRepository.findOne(supplierproductid);
		return supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntity);
	}

	@Override
	public List<Supplierproduct> findAll() {
		Iterable<SupplierproductEntity> entities = supplierproductJpaRepository.findAll();
		List<Supplierproduct> beans = new ArrayList<Supplierproduct>();
		for(SupplierproductEntity supplierproductEntity : entities) {
			beans.add(supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntity));
		}
		return beans;
	}

	@Override
	public Supplierproduct save(Supplierproduct supplierproduct) {
		return update(supplierproduct) ;
	}

	@Override
	public Supplierproduct create(Supplierproduct supplierproduct) {
		SupplierproductEntity supplierproductEntity = supplierproductJpaRepository.findOne(supplierproduct.getSupplierproductid());
		if( supplierproductEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		supplierproductEntity = new SupplierproductEntity();
		supplierproductServiceMapper.mapSupplierproductToSupplierproductEntity(supplierproduct, supplierproductEntity);
		SupplierproductEntity supplierproductEntitySaved = supplierproductJpaRepository.save(supplierproductEntity);
		return supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntitySaved);
	}

	@Override
	public Supplierproduct update(Supplierproduct supplierproduct) {
		SupplierproductEntity supplierproductEntity = supplierproductJpaRepository.findOne(supplierproduct.getSupplierproductid());
		supplierproductServiceMapper.mapSupplierproductToSupplierproductEntity(supplierproduct, supplierproductEntity);
		SupplierproductEntity supplierproductEntitySaved = supplierproductJpaRepository.save(supplierproductEntity);
		return supplierproductServiceMapper.mapSupplierproductEntityToSupplierproduct(supplierproductEntitySaved);
	}

	@Override
	public void delete(String supplierproductid) {
		supplierproductJpaRepository.delete(supplierproductid);
	}

	public SupplierproductJpaRepository getSupplierproductJpaRepository() {
		return supplierproductJpaRepository;
	}

	public void setSupplierproductJpaRepository(SupplierproductJpaRepository supplierproductJpaRepository) {
		this.supplierproductJpaRepository = supplierproductJpaRepository;
	}

	public SupplierproductServiceMapper getSupplierproductServiceMapper() {
		return supplierproductServiceMapper;
	}

	public void setSupplierproductServiceMapper(SupplierproductServiceMapper supplierproductServiceMapper) {
		this.supplierproductServiceMapper = supplierproductServiceMapper;
	}

	@Override
	public boolean exists(String supplierproductid) {
		return supplierproductJpaRepository.exists(supplierproductid);
	}

	@Override
	public long count() {
		return supplierproductJpaRepository.count();
	}

}
