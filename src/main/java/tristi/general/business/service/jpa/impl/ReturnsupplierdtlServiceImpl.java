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

import tristi.general.bean.Returnsupplierdtl;
import tristi.general.bean.jpa.ReturnsupplierdtlEntity;
import tristi.general.business.service.ReturnsupplierdtlService;
import tristi.general.business.service.jpa.mapping.ReturnsupplierdtlServiceMapper;
import tristi.general.data.repository.jpa.ReturnsupplierdtlJpaRepository;

/**
 * Implementation of ReturnsupplierdtlService
 */
@Component
@Transactional
public class ReturnsupplierdtlServiceImpl implements ReturnsupplierdtlService {

	@Resource
	private ReturnsupplierdtlJpaRepository returnsupplierdtlJpaRepository;

	@Resource
	private ReturnsupplierdtlServiceMapper returnsupplierdtlServiceMapper;
	
	@Override
	public Returnsupplierdtl findById(String returndtlid) {
		ReturnsupplierdtlEntity returnsupplierdtlEntity = returnsupplierdtlJpaRepository.findOne(returndtlid);
		return returnsupplierdtlServiceMapper.mapReturnsupplierdtlEntityToReturnsupplierdtl(returnsupplierdtlEntity);
	}

	@Override
	public List<Returnsupplierdtl> findAll() {
		Iterable<ReturnsupplierdtlEntity> entities = returnsupplierdtlJpaRepository.findAll();
		List<Returnsupplierdtl> beans = new ArrayList<Returnsupplierdtl>();
		for(ReturnsupplierdtlEntity returnsupplierdtlEntity : entities) {
			beans.add(returnsupplierdtlServiceMapper.mapReturnsupplierdtlEntityToReturnsupplierdtl(returnsupplierdtlEntity));
		}
		return beans;
	}

	@Override
	public Returnsupplierdtl save(Returnsupplierdtl returnsupplierdtl) {
		return update(returnsupplierdtl) ;
	}

	@Override
	public Returnsupplierdtl create(Returnsupplierdtl returnsupplierdtl) {
		ReturnsupplierdtlEntity returnsupplierdtlEntity = returnsupplierdtlJpaRepository.findOne(returnsupplierdtl.getReturndtlid());
		if( returnsupplierdtlEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		returnsupplierdtlEntity = new ReturnsupplierdtlEntity();
		returnsupplierdtlServiceMapper.mapReturnsupplierdtlToReturnsupplierdtlEntity(returnsupplierdtl, returnsupplierdtlEntity);
		ReturnsupplierdtlEntity returnsupplierdtlEntitySaved = returnsupplierdtlJpaRepository.save(returnsupplierdtlEntity);
		return returnsupplierdtlServiceMapper.mapReturnsupplierdtlEntityToReturnsupplierdtl(returnsupplierdtlEntitySaved);
	}

	@Override
	public Returnsupplierdtl update(Returnsupplierdtl returnsupplierdtl) {
		ReturnsupplierdtlEntity returnsupplierdtlEntity = returnsupplierdtlJpaRepository.findOne(returnsupplierdtl.getReturndtlid());
		returnsupplierdtlServiceMapper.mapReturnsupplierdtlToReturnsupplierdtlEntity(returnsupplierdtl, returnsupplierdtlEntity);
		ReturnsupplierdtlEntity returnsupplierdtlEntitySaved = returnsupplierdtlJpaRepository.save(returnsupplierdtlEntity);
		return returnsupplierdtlServiceMapper.mapReturnsupplierdtlEntityToReturnsupplierdtl(returnsupplierdtlEntitySaved);
	}

	@Override
	public void delete(String returndtlid) {
		returnsupplierdtlJpaRepository.delete(returndtlid);
	}

	public ReturnsupplierdtlJpaRepository getReturnsupplierdtlJpaRepository() {
		return returnsupplierdtlJpaRepository;
	}

	public void setReturnsupplierdtlJpaRepository(ReturnsupplierdtlJpaRepository returnsupplierdtlJpaRepository) {
		this.returnsupplierdtlJpaRepository = returnsupplierdtlJpaRepository;
	}

	public ReturnsupplierdtlServiceMapper getReturnsupplierdtlServiceMapper() {
		return returnsupplierdtlServiceMapper;
	}

	public void setReturnsupplierdtlServiceMapper(ReturnsupplierdtlServiceMapper returnsupplierdtlServiceMapper) {
		this.returnsupplierdtlServiceMapper = returnsupplierdtlServiceMapper;
	}

	@Override
	public boolean exists(String returndtlid) {
		return returnsupplierdtlJpaRepository.exists(returndtlid);
	}

	@Override
	public long count() {
		return returnsupplierdtlJpaRepository.count();
	}

}
