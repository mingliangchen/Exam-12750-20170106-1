package com.hand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hand.entity.Film;

public interface FilmMapper {
    List<Film> selectAllFilm(Film film);
    int insertFilm(@Param("title") String title,
                   @Param("description") String description,
                   @Param("languageId") Byte language_id);

    int updateFilm(@Param("title") String title,
                   @Param("description") String description,
                   @Param("languageId") Byte language_id,
                   @Param("filmId") Short filmid);
    Film getOneFilm(short filmId);
    int deteleById(short filmId);
}