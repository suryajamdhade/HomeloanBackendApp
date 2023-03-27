package com.cm.app.model;

import java.util.List;	

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class APFDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int APFId;
	private String APFProjectName;
	private String APFBuilderName;
	private char APFBuilderCategory;
	private String APFLocation; 
}
