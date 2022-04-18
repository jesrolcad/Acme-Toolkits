package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor,Toolkit> {

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		boolean res=false;
		int id;
		int inventorId;
		int userId;
		id=request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(id);
		inventorId = toolkit.getInventor().getId();
		userId= request.getPrincipal().getAccountId();
		final Inventor invent=this.repository.findInventorByUserAccountId(userId);
		final int inventorIdUser=invent.getId();
		
		if(inventorId == inventorIdUser) {
			res=true;
		}

		
		return res;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		Double retailPrice;
		int id;

		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		retailPrice = this.repository.retailPriceOfToolkitById(id);
		result.setRetailPrice(retailPrice);
//		
//		SystemConfiguration configuracion;
//		configuracion=this.repository.findSystemConfiguration().stream().findFirst().get();
//		String acceptedCurrencies= configuracion.getAcceptedCurrencies();
//		String systemcurrency=configuracion.getSystemCurrency();
		
		
		
		
		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", 
			"description","assemblyNotes", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

}
