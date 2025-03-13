package com.example.domain.contracts.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.entities.Actor;

public interface ActorService {

	<S extends Actor> S save(S entity);

	List<Actor> findAll();

	Optional<Actor> findById(Integer id);

	void delete(Actor entity);

	void deleteAll();

}