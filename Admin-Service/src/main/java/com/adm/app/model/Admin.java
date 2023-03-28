package com.adm.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD

	private int admId;
//	private String admUsername;
//	private String admPassword; 
	

	private int id;
	private String username;
	private String password;

=======
	private int id;
	private String username;
	private String password;
>>>>>>> 16749be6de6c99a8cfd39ef5e0fa2bb83dc7444d
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> eDetails;
	

}
