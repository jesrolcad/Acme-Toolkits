package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class TypeExchange extends AbstractEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$")
	protected String currency;
	
	@NotNull
	protected Double factor;
	
	//Atributos derivados
	
	
	//Relaciones
	@NotNull
	@ManyToOne(optional = false)
	@Valid
	protected CurrencyExchange currencyExchange;
}
