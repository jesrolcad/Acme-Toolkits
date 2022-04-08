package acme.features.administrator.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdministratorItemController extends AbstractController<Administrator, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorComponentListAllService		componentListAllService;
		
		@Autowired
		protected AdministratorToolListAllService		toolListAllService;

		@Autowired
		protected AdministratorItemShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list-all-tools", "list", this.toolListAllService);
			super.addCommand("list-all-components", "list", this.componentListAllService);
			super.addCommand("show", this.showService);
		}

}
