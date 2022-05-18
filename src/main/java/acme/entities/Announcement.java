
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Announcement extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				moment;
	

	@Length(max = 100)
	@NotBlank
	protected String			title;

	@Length(max = 255)
	@NotBlank
	protected String			body;
	
	
	protected boolean			critical;
	
	@URL
	protected String			info;

	// Derived attributes -----------------------------------------------------
	
	@Valid
	protected boolean			spam;

	// Relationships ----------------------------------------------------------

}
