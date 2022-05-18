package acme.features.inventor.item; 
 
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.TipoDeItem;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor; 
 
@Service 
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item>{ 
 
	@Autowired 
	protected InventorItemRepository repository; 
	
	@Autowired
	protected InventorToolkitRepository toolkitRepo;
	 
	@Override 
	public boolean authorise(final Request<Item> request) { 
		assert request !=null; 
		return true;  
	} 
 
	@Override 
	public void bind(final Request<Item> request, final Item entity, final Errors errors) { 
		assert request != null; 
		assert entity != null; 
		assert errors != null; 
 
		request.bind(entity, errors, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink"); 
		 
	} 
 
	@Override 
	public void unbind(final Request<Item> request, final Item entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
 
		request.unbind(entity, model, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink", "inventor.userAccount.username", "published"); 
		 
	} 
	@Override
	public Item instantiate(final Request<Item> request) {
		assert request != null; 
		Item result; 
		Inventor inventor; 
		 
		inventor=this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId()); 
		result= new Item(); 
		result.setPublished(false); 
		result.setInventor(inventor); 
		return result; 
	}
	
	public boolean validateCurrencyRetailPrice(final Money retailPrice) {
		final boolean acceptedCurrency;
		
		final String currencies = this.repository.findAcceptedCurrencies().replace(" ", "");
		final List<Object> listCurrencies = Arrays.asList(currencies.split(","));
		acceptedCurrency = listCurrencies.contains(retailPrice.getCurrency());
		
		return acceptedCurrency;
		
		
		
	}
 
	@Override 
	public void validate(final Request<Item> request, final Item entity, final Errors errors) { 
		assert request != null; 
		assert entity != null; 
		assert errors != null; 
		
		final Money retailPrice = entity.getRetailPrice();
		
		if (!errors.hasErrors("code")) {
			Item existing;

			existing = this.repository.findOneItemByCode(entity.getCode());
			errors.state(request, existing == null, "code", "inventor.item.form.error.duplicated");
		}
		
		if(!errors.hasErrors("retailPrice")){
			
			final boolean acceptedCurrency = this.validateCurrencyRetailPrice(retailPrice);
			errors.state(request, acceptedCurrency, "retailPrice", "inventor.item.form.error.retail-price-currency-not-accepted");
			
			if(entity.getTipo().equals(TipoDeItem.COMPONENT)) {
				
				final boolean retailPriceComponentPositive = retailPrice.getAmount() > 0.;
				errors.state(request, retailPriceComponentPositive, "retailPrice", "inventor.item.form.error.retail-price-component-positive");
				
			} else if(entity.getTipo().equals(TipoDeItem.TOOL)) {
				final boolean retailPriceToolZeroOrPositive = retailPrice.getAmount() >= 0.;
				errors.state(request, retailPriceToolZeroOrPositive, "retailPrice", "inventor.item.form.error.retail-price-tool-zero-or-positive");
				
			} 
			
		}
		
	} 
 
	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null; 
		assert entity != null; 
		
		 
		entity.setInventor(this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId())); 
		entity.setPublished(false); 
		this.repository.save(entity); 
		 
		
	}


}