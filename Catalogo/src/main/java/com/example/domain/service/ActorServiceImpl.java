package com.example.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.domain.contracts.repository.ActorRepository;
import com.example.domain.contracts.service.ActorService;
import com.example.domain.entities.Actor;

@Service
public class ActorServiceImpl implements ActorService {
	
	private ActorRepository dao;
	
	public ActorServiceImpl(ActorRepository dao) {
		this.dao = dao;
	}
	
	@Override
	public <S extends Actor> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public List<Actor> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Actor> findById(Integer id) {
		return dao.findById(id);
	}	

	@Override
	public void delete(Actor entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}	

}
