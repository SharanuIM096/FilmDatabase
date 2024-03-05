package com.example.Film.Service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Film.Dao.FilmDao;
import com.example.Film.Dto.Film;
import com.example.Film.Response.ResponseStructure;

@Service
public class FilmService {
	
	@Autowired
	FilmDao filmDao;
	public ResponseStructure<?> addFilm(Film film){
		
     Film f=filmDao.addFilm(film);
     
     ResponseStructure<Film> responseStructure=new ResponseStructure<>();
     responseStructure.setData(f);
     responseStructure.setHttpStatus(HttpStatus.CREATED);
    return responseStructure;
		
	}
	
	public ResponseStructure<?> getByid(int id){
		Film film=filmDao.getById(id);
		
		ResponseStructure<Film> responseStructure=new ResponseStructure<>();
		responseStructure.setData(film);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		return responseStructure;
		
	
	}
	public ResponseStructure<?> getAll(){
	List<Film>f=filmDao.getAll();
		
		ResponseStructure<List<Film>> responseStructure=new ResponseStructure<>();
		responseStructure.setData(f);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		return responseStructure;
		
	}
	public ResponseStructure<?> updateFilm(int id,double price){
		Film f=filmDao.updateFilm(id,price);
			
			ResponseStructure<Film> responseStructure=new ResponseStructure<>();
			responseStructure.setData(f);
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			return responseStructure;
			
		}
	public ResponseStructure<?> deleteFilm(int id){
		Film f=filmDao.deleteFilm(id);
			
			ResponseStructure<Film> responseStructure=new ResponseStructure<>();
			responseStructure.setData(f);
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			return responseStructure;
			
		}
	
	public ResponseStructure<?> getByPrice(double price){
	List<Film> f	=filmDao.getByPrice(price);
	ResponseStructure<List<Film>> responseStructure=new ResponseStructure<>();
	responseStructure.setData(f);
	responseStructure.setHttpStatus(HttpStatus.FOUND);
	return responseStructure;
	}
	
	

}
