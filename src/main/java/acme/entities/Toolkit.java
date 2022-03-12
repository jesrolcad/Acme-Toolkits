package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Toolkit extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	a code (pattern “^[A-Z]{3}-[0-9]{3}(-[A-Z])?$”, unique), 
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
//	title (not blank, shorter than 101 characters),
	@NotBlank
	@Length(max=101)
	protected String title;
//	description (not blank, shorter than 256 characters), 
	@NotBlank
	@Length(max=256)
	protected String description;
//	assembly notes (not blank, shorter than 256 characters), 
	@NotBlank
	@Length(max=256)
	protected String assemblyNotes;
//	and an optional link
	@URL
	protected String optionalLink;
	
	

}
