package com.example.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.contracts.repository.ActorRepository;
import com.example.domain.contracts.service.ActorService;
import com.example.domain.entities.Actor;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.ItemNotFoundException;

@Service
public class ActorServiceImpl implements ActorService {

private ActorRepository dao;
	
	public ActorServiceImpl(ActorRepository dao) {
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
			throw new DuplicateKeyException("Ya existe.");
		}
		return dao.save(item);
	}

	@Override
	public Actor modify(Actor item) throws ItemNotFoundException, InvalidDataException {
		if (item == null) {
			throw new InvalidDataException("El actor no puede ser nulo.");
		}
		var actor = dao.findById(item.getActorId());
		if (actor.isPresent()) {
			Actor a = actor.get();
			a.setFirstName(item.getFirstName());
			a.setLastName(item.getLastName());
			a.setLastUpdate(item.getLastUpdate());
			return dao.save(a);
		} else {
			throw new ItemNotFoundException("No existe actor con este ID.");
		}	
	}

	@Override
	public void delete(Actor item) throws InvalidDataException {
		if (item == null) {
			throw new InvalidDataException("No puede ser nulo.");
		}
		dao.delete(item);
		
	}

	@Override
	public void deleteById(Integer id) throws ItemNotFoundException {
		if (!dao.findById(id).isPresent()) {
			throw new ItemNotFoundException("No existe actor con id: "+id);
		}
		dao.deleteById(id);
	}

}
