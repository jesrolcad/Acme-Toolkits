package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends Artefacto{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// a retail price (positive)
	@Positive
	protected Double retailPrice;
	
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	
//	//Relations with other entities
//	//Relation with toolkit
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Toolkit toolkit;
}
