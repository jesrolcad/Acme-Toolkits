package acme.features.any.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemController extends AbstractController<Any, Item>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemComponentListAllService		componentListAllService;
	
	@Autowired
	protected AnyItemToolListAllService		toolListAllService;

	@Autowired
	protected AnyItemShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-all-tools", "list", this.toolListAllService);
		super.addCommand("list-all-components", "list", this.componentListAllService);
		super.addCommand("show", this.showService);
	}

}
