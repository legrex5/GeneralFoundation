/*
 * Created on 6 Dec 2015 ( Time 04:08:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tristi.general.bean.Supplier;
import tristi.general.bean.jpa.SupplierEntity;
import tristi.general.business.service.SupplierService;
import tristi.general.business.service.jpa.mapping.SupplierServiceMapper;
import tristi.general.data.repository.jpa.SupplierJpaRepository;

/**
 * Implementation of SupplierService
 */
@Component
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Resource
	private SupplierJpaRepository supplierJpaRepository;

	@Resource
	private SupplierServiceMapper supplierServiceMapper;
	
	@Override
	public Supplier findById(String supplierid) {
		SupplierEntity supplierEntity = supplierJpaRepository.findOne(supplierid);
		return supplierServiceMapper.mapSupplierEntityToSupplier(supplierEntity);
	}

	@Override
	public List<Supplier> findAll() {
		Iterable<SupplierEntity> entities = supplierJpaRepository.findAll();
		List<Supplier> beans = new ArrayList<Supplier>();
		for(SupplierEntity supplierEntity : entities) {
			beans.add(supplierServiceMapper.mapSupplierEntityToSupplier(supplierEntity));
		}
		return beans;
	}

	@Override
	public Supplier save(Supplier supplier) {
		return update(supplier) ;
	}

	@Override
	public Supplier create(Supplier supplier) {
		SupplierEntity supplierEntity = supplierJpaRepository.findOne(supplier.getSupplierid());
		if( supplierEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		supplierEntity = new SupplierEntity();
		supplierServiceMapper.mapSupplierToSupplierEntity(supplier, supplierEntity);
		SupplierEntity supplierEntitySaved = supplierJpaRepository.save(supplierEntity);
		return supplierServiceMapper.mapSupplierEntityToSupplier(supplierEntitySaved);
	}

	@Override
	public Supplier update(Supplier supplier) {
		SupplierEntity supplierEntity = supplierJpaRepository.findOne(supplier.getSupplierid());
		supplierServiceMapper.mapSupplierToSupplierEntity(supplier, supplierEntity);
		SupplierEntity supplierEntitySaved = supplierJpaRepository.save(supplierEntity);
		return supplierServiceMapper.mapSupplierEntityToSupplier(supplierEntitySaved);
	}

	@Override
	public void delete(String supplierid) {
		supplierJpaRepository.delete(supplierid);
	}

	public SupplierJpaRepository getSupplierJpaRepository() {
		return supplierJpaRepository;
	}

	public void setSupplierJpaRepository(SupplierJpaRepository supplierJpaRepository) {
		this.supplierJpaRepository = supplierJpaRepository;
	}

	public SupplierServiceMapper getSupplierServiceMapper() {
		return supplierServiceMapper;
	}

	public void setSupplierServiceMapper(SupplierServiceMapper supplierServiceMapper) {
		this.supplierServiceMapper = supplierServiceMapper;
	}

	@Override
	public boolean exists(String supplierid) {
		return supplierJpaRepository.exists(supplierid);
	}

	@Override
	public long count() {
		return supplierJpaRepository.count();
	}

}
