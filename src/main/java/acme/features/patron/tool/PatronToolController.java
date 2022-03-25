package acme.features.patron.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronToolController extends AbstractController<Patron, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronToolListAllService		listAllService;

		@Autowired
		protected PatronToolShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.listAllService);
			super.addCommand("show", this.showService);
		}

}
