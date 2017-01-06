package com.hand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.entity.Language;
import com.hand.service.LanguageService;

@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService; 
    @RequestMapping("/getLanguage")
    @ResponseBody
    public List<Language> getLanguage(){
        List<Language> languages= languageService.getLanguageName();
        return languages;
    }
}
