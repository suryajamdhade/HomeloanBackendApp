package com.re.app.model;

import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusinessTypeDocs extends AllDocuments{

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    private int documentID;
	@Lob
	private byte[] GST;
}
