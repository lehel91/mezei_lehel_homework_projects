package com.bh08.hungarian_spanish_dictionary.services;

import java.util.Optional;

import com.bh08.hungarian_spanish_dictionary.daos.WordDAO;
import com.bh08.hungarian_spanish_dictionary.model.Word;

public class DictionaryService {
	private WordDAO dao = WordDAO.getInstance();
	
	public Optional<Word> findByHungarianWord(String hungarianWord) {
		return dao.findBySearchTerm(hungarianWord);
	}
	
	public Word save(Word word) {
		return dao.save(word);
	}
}
