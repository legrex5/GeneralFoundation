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

import tristi.general.bean.Purchaseorderdtl;
import tristi.general.bean.jpa.PurchaseorderdtlEntity;
import tristi.general.business.service.PurchaseorderdtlService;
import tristi.general.business.service.jpa.mapping.PurchaseorderdtlServiceMapper;
import tristi.general.data.repository.jpa.PurchaseorderdtlJpaRepository;

/**
 * Implementation of PurchaseorderdtlService
 */
@Component
@Transactional
public class PurchaseorderdtlServiceImpl implements PurchaseorderdtlService {

	@Resource
	private PurchaseorderdtlJpaRepository purchaseorderdtlJpaRepository;

	@Resource
	private PurchaseorderdtlServiceMapper purchaseorderdtlServiceMapper;
	
	@Override
	public Purchaseorderdtl findById(String purchaseorderdtlid) {
		PurchaseorderdtlEntity purchaseorderdtlEntity = purchaseorderdtlJpaRepository.findOne(purchaseorderdtlid);
		return purchaseorderdtlServiceMapper.mapPurchaseorderdtlEntityToPurchaseorderdtl(purchaseorderdtlEntity);
	}

	@Override
	public List<Purchaseorderdtl> findAll() {
		Iterable<PurchaseorderdtlEntity> entities = purchaseorderdtlJpaRepository.findAll();
		List<Purchaseorderdtl> beans = new ArrayList<Purchaseorderdtl>();
		for(PurchaseorderdtlEntity purchaseorderdtlEntity : entities) {
			beans.add(purchaseorderdtlServiceMapper.mapPurchaseorderdtlEntityToPurchaseorderdtl(purchaseorderdtlEntity));
		}
		return beans;
	}

	@Override
	public Purchaseorderdtl save(Purchaseorderdtl purchaseorderdtl) {
		return update(purchaseorderdtl) ;
	}

	@Override
	public Purchaseorderdtl create(Purchaseorderdtl purchaseorderdtl) {
		PurchaseorderdtlEntity purchaseorderdtlEntity = purchaseorderdtlJpaRepository.findOne(purchaseorderdtl.getPurchaseorderdtlid());
		if( purchaseorderdtlEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		purchaseorderdtlEntity = new PurchaseorderdtlEntity();
		purchaseorderdtlServiceMapper.mapPurchaseorderdtlToPurchaseorderdtlEntity(purchaseorderdtl, purchaseorderdtlEntity);
		PurchaseorderdtlEntity purchaseorderdtlEntitySaved = purchaseorderdtlJpaRepository.save(purchaseorderdtlEntity);
		return purchaseorderdtlServiceMapper.mapPurchaseorderdtlEntityToPurchaseorderdtl(purchaseorderdtlEntitySaved);
	}

	@Override
	public Purchaseorderdtl update(Purchaseorderdtl purchaseorderdtl) {
		PurchaseorderdtlEntity purchaseorderdtlEntity = purchaseorderdtlJpaRepository.findOne(purchaseorderdtl.getPurchaseorderdtlid());
		purchaseorderdtlServiceMapper.mapPurchaseorderdtlToPurchaseorderdtlEntity(purchaseorderdtl, purchaseorderdtlEntity);
		PurchaseorderdtlEntity purchaseorderdtlEntitySaved = purchaseorderdtlJpaRepository.save(purchaseorderdtlEntity);
		return purchaseorderdtlServiceMapper.mapPurchaseorderdtlEntityToPurchaseorderdtl(purchaseorderdtlEntitySaved);
	}

	@Override
	public void delete(String purchaseorderdtlid) {
		purchaseorderdtlJpaRepository.delete(purchaseorderdtlid);
	}

	public PurchaseorderdtlJpaRepository getPurchaseorderdtlJpaRepository() {
		return purchaseorderdtlJpaRepository;
	}

	public void setPurchaseorderdtlJpaRepository(PurchaseorderdtlJpaRepository purchaseorderdtlJpaRepository) {
		this.purchaseorderdtlJpaRepository = purchaseorderdtlJpaRepository;
	}

	public PurchaseorderdtlServiceMapper getPurchaseorderdtlServiceMapper() {
		return purchaseorderdtlServiceMapper;
	}

	public void setPurchaseorderdtlServiceMapper(PurchaseorderdtlServiceMapper purchaseorderdtlServiceMapper) {
		this.purchaseorderdtlServiceMapper = purchaseorderdtlServiceMapper;
	}

	@Override
	public boolean exists(String purchaseorderdtlid) {
		return purchaseorderdtlJpaRepository.exists(purchaseorderdtlid);
	}

	@Override
	public long count() {
		return purchaseorderdtlJpaRepository.count();
	}

}
