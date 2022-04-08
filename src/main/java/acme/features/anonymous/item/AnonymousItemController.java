package acme.features.anonymous.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Anonymous;

@Controller
public class AnonymousItemController extends AbstractController<Anonymous, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnonymousComponentListAllService		componentListAllService;
		
		@Autowired
		protected AnonymousToolListAllService		toolListAllService;

		@Autowired
		protected AnonymousItemShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.toolListAllService);
			super.addCommand("list-all-components", "list", this.componentListAllService);
			super.addCommand("show", this.showService);
		}

}
