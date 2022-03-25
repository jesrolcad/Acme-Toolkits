package acme.features.anonymous.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Anonymous;

@Controller
public class AnonymousToolController extends AbstractController<Anonymous, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnonymousToolListService		listService;

		@Autowired
		protected AnonymousToolShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
		}

}
