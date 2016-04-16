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

import tristi.general.bean.Productstock;
import tristi.general.bean.jpa.ProductstockEntity;
import tristi.general.business.service.ProductstockService;
import tristi.general.business.service.jpa.mapping.ProductstockServiceMapper;
import tristi.general.data.repository.jpa.ProductstockJpaRepository;

/**
 * Implementation of ProductstockService
 */
@Component
@Transactional
public class ProductstockServiceImpl implements ProductstockService {

	@Resource
	private ProductstockJpaRepository productstockJpaRepository;

	@Resource
	private ProductstockServiceMapper productstockServiceMapper;
	
	@Override
	public Productstock findById(String productstockid) {
		ProductstockEntity productstockEntity = productstockJpaRepository.findOne(productstockid);
		return productstockServiceMapper.mapProductstockEntityToProductstock(productstockEntity);
	}

	@Override
	public List<Productstock> findAll() {
		Iterable<ProductstockEntity> entities = productstockJpaRepository.findAll();
		List<Productstock> beans = new ArrayList<Productstock>();
		for(ProductstockEntity productstockEntity : entities) {
			beans.add(productstockServiceMapper.mapProductstockEntityToProductstock(productstockEntity));
		}
		return beans;
	}

	@Override
	public Productstock save(Productstock productstock) {
		return update(productstock) ;
	}

	@Override
	public Productstock create(Productstock productstock) {
		ProductstockEntity productstockEntity = productstockJpaRepository.findOne(productstock.getProductstockid());
		if( productstockEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		productstockEntity = new ProductstockEntity();
		productstockServiceMapper.mapProductstockToProductstockEntity(productstock, productstockEntity);
		ProductstockEntity productstockEntitySaved = productstockJpaRepository.save(productstockEntity);
		return productstockServiceMapper.mapProductstockEntityToProductstock(productstockEntitySaved);
	}

	@Override
	public Productstock update(Productstock productstock) {
		ProductstockEntity productstockEntity = productstockJpaRepository.findOne(productstock.getProductstockid());
		productstockServiceMapper.mapProductstockToProductstockEntity(productstock, productstockEntity);
		ProductstockEntity productstockEntitySaved = productstockJpaRepository.save(productstockEntity);
		return productstockServiceMapper.mapProductstockEntityToProductstock(productstockEntitySaved);
	}

	@Override
	public void delete(String productstockid) {
		productstockJpaRepository.delete(productstockid);
	}

	public ProductstockJpaRepository getProductstockJpaRepository() {
		return productstockJpaRepository;
	}

	public void setProductstockJpaRepository(ProductstockJpaRepository productstockJpaRepository) {
		this.productstockJpaRepository = productstockJpaRepository;
	}

	public ProductstockServiceMapper getProductstockServiceMapper() {
		return productstockServiceMapper;
	}

	public void setProductstockServiceMapper(ProductstockServiceMapper productstockServiceMapper) {
		this.productstockServiceMapper = productstockServiceMapper;
	}

	@Override
	public boolean exists(String productstockid) {
		return productstockJpaRepository.exists(productstockid);
	}

	@Override
	public long count() {
		return productstockJpaRepository.count();
	}

}
