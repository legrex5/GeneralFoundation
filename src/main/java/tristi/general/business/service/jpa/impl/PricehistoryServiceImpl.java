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

import tristi.general.bean.Pricehistory;
import tristi.general.bean.jpa.PricehistoryEntity;
import tristi.general.business.service.PricehistoryService;
import tristi.general.business.service.jpa.mapping.PricehistoryServiceMapper;
import tristi.general.data.repository.jpa.PricehistoryJpaRepository;

/**
 * Implementation of PricehistoryService
 */
@Component
@Transactional
public class PricehistoryServiceImpl implements PricehistoryService {

	@Resource
	private PricehistoryJpaRepository pricehistoryJpaRepository;

	@Resource
	private PricehistoryServiceMapper pricehistoryServiceMapper;
	
	@Override
	public Pricehistory findById(String pricehistoryid) {
		PricehistoryEntity pricehistoryEntity = pricehistoryJpaRepository.findOne(pricehistoryid);
		return pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntity);
	}

	@Override
	public List<Pricehistory> findAll() {
		Iterable<PricehistoryEntity> entities = pricehistoryJpaRepository.findAll();
		List<Pricehistory> beans = new ArrayList<Pricehistory>();
		for(PricehistoryEntity pricehistoryEntity : entities) {
			beans.add(pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntity));
		}
		return beans;
	}

	@Override
	public Pricehistory save(Pricehistory pricehistory) {
		return update(pricehistory) ;
	}

	@Override
	public Pricehistory create(Pricehistory pricehistory) {
		PricehistoryEntity pricehistoryEntity = pricehistoryJpaRepository.findOne(pricehistory.getPricehistoryid());
		if( pricehistoryEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		pricehistoryEntity = new PricehistoryEntity();
		pricehistoryServiceMapper.mapPricehistoryToPricehistoryEntity(pricehistory, pricehistoryEntity);
		PricehistoryEntity pricehistoryEntitySaved = pricehistoryJpaRepository.save(pricehistoryEntity);
		return pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntitySaved);
	}

	@Override
	public Pricehistory update(Pricehistory pricehistory) {
		PricehistoryEntity pricehistoryEntity = pricehistoryJpaRepository.findOne(pricehistory.getPricehistoryid());
		pricehistoryServiceMapper.mapPricehistoryToPricehistoryEntity(pricehistory, pricehistoryEntity);
		PricehistoryEntity pricehistoryEntitySaved = pricehistoryJpaRepository.save(pricehistoryEntity);
		return pricehistoryServiceMapper.mapPricehistoryEntityToPricehistory(pricehistoryEntitySaved);
	}

	@Override
	public void delete(String pricehistoryid) {
		pricehistoryJpaRepository.delete(pricehistoryid);
	}

	public PricehistoryJpaRepository getPricehistoryJpaRepository() {
		return pricehistoryJpaRepository;
	}

	public void setPricehistoryJpaRepository(PricehistoryJpaRepository pricehistoryJpaRepository) {
		this.pricehistoryJpaRepository = pricehistoryJpaRepository;
	}

	public PricehistoryServiceMapper getPricehistoryServiceMapper() {
		return pricehistoryServiceMapper;
	}

	public void setPricehistoryServiceMapper(PricehistoryServiceMapper pricehistoryServiceMapper) {
		this.pricehistoryServiceMapper = pricehistoryServiceMapper;
	}

	@Override
	public boolean exists(String pricehistoryid) {
		return pricehistoryJpaRepository.exists(pricehistoryid);
	}

	@Override
	public long count() {
		return pricehistoryJpaRepository.count();
	}

}
