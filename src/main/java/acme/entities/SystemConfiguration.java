package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfiguration extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	public String acceptedCurrencies;
	
	@NotBlank
	public String systemCurrency;
	
	@NotBlank
	public String strongSpamWords;
	
	@Range(min = 0, max = 100)
	@Digits(integer = 3, fraction = 2)
	@NotNull
	public double strongSpamThreshold;
	
	@NotBlank
	public String weakSpamWords;
	
	@Range(min = 0, max = 100)
	@Digits(integer = 3, fraction = 2)
	@NotNull
	public double weakSpamThreshold;
	
	@NotBlank
	public String moneyExchangeServiceName;
	
	@NotBlank
	@Length(max=256)
	public String moneyExchangeServiceDescription;
	
	@URL
	public String moneyExchangeServiceLink;

}
