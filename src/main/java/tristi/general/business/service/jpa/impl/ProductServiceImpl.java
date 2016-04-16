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

import tristi.general.bean.Product;
import tristi.general.bean.jpa.ProductEntity;
import tristi.general.business.service.ProductService;
import tristi.general.business.service.jpa.mapping.ProductServiceMapper;
import tristi.general.data.repository.jpa.ProductJpaRepository;

/**
 * Implementation of ProductService
 */
@Component
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductJpaRepository productJpaRepository;

	@Resource
	private ProductServiceMapper productServiceMapper;
	
	@Override
	public Product findById(String productid) {
		ProductEntity productEntity = productJpaRepository.findOne(productid);
		return productServiceMapper.mapProductEntityToProduct(productEntity);
	}

	@Override
	public List<Product> findAll() {
		Iterable<ProductEntity> entities = productJpaRepository.findAll();
		List<Product> beans = new ArrayList<Product>();
		for(ProductEntity productEntity : entities) {
			beans.add(productServiceMapper.mapProductEntityToProduct(productEntity));
		}
		return beans;
	}

	@Override
	public Product save(Product product) {
		return update(product) ;
	}

	@Override
	public Product create(Product product) {
		ProductEntity productEntity = productJpaRepository.findOne(product.getProductid());
		if( productEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		productEntity = new ProductEntity();
		productServiceMapper.mapProductToProductEntity(product, productEntity);
		ProductEntity productEntitySaved = productJpaRepository.save(productEntity);
		return productServiceMapper.mapProductEntityToProduct(productEntitySaved);
	}

	@Override
	public Product update(Product product) {
		ProductEntity productEntity = productJpaRepository.findOne(product.getProductid());
		productServiceMapper.mapProductToProductEntity(product, productEntity);
		ProductEntity productEntitySaved = productJpaRepository.save(productEntity);
		return productServiceMapper.mapProductEntityToProduct(productEntitySaved);
	}

	@Override
	public void delete(String productid) {
		productJpaRepository.delete(productid);
	}

	public ProductJpaRepository getProductJpaRepository() {
		return productJpaRepository;
	}

	public void setProductJpaRepository(ProductJpaRepository productJpaRepository) {
		this.productJpaRepository = productJpaRepository;
	}

	public ProductServiceMapper getProductServiceMapper() {
		return productServiceMapper;
	}

	public void setProductServiceMapper(ProductServiceMapper productServiceMapper) {
		this.productServiceMapper = productServiceMapper;
	}

	@Override
	public boolean exists(String productid) {
		return productJpaRepository.exists(productid);
	}

	@Override
	public long count() {
		return productJpaRepository.count();
	}

}
