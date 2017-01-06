package com.hand.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.dto.PageRerult;
import com.hand.dto.Result;
import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;



@Controller
@RequestMapping("/film")
public class FilmController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	FilmService  filmService;
	@Autowired
	LanguageService languageService; 
	
	
	
	
	@RequestMapping(value="/PageList",
	        produces = {"application/json;charset=UTF-8"})
	@ResponseBody
    public PageRerult<Film> filmlistByPage(@RequestParam(value = "filmId", required = false, defaultValue = "") Short filmId,
                                           @RequestParam(value = "title", required = false, defaultValue = "") String title,
                                           @RequestParam(value = "offset",required = false, defaultValue = "1") int offset,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize){
	    
        Film film=new Film();
        film.setFilmId(filmId);
        film.setTitle(title);
        PageHelper.startPage(offset, pageSize);
        List<Film> films=filmService.queryFilmList(film);
        for(Film f:films){
            System.out.println(f.getTitle()+" filmId:"+f.getFilmId()+"LanguageName:"+f.getLanguage().getName());
        }
        PageInfo<Film> pageinfo=new PageInfo<>(films);
        int count=(int)pageinfo.getTotal();
        System.out.println("tatolPage:"+count/pageSize);
        PageRerult<Film> filmPage=new PageRerult<>();
        filmPage.setNowPage(offset);
        filmPage.setTatolPage(count/pageSize+1);
        filmPage.setPageSize(pageSize);
        filmPage.setT(films);
        return filmPage;
    }
	
	@RequestMapping(value="/delete" ,method = RequestMethod.GET,
	        produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Short filmId){
		if(filmId==null){
		    String data="filmId为空";
			return data;
		}
		try {
		    int i=filmService.deteletFilmById(filmId);
		    if(i<1){
		        String data="success";
		        return data;
		    }
        } catch (Exception e) {
            System.out.println(e.toString());
          String data ="有外键，无法删除";
          return data;
        }
		return null;
		
	}
	@RequestMapping(value="/insert" ,method=RequestMethod.GET)
	public String insertFilm(String title,String description,Byte languageId){
		int i=filmService.insertFilm(title, description, languageId);
		return "redirect:/html/filmlist.html";
		
	}
	
	@RequestMapping(value="/update" ,method=RequestMethod.GET)
	public String updateFilm(String title,String description,Byte languageId,Short filmId){
		int i=filmService.updateFilm(title, description, languageId, filmId);
		System.out.println("asdasd"+i);
		return "redirect:/html/filmlist.html";
	}
	@RequestMapping(value="/getfilmById" ,method = RequestMethod.GET,
	        produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Film to_update(@RequestParam(value = "filmId", required = false, defaultValue = "") Short filmId){
		if(filmId==null){
			return null;
		}
		Film film=filmService.getFilmById(filmId);
		return film;
	}
	
}
