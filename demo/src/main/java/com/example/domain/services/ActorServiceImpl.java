package com.example.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.contracts.repositories.ActoresRepository;
import com.example.domain.contracts.services.ActorService;
import com.example.domain.core.contracts.service.InvalidDataException;
import com.example.domain.entities.Actor;

@Service
public class ActorServiceImpl implements ActorService {
	
	private ActoresRepository dao;
	
	public ActorServiceImpl(ActoresRepository dao) {
		this.dao = dao;
	}

	@Override
	public List<Actor> getAll() {		
		return dao.findAll();
	}

	@Override
	public Optional<Actor> getOne(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public Actor add(Actor item) throws DuplicateKeyException, InvalidDataException {
		if (item == null) {
			throw new InvalidDataException("El actor no puede ser nulo.");
		}
		if (item.getActorId()>0 && dao.existsById(item.getActorId())) {
			throw new DuplicateKeyExceptio("Ya existe.");
		}
		return dao.save(item);
	}

	@Override
	public Actor modify(Actor item) throws NotFoundException, InvalidDataException {
		
		return null;
	}

	@Override
	public void delete(Actor item) throws InvalidDataException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void repartePremios() {
		// TODO Auto-generated method stub

	}

}
