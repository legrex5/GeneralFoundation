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

import tristi.general.bean.Uom;
import tristi.general.bean.jpa.UomEntity;
import tristi.general.business.service.UomService;
import tristi.general.business.service.jpa.mapping.UomServiceMapper;
import tristi.general.data.repository.jpa.UomJpaRepository;

/**
 * Implementation of UomService
 */
@Component
@Transactional
public class UomServiceImpl implements UomService {

	@Resource
	private UomJpaRepository uomJpaRepository;

	@Resource
	private UomServiceMapper uomServiceMapper;
	
	@Override
	public Uom findById(String uomid) {
		UomEntity uomEntity = uomJpaRepository.findOne(uomid);
		return uomServiceMapper.mapUomEntityToUom(uomEntity);
	}

	@Override
	public List<Uom> findAll() {
		Iterable<UomEntity> entities = uomJpaRepository.findAll();
		List<Uom> beans = new ArrayList<Uom>();
		for(UomEntity uomEntity : entities) {
			beans.add(uomServiceMapper.mapUomEntityToUom(uomEntity));
		}
		return beans;
	}

	@Override
	public Uom save(Uom uom) {
		return update(uom) ;
	}

	@Override
	public Uom create(Uom uom) {
		UomEntity uomEntity = uomJpaRepository.findOne(uom.getUomid());
		if( uomEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		uomEntity = new UomEntity();
		uomServiceMapper.mapUomToUomEntity(uom, uomEntity);
		UomEntity uomEntitySaved = uomJpaRepository.save(uomEntity);
		return uomServiceMapper.mapUomEntityToUom(uomEntitySaved);
	}

	@Override
	public Uom update(Uom uom) {
		UomEntity uomEntity = uomJpaRepository.findOne(uom.getUomid());
		uomServiceMapper.mapUomToUomEntity(uom, uomEntity);
		UomEntity uomEntitySaved = uomJpaRepository.save(uomEntity);
		return uomServiceMapper.mapUomEntityToUom(uomEntitySaved);
	}

	@Override
	public void delete(String uomid) {
		uomJpaRepository.delete(uomid);
	}

	public UomJpaRepository getUomJpaRepository() {
		return uomJpaRepository;
	}

	public void setUomJpaRepository(UomJpaRepository uomJpaRepository) {
		this.uomJpaRepository = uomJpaRepository;
	}

	public UomServiceMapper getUomServiceMapper() {
		return uomServiceMapper;
	}

	public void setUomServiceMapper(UomServiceMapper uomServiceMapper) {
		this.uomServiceMapper = uomServiceMapper;
	}

	@Override
	public boolean exists(String uomid) {
		return uomJpaRepository.exists(uomid);
	}

	@Override
	public long count() {
		return uomJpaRepository.count();
	}

}
