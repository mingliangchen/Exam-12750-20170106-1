package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dao.FilmMapper;
import com.hand.entity.Film;
import com.hand.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	FilmMapper filmMapper;

	@Override 
	public List<Film> queryFilmList(Film film) {
	    
		List<Film> filmList = filmMapper.selectAllFilm(film);
		return filmList;
	}

    @Override
    public int insertFilm(String title, String description, Byte languageId) {
        int i=filmMapper.insertFilm(title, description, languageId);
        return i;
    }

    @Override
    public int updateFilm(String title, String description, Byte languageid, Short filmId) {
        int i=filmMapper.updateFilm(title, description, languageid, filmId);
        return i;
    }

    @Override
    public Film getFilmById(Short filmId) {
        Film film =filmMapper.getOneFilm(filmId);
        return film;
    }

   

    @Override
    public int deteletFilmById(Short filmId) throws Exception{
        int i= filmMapper.deteleById(filmId);
        return i;
    }

   

	

}
