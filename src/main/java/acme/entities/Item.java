package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
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
	
	protected TipoDeItem tipo;
	
	@NotBlank
	@Length(max=101)
	protected String name;
	
	
	@NotBlank
	@Length(max=101)
	protected String b;
	
	@NotBlank
	@Length(max=256)
	protected String description;
	
	@Positive
	protected Money retailPrice;
	
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	
	
	@URL
	protected String optionalLink;
}
