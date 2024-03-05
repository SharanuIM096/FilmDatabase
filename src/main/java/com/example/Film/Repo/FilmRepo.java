package com.example.Film.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Film.Dto.Film;

public interface FilmRepo extends JpaRepository<Film, Integer> {

	@Query(value="select * from film where price=?1",nativeQuery=true)
	public List<Film> getByPrice(double price);
		

}
