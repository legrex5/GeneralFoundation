/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tristi.general.bean.Category;
import tristi.general.bean.jpa.CategoryEntity;
import tristi.general.business.service.CategoryService;
import tristi.general.business.service.jpa.mapping.CategoryServiceMapper;
import tristi.general.data.repository.jpa.CategoryJpaRepository;

/**
 * Implementation of CategoryService
 */
@Component
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryJpaRepository categoryJpaRepository;

	@Resource
	private CategoryServiceMapper categoryServiceMapper;
	
	@Override
	public Category findById(String categoryid) {
		CategoryEntity categoryEntity = categoryJpaRepository.findOne(UUID.fromString(categoryid));
		return categoryServiceMapper.mapCategoryEntityToCategory(categoryEntity);
	}

	@Override
	public List<Category> findAll() {
		Iterable<CategoryEntity> entities = categoryJpaRepository.findAll();
		List<Category> beans = new ArrayList<Category>();
		for(CategoryEntity categoryEntity : entities) {
			beans.add(categoryServiceMapper.mapCategoryEntityToCategory(categoryEntity));
		}
		return beans;
	}

	@Override
	public Category save(Category category) {
		return update(category) ;
	}

	@Override
	public Category create(Category category) {
		CategoryEntity categoryEntity = categoryJpaRepository.findOne(UUID.fromString(category.getCategoryid()));
		if( categoryEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		categoryEntity = new CategoryEntity();
		categoryServiceMapper.mapCategoryToCategoryEntity(category, categoryEntity);
		CategoryEntity categoryEntitySaved = categoryJpaRepository.save(categoryEntity);
		return categoryServiceMapper.mapCategoryEntityToCategory(categoryEntitySaved);
	}

	@Override
	public Category update(Category category) {
		CategoryEntity categoryEntity = categoryJpaRepository.findOne(UUID.fromString(category.getCategoryid()));
		categoryServiceMapper.mapCategoryToCategoryEntity(category, categoryEntity);
		CategoryEntity categoryEntitySaved = categoryJpaRepository.save(categoryEntity);
		return categoryServiceMapper.mapCategoryEntityToCategory(categoryEntitySaved);
	}

	@Override
	public void delete(String categoryid) {
		categoryJpaRepository.delete(UUID.fromString(categoryid));
	}

	public CategoryJpaRepository getCategoryJpaRepository() {
		return categoryJpaRepository;
	}

	public void setCategoryJpaRepository(CategoryJpaRepository categoryJpaRepository) {
		this.categoryJpaRepository = categoryJpaRepository;
	}

	public CategoryServiceMapper getCategoryServiceMapper() {
		return categoryServiceMapper;
	}

	public void setCategoryServiceMapper(CategoryServiceMapper categoryServiceMapper) {
		this.categoryServiceMapper = categoryServiceMapper;
	}

	@Override
	public boolean exists(String categoryid) {
		return categoryJpaRepository.exists(UUID.fromString(categoryid));
	}

	@Override
	public long count() {
		return categoryJpaRepository.count();
	}

}
