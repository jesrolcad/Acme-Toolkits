package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorComponentListAllService		componentListAllService;
		
		@Autowired
		protected InventorToolListAllService		toolListAllService;

		@Autowired
		protected InventorItemShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.toolListAllService);
			super.addCommand("list-all-components", "list", this.componentListAllService);
			super.addCommand("show", this.showService);
		}

}
