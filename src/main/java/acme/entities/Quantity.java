package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Positive
	protected Integer number;
	
//	//Relations with other entities
//	//Relation with Item
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Item item;
	
//	//Relations with other entities
//	//Relation with toolkit
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Toolkit toolkit;
}
