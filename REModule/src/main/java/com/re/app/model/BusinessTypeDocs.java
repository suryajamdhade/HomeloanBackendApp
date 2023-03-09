package com.re.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusinessTypeDocs extends AllDocuments{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int documentID;
	private byte[] GST;
}
