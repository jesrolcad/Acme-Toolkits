package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Artefacto extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(max=101)
	protected String name;
	
	
	@NotBlank
	@Length(max=101)
	protected String technology;
	
	@NotBlank
	@Length(max=256)
	protected String description;
	
	
	
	@URL
	protected String optionalLink;
}
