package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends Artefacto{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// a retail price (positive)
	@Positive
	protected Double retailPrice;
}
