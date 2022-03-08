package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

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

}
