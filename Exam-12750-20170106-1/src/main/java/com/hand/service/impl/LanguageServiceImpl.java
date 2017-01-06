package com.hand.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dao.LanguageMapper;
import com.hand.entity.Language;
import com.hand.service.LanguageService;
@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	LanguageMapper languageMapper;
	@Override
	public List<Language> getLanguageName(){
		List<Language> List=languageMapper.selectLanguage();
		return List;
	}


}
