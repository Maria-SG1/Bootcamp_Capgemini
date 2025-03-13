package com.example.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.domain.contracts.repository.CategoryRepository;
import com.example.domain.contracts.service.CategoryService;
import com.example.domain.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository dao;
	public CategoryServiceImpl(CategoryRepository dao) {
		this.dao = dao;
	}
	@Override
	public <S extends Category> S save(S entity) {
		return dao.save(entity);
	}
	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}
	@Override
	public Optional<Category> findById(Integer id) {
		return dao.findById(id);
	}
	@Override
	public void delete(Category entity) {
		dao.delete(entity);
	}
	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

}
