package acme.features.inventor.patronage;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.MoneyExchange;
import acme.entities.Patronage;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor; 
 
@Service 
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{ 
	 
	 
	@Autowired 
	protected InventorPatronageRepository repository; 
	
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null;
		boolean result;
		int patronageID;
		Inventor inv;
		Patronage pat;
		
		patronageID = request.getModel().getInteger("id");
		pat = this.repository.findPatronageById(patronageID);
		inv =this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		result = pat.getInventor().equals(inv) && pat.isPublished();

		return result; 
	} 
 
	@Override 
	public Patronage findOne(final Request<Patronage> request) { 
		assert request != null; 
		 
		Patronage result; 
		int id; 
		 
		id=request.getModel().getInteger("id"); 
		result=this.repository.findPatronageById(id);
		return result; 
	} 
	
	
	/* Método que realiza conversiones de divisas. Si la divisa del objeto money que se pasa como parámetro
	 * es diferente de la divisa predeterminada de la configuración del sistema, entonces se obtiene o calcula 
	 * la conversión. En caso contrario, no es necesario realizar una conversión, por lo que los Money fuente y destino +
	 * son iguales. */
	public MoneyExchange conversion(final Money money) {
	
		final AuthenticatedMoneyExchangePerformService moneyExchange = new AuthenticatedMoneyExchangePerformService();
		
		MoneyExchange conversion = new MoneyExchange();
		
		final String systemCurrency = this.repository.findSystemCurrency();

		if(!money.getCurrency().equals(systemCurrency)) {
			conversion = this.repository.findMoneyExchangeByCurrencyAndAmount(money.getCurrency(), money.getAmount(),systemCurrency);
			
			if(conversion == null) {
				conversion = moneyExchange.computeMoneyExchange(money, systemCurrency);
				this.repository.save(conversion);
				
			}
			
		}else {
			conversion.setSource(money);
			conversion.setTarget(money);
			conversion.setCurrencyTarget(systemCurrency);
			conversion.setDate(new Date(System.currentTimeMillis()));
			
		}
		
		return conversion;
		
	}
 
	@Override 
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		final boolean differentCurrency = !entity.getBudget().getCurrency().equals(this.repository.findSystemCurrency());
		model.setAttribute("differentCurrency", differentCurrency);
		model.setAttribute("conversion", this.conversion(entity.getBudget()).getTarget());
		 
		request.unbind(entity, model, "code", "budget", "legalStuff", "link", "startDate","endDate","status","patron.userAccount.username","patron.company","patron.link","patron.statement");	 
		model.setAttribute("confirmation", false); 
		
	} 
 
} 
