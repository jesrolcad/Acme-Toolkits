package acme.features.administrator.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorToolController extends AbstractController<Administrator, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorToolListAllService		listAllService;

		@Autowired
		protected AdministratorToolShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.listAllService);
			super.addCommand("show", this.showService);
		}

}
