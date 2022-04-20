package acme.features.inventor.toolkit;

import acme.entities.TypeExchange;
import acme.framework.datatypes.Money;

public class MoneyExchange {
	public static Money changeCurrency(final Money source, final String targetCurrency, final InventorToolkitRepository inventorToolkitRepository) {
		Money result = new Money();
		
		if(source.getCurrency().equals(targetCurrency)) {
			result=source;
		}else {
			final  TypeExchange typeExchange = inventorToolkitRepository.findTypeExchangeBySourceCurrency(source.getCurrency(), targetCurrency);
			result.setAmount(source.getAmount()*typeExchange.getFactor());
			result.setCurrency(targetCurrency);
		}
		
		
		return result;
	}

}
