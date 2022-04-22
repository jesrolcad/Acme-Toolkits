package acme.features.any.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.features.any.toolkit.AnyToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemController extends AbstractController<Any, Item>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemListPublishedService		itemListPublishedService;
	

	@Autowired
	protected AnyItemShowService	showService;
	
	
	@Autowired
	protected AnyToolkitItemListService toolkitItemListService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.itemListPublishedService);
		super.addCommand("listToolkitItems", "list", this.toolkitItemListService);
		super.addCommand("show", this.showService);
	}

}
