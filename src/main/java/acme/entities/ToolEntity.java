package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToolEntity extends Artefacto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//a retail price (zero or positive), 
	@Min(0)
	protected Double retailPrice;
	
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
//	//Relations with other entities
//	//relation with Toolkit
	@NotNull
	@Valid
	@OneToOne(optional=false)
	protected Toolkit toolkit;
	

}
