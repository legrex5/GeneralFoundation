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

import tristi.general.bean.Purchaseorder;
import tristi.general.bean.jpa.PurchaseorderEntity;
import tristi.general.business.service.PurchaseorderService;
import tristi.general.business.service.jpa.mapping.PurchaseorderServiceMapper;
import tristi.general.data.repository.jpa.PurchaseorderJpaRepository;

/**
 * Implementation of PurchaseorderService
 */
@Component
@Transactional
public class PurchaseorderServiceImpl implements PurchaseorderService {

	@Resource
	private PurchaseorderJpaRepository purchaseorderJpaRepository;

	@Resource
	private PurchaseorderServiceMapper purchaseorderServiceMapper;
	
	@Override
	public Purchaseorder findById(String purchaseorderid) {
		PurchaseorderEntity purchaseorderEntity = purchaseorderJpaRepository.findOne(purchaseorderid);
		return purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntity);
	}

	@Override
	public List<Purchaseorder> findAll() {
		Iterable<PurchaseorderEntity> entities = purchaseorderJpaRepository.findAll();
		List<Purchaseorder> beans = new ArrayList<Purchaseorder>();
		for(PurchaseorderEntity purchaseorderEntity : entities) {
			beans.add(purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntity));
		}
		return beans;
	}

	@Override
	public Purchaseorder save(Purchaseorder purchaseorder) {
		return update(purchaseorder) ;
	}

	@Override
	public Purchaseorder create(Purchaseorder purchaseorder) {
		PurchaseorderEntity purchaseorderEntity = purchaseorderJpaRepository.findOne(purchaseorder.getPurchaseorderid());
		if( purchaseorderEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		purchaseorderEntity = new PurchaseorderEntity();
		purchaseorderServiceMapper.mapPurchaseorderToPurchaseorderEntity(purchaseorder, purchaseorderEntity);
		PurchaseorderEntity purchaseorderEntitySaved = purchaseorderJpaRepository.save(purchaseorderEntity);
		return purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntitySaved);
	}

	@Override
	public Purchaseorder update(Purchaseorder purchaseorder) {
		PurchaseorderEntity purchaseorderEntity = purchaseorderJpaRepository.findOne(purchaseorder.getPurchaseorderid());
		purchaseorderServiceMapper.mapPurchaseorderToPurchaseorderEntity(purchaseorder, purchaseorderEntity);
		PurchaseorderEntity purchaseorderEntitySaved = purchaseorderJpaRepository.save(purchaseorderEntity);
		return purchaseorderServiceMapper.mapPurchaseorderEntityToPurchaseorder(purchaseorderEntitySaved);
	}

	@Override
	public void delete(String purchaseorderid) {
		purchaseorderJpaRepository.delete(purchaseorderid);
	}

	public PurchaseorderJpaRepository getPurchaseorderJpaRepository() {
		return purchaseorderJpaRepository;
	}

	public void setPurchaseorderJpaRepository(PurchaseorderJpaRepository purchaseorderJpaRepository) {
		this.purchaseorderJpaRepository = purchaseorderJpaRepository;
	}

	public PurchaseorderServiceMapper getPurchaseorderServiceMapper() {
		return purchaseorderServiceMapper;
	}

	public void setPurchaseorderServiceMapper(PurchaseorderServiceMapper purchaseorderServiceMapper) {
		this.purchaseorderServiceMapper = purchaseorderServiceMapper;
	}

	@Override
	public boolean exists(String purchaseorderid) {
		return purchaseorderJpaRepository.exists(purchaseorderid);
	}

	@Override
	public long count() {
		return purchaseorderJpaRepository.count();
	}

}
