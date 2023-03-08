package com.re.app.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AllPersonalDocs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int perosnaldocs;

	@OneToMany(cascade = CascadeType.ALL)
	private List<SalariedTypeDocs> salDocs;;

	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessTypeDocs> busDocs;

}
