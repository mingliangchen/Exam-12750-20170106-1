package com.hand.service;

import java.util.List;

import com.hand.entity.Film;

public interface FilmService {
	List<Film> queryFilmList(Film film);
	int insertFilm(String title,String description,Byte languageid);
	
	int updateFilm(String title,String description,Byte languageid,Short filmId);
	
	Film getFilmById(Short filmId);
	int deteletFilmById(Short filmId) throws Exception;
}
