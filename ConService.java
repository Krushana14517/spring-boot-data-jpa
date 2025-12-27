package com.crud.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crud.model.CosumerModel;
import com.crud.repository.CosumerRepo;
import com.crud.wrapoer.ConsumerWraper;

@Service
public class ConService {

	@Autowired
	CosumerRepo repo;
	
	//get all data 
	public ResponseEntity<?>getall(){
		
		Iterable<CosumerModel> data = repo.findAll();
		Iterator<CosumerModel> alldata = data.iterator();
		
		if(alldata.hasNext())
		{
			ConsumerWraper obj =new ConsumerWraper();
			obj.setMessage("data found");
			obj.setData(alldata);
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data empty!!");
		}
		
	}
	

	
	//get by id
	
	public ResponseEntity<?>getbyid(int id)
	{
		 CosumerModel data = repo.findById(id).get();
		 
		 if(data != null)
		 {
			 ConsumerWraper obj =new ConsumerWraper();
				obj.setMessage("data found");
				obj.setData(data);
				return new ResponseEntity<>(obj, HttpStatus.FOUND);
		 }else
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "data empty!!");
			}
	}
	
	//add new data 
	
	public ResponseEntity<?>add(CosumerModel cosumerModel)
	{
		CosumerModel data = repo.save(cosumerModel);
		ConsumerWraper obj =new ConsumerWraper();
		obj.setMessage("data added");
		obj.setData(data);
		return new ResponseEntity<>(obj, HttpStatus.OK);
		
	}
	// update data
	
	public ResponseEntity<?>update(int id , CosumerModel cosumerModel)
	{
		CosumerModel Data  = repo.findById(id).orElseThrow(
				() ->{
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, " No Consumer");
				}
	             );
		cosumerModel.getId();
		cosumerModel.setId(id);
		CosumerModel newdata= repo.save(cosumerModel);
		
	    ConsumerWraper consumerWraper =  new ConsumerWraper();
	    consumerWraper.setMessage("Data Updated Succesfully");
	    consumerWraper.setData(newdata);
	    return new ResponseEntity<>(consumerWraper, HttpStatus.FOUND);
		
		
		//return  new ResponseEntity<>;
		
	}
	
	
	
	
	
	
	
	
	//delete by id 
	
	public ResponseEntity<?>delete(int id)
	{		
		 CosumerModel data = repo.findById(id).get();
		
		if(data != null)
		{
			repo.deleteById(id);
			ConsumerWraper obj =new ConsumerWraper();
			obj.setMessage("data delete");
			obj.setData(data);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found!!");
			
		}
	}
		

	
	
	
	

	
	
	
	
	
}
