package com.example.Film.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.Film.Dto.Film;
import com.example.Film.Response.ResponseStructure;
import com.example.Film.Service.FilmService;

@Controller
public class FilmController {
	
	@Autowired
	FilmService filmService;
	
	@PostMapping("addFilm")
	public ResponseEntity<?> addFilm(@RequestBody Film film){
	ResponseStructure responseStructure	=filmService.addFilm(film);
	return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	
	}
	
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestHeader Integer id){
	ResponseStructure<?> responseStructure	=filmService.getByid(id);
	return new ResponseEntity(responseStructure,responseStructure.getHttpStatus());
		
	}
	@GetMapping("getALL")
	public ResponseEntity<?> getAll(){
	ResponseStructure responseStructure=	filmService.getAll();
	return new ResponseEntity(responseStructure,responseStructure.getHttpStatus());
	
	}
	@PutMapping("updatefilm")
	public ResponseEntity<?> updateFilm(@RequestHeader int id,@RequestHeader double price){
		ResponseStructure responseStructure=	filmService.updateFilm(id,price);
		return new ResponseEntity(responseStructure,responseStructure.getHttpStatus());
		
		}
	
	@DeleteMapping("deletefilm")
	public ResponseEntity<?> deleteFilm(@RequestHeader int id){
		ResponseStructure responseStructure=	filmService.deleteFilm(id);
		return new ResponseEntity(responseStructure,responseStructure.getHttpStatus());
		
		}
	
	@GetMapping("getByPrice")
	public ResponseEntity<?> getByPrice(@RequestHeader double price){
		ResponseStructure responseStructure=filmService.getByPrice(price);
	
		return new ResponseEntity(responseStructure,responseStructure.getHttpStatus());
		
	}
	
	
	
	
	

}
