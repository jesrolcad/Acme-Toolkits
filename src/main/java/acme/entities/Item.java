package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	protected TipoDeItem tipo;
	
	@NotBlank
	@Length(max=101)
	protected String name;
	
	@NotBlank
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(max=101)
	protected String technology;
	
	@NotBlank
	@Length(max=256)
	protected String description;
	
	@Valid
	protected Money retailPrice;
	
	protected boolean published;
	
	@URL
	protected String optionalLink;
	
//	//Relations with other entities
//	//Relation with inventor
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Inventor inventor;
}
