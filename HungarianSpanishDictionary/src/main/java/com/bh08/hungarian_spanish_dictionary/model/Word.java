package com.bh08.hungarian_spanish_dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "WORD_ID")
	private long id;
	
	@Column(unique = true, nullable = false)
	private String hungarianWord;
	
	@Column(unique = true, nullable = false)
	private String spanishWord;
	
	
}
