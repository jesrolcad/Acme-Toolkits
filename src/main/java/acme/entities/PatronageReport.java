package acme.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Pattern(regexp = "^<[A-Z]{3}-[0-9]{3}(-[A-Z])?:[0-9]{4,6}>$")
	@Column(unique = true)
	protected String			sequenceNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				creationMoment;
	
	@NotBlank
	@Length(max = 256)
	protected String 			memorandum;
	
	@URL
	protected String			link;
	
	// Derived attributes -----------------------------------------------------

	
	// Relationships ----------------------------------------------------------
	@JoinColumn(name = "patronageId", referencedColumnName = "id")
	protected Patronage			patronage;
	
}