package acme.features.inventor.quantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Quantity;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorQuantityController extends AbstractController<Inventor, Quantity>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitItemListService toolkitItemListService;
	
	@Autowired
	protected InventorToolkitItemCreateService toolkitItemCreateService;
	
	@Autowired
	protected InventorToolkitItemShowService toolkitItemShowService;
	
	@Autowired
	protected InventorToolkitItemUpdateService toolkitItemUpdateService;
				
	@Autowired
	protected InventorToolkitItemDeleteService toolkitItemDeleteService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.toolkitItemListService);
		super.addCommand("create", this.toolkitItemCreateService);
		super.addCommand("show", this.toolkitItemShowService);
		super.addCommand("update", this.toolkitItemUpdateService);
		super.addCommand("delete", this.toolkitItemDeleteService);
					
				}

}
