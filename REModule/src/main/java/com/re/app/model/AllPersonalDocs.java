package com.re.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AllPersonalDocs {

	@OneToMany(cascade = CascadeType.ALL)
	private SalariedTypeDocs salDocs;

	@OneToMany(cascade = CascadeType.ALL)
	private BusinessTypeDocs busDocs;

}
