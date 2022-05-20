package acme.features.patron.patronage;
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
import acme.roles.Patron; 
 
@Service 
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage>{ 
	 
	 
	@Autowired 
	protected PatronPatronageRepository repository; 
	
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null;
		boolean result;
		int patronageID;
		Patron patron;
		Patronage pat;
		
		patronageID = request.getModel().getInteger("id");
		pat = this.repository.findPatronageById(patronageID);
		patron =this.repository.findPatronByUserAccountId(request.getPrincipal().getAccountId());
		result = pat.getPatron().equals(patron);
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
			conversion = this.repository.findMoneyExchangeByCurrencyAndAmount(money.getCurrency(), money.getAmount());
			
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
		 
		model.setAttribute("confirmation", false); 
		model.setAttribute("inventors", this.repository.allInventors());
		model.setAttribute("conversion", this.conversion(entity.getBudget()).getTarget());
		model.setAttribute("inventorId", entity.getInventor().getId());

		request.unbind(entity, model, "code", "budget", "legalStuff", "link", "startDate","endDate","status","published","inventor.userAccount.username","inventor.company","inventor.link","inventor.statement");	 

	} 
 
} 