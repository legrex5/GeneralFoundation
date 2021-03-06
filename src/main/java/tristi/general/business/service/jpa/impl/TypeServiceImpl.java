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

import tristi.general.bean.Type;
import tristi.general.bean.jpa.TypeEntity;
import tristi.general.business.service.TypeService;
import tristi.general.business.service.jpa.mapping.TypeServiceMapper;
import tristi.general.data.repository.jpa.TypeJpaRepository;

/**
 * Implementation of TypeService
 */
@Component
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	private TypeJpaRepository typeJpaRepository;

	@Resource
	private TypeServiceMapper typeServiceMapper;
	
	@Override
	public Type findById(String typeid) {
		TypeEntity typeEntity = typeJpaRepository.findOne(typeid);
		return typeServiceMapper.mapTypeEntityToType(typeEntity);
	}

	@Override
	public List<Type> findAll() {
		Iterable<TypeEntity> entities = typeJpaRepository.findAll();
		List<Type> beans = new ArrayList<Type>();
		for(TypeEntity typeEntity : entities) {
			beans.add(typeServiceMapper.mapTypeEntityToType(typeEntity));
		}
		return beans;
	}

	@Override
	public Type save(Type type) {
		return update(type) ;
	}

	@Override
	public Type create(Type type) {
		TypeEntity typeEntity = typeJpaRepository.findOne(type.getTypeid());
		if( typeEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		typeEntity = new TypeEntity();
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		TypeEntity typeEntitySaved = typeJpaRepository.save(typeEntity);
		return typeServiceMapper.mapTypeEntityToType(typeEntitySaved);
	}

	@Override
	public Type update(Type type) {
		TypeEntity typeEntity = typeJpaRepository.findOne(type.getTypeid());
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		TypeEntity typeEntitySaved = typeJpaRepository.save(typeEntity);
		return typeServiceMapper.mapTypeEntityToType(typeEntitySaved);
	}

	@Override
	public void delete(String typeid) {
		typeJpaRepository.delete(typeid);
	}

	public TypeJpaRepository getTypeJpaRepository() {
		return typeJpaRepository;
	}

	public void setTypeJpaRepository(TypeJpaRepository typeJpaRepository) {
		this.typeJpaRepository = typeJpaRepository;
	}

	public TypeServiceMapper getTypeServiceMapper() {
		return typeServiceMapper;
	}

	public void setTypeServiceMapper(TypeServiceMapper typeServiceMapper) {
		this.typeServiceMapper = typeServiceMapper;
	}

	@Override
	public boolean exists(String typeid) {
		return typeJpaRepository.exists(typeid);
	}

	@Override
	public long count() {
		return typeJpaRepository.count();
	}

}
