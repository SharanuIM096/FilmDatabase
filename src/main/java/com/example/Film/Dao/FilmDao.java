package com.example.Film.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Film.Dto.Film;
import com.example.Film.Exception.FilmNotFoundException;
import com.example.Film.Repo.FilmRepo;
@Repository
public class FilmDao {
	
	@Autowired
	 FilmRepo filmRepo;
	public Film addFilm(Film film) {
		return filmRepo.save(film);
	}

	public Film getById(int id) {
		Optional<Film> ID=filmRepo.findById(id);
		if(ID.isPresent()) {
			 filmRepo.findById(id);
			 return ID.get();
			
		}
		else {
			throw new FilmNotFoundException("Id is not avialble in database");
		}
	}
	
	public List<Film> getAll(){
		List<Film> f=filmRepo.findAll();
		if(f.isEmpty()==false) {
			return filmRepo.findAll();
		}
		else {
			throw new FilmNotFoundException("database is empty");
		}
	}
	public Film updateFilm(int id,double price) {
	Optional<Film> fid	=filmRepo.findById(id);
	if(fid.isPresent()) {
		Film value=fid.get();
		value.setPrice(price);
		return filmRepo.save(value);
	}
	else {
		throw new FilmNotFoundException("film is not availble for upadation");
	}
	}
	
	public Film deleteFilm(int id) {
		Optional<Film> m=filmRepo.findById(id);
		if(m.isPresent()) {
			
			 filmRepo.deleteById(id);
			 return m.get();
		}
		else {
			throw new FilmNotFoundException("film does not exist");
			
		}
		
	}
	public List<Film> getByPrice(double price) {
	List<Film>f=filmRepo.getByPrice(price);
	if(!f.isEmpty()&&f!=null) {
		return f;
	}
	else {
		throw new  FilmNotFoundException("film does not exist");
	}
	}
	
}
