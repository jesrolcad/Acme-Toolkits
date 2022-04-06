package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@NotBlank
	protected String code;

	
	@NotBlank
	@Length(max=256)
	protected String description;
 
	@NotBlank
	@Length(max=256)
	protected String assemblyNotes;
	
	protected boolean published;

	
	@URL
	protected String optionalLink;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Inventor inventor;
	
	
	

}
