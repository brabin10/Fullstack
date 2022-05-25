package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@Controller //make the class Bean, and with MVC it lets us use all of the below annotaions..
@RequestMapping(value="/avenger") //all requests ending in /mvc/avenger will go to this controller
@CrossOrigin // this lets us take in HTTP requests from other 
public class AvengerController {
	
	public AvengerDAO aDAO;
	
	@Autowired
	public AvengerController(AvengerDAO aDAO) {
		super();
		this.aDAO = aDAO;
	}
	
	@GetMapping
	public List<Avenger> assemble() {
		return Arrays.asList(aDAO.getAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Avenger> getAvengerById(@PathVariable("id") int id){
		
		Avenger avenger = aDAO.getById(id);
		
		if(avenger == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(avenger);
		}
		
		return ResponseEntity.ok(avenger);
	}

}
