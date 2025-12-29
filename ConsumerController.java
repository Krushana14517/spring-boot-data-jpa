package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.ConsumerModel;
import com.crud.service.ConService;

@RestController
public class ConsumerController {
	@Autowired
	ConService serv;

	@GetMapping("/get")
	public ResponseEntity<?>get()
	{
		return serv.getall();
	}
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<?>getbyid(@PathVariable int id)
	{
		return serv.getbyid(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>addnew(@RequestBody ConsumerModel consumerModel)
	{
		return serv.add(consumerModel);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?>delete(@PathVariable int id , @RequestBody ConsumerModel consumerModel)
	{
		return serv.update(id,consumerModel);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>delete(@PathVariable int id)
	{
		return serv.delete(id);
	}
	
}
