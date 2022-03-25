package acme.features.authenticated.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedToolController extends AbstractController<Authenticated, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AuthenticatedToolListAllService		listAllService;

		@Autowired
		protected AuthenticatedToolShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.listAllService);
			super.addCommand("show", this.showService);
		}

}
