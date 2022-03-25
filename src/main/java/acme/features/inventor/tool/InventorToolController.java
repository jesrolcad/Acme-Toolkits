package acme.features.inventor.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolController extends AbstractController<Inventor, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorToolListAllService		listAllService;

		@Autowired
		protected InventorToolShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.listAllService);
			super.addCommand("show", this.showService);
		}

}
