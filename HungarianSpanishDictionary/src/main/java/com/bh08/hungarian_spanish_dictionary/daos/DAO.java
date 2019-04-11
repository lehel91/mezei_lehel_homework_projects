package com.bh08.hungarian_spanish_dictionary.daos;

import java.util.Optional;

public interface DAO<T> {
	
	Optional<T> findBySearchTerm(String seachTerm);
	
	T save(T obj);
}
