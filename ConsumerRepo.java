package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.ConsumerModel;

public interface ConsumerRepo extends CrudRepository<ConsumerModel, Integer>{

	
}
