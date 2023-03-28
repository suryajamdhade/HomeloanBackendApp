package com.re.app.model;

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
<<<<<<< HEAD:REModule/src/main/java/com/re/app/model/APFDetails.java
	private int APFId;
	private String APFBuilderName;
	private char APFBuilderCategory;
	
	
=======
	private int id;
	private String landmark;
	private String areaname;
	private String city;
	private int    pincode;
	private String state;
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d:Admin-Service/src/main/java/com/adm/app/model/Bankaddress.java
}
