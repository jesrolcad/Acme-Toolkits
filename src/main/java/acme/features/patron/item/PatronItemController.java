package acme.features.patron.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronItemController extends AbstractController<Patron, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronComponentListAllService		componentListAllService;
		
		@Autowired
		protected PatronToolListAllService		toolListAllService;

		@Autowired
		protected PatronItemShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.toolListAllService);
			super.addCommand("list-all-components", "list", this.componentListAllService);
			super.addCommand("show", this.showService);
		}

}
