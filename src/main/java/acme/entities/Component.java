package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends AbstractEntity{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	4)	A component is an invention that is not 
//expected to work standalone, but in conjunction
//with other components.  The system must store the 
//following data about them:  
//x	a name (not blank,shorter than 101 characters),
//x a code (pattern “^[A-Z]{3}-[0-9]{3}(-[A-Z])?$”, unique),
//a technology (not blank, shorter than 101 characters)
//, a description (not blank, shorter than 256 characters)
//, a retail price (positive),
//and an optional link with further information. 
	@NotBlank
	@Length(max=101)
	protected String name;
	
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(max=101)
	protected String technology;
	
	@NotBlank
	@Length(max=256)
	protected String description;
	
	@Min(0)
	protected Double retailPrice;
	
	@URL
	protected String optionalLink;
}
