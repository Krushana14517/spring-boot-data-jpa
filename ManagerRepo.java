package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.ManagerModel;

public interface ManagerRepo extends CrudRepository<ManagerModel, Integer> {

}
