package com.bh08.hungarian_spanish_dictionary.daos;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bh08.hungarian_spanish_dictionary.model.Word;

public class WordDAO implements DAO<Word> {

	private static WordDAO instance;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DictionaryPU");

	private WordDAO() {

	}

	public static WordDAO getInstance() {
		if (instance == null) {
			instance = new WordDAO();
		}
		return instance;
	}

	public Word save(Word obj) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(obj);
		
		tx.commit();
		
		em.close();
		return obj;
	}

	public Optional<Word> findBySearchTerm(String hungarianWord) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Word> q = em.createQuery("SELECT w FROM Word w WHERE w.hungarianWord = :hungarianWord", Word.class);
		q.setParameter("hungarianWord", hungarianWord);
		try {
			Word result = q.getSingleResult();
			return Optional.of(result);
		} catch (NoResultException e) {
			return Optional.empty();
		} finally {
			em.close();
		}
	}

}
