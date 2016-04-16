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

import tristi.general.bean.Productuom;
import tristi.general.bean.jpa.ProductuomEntity;
import tristi.general.business.service.ProductuomService;
import tristi.general.business.service.jpa.mapping.ProductuomServiceMapper;
import tristi.general.data.repository.jpa.ProductuomJpaRepository;

/**
 * Implementation of ProductuomService
 */
@Component
@Transactional
public class ProductuomServiceImpl implements ProductuomService {

	@Resource
	private ProductuomJpaRepository productuomJpaRepository;

	@Resource
	private ProductuomServiceMapper productuomServiceMapper;
	
	@Override
	public Productuom findById(String productuomid) {
		ProductuomEntity productuomEntity = productuomJpaRepository.findOne(productuomid);
		return productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntity);
	}

	@Override
	public List<Productuom> findAll() {
		Iterable<ProductuomEntity> entities = productuomJpaRepository.findAll();
		List<Productuom> beans = new ArrayList<Productuom>();
		for(ProductuomEntity productuomEntity : entities) {
			beans.add(productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntity));
		}
		return beans;
	}

	@Override
	public Productuom save(Productuom productuom) {
		return update(productuom) ;
	}

	@Override
	public Productuom create(Productuom productuom) {
		ProductuomEntity productuomEntity = productuomJpaRepository.findOne(productuom.getProductuomid());
		if( productuomEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		productuomEntity = new ProductuomEntity();
		productuomServiceMapper.mapProductuomToProductuomEntity(productuom, productuomEntity);
		ProductuomEntity productuomEntitySaved = productuomJpaRepository.save(productuomEntity);
		return productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntitySaved);
	}

	@Override
	public Productuom update(Productuom productuom) {
		ProductuomEntity productuomEntity = productuomJpaRepository.findOne(productuom.getProductuomid());
		productuomServiceMapper.mapProductuomToProductuomEntity(productuom, productuomEntity);
		ProductuomEntity productuomEntitySaved = productuomJpaRepository.save(productuomEntity);
		return productuomServiceMapper.mapProductuomEntityToProductuom(productuomEntitySaved);
	}

	@Override
	public void delete(String productuomid) {
		productuomJpaRepository.delete(productuomid);
	}

	public ProductuomJpaRepository getProductuomJpaRepository() {
		return productuomJpaRepository;
	}

	public void setProductuomJpaRepository(ProductuomJpaRepository productuomJpaRepository) {
		this.productuomJpaRepository = productuomJpaRepository;
	}

	public ProductuomServiceMapper getProductuomServiceMapper() {
		return productuomServiceMapper;
	}

	public void setProductuomServiceMapper(ProductuomServiceMapper productuomServiceMapper) {
		this.productuomServiceMapper = productuomServiceMapper;
	}

	@Override
	public boolean exists(String productuomid) {
		return productuomJpaRepository.exists(productuomid);
	}

	@Override
	public long count() {
		return productuomJpaRepository.count();
	}

}
