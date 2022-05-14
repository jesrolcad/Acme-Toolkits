package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.features.inventor.toolkit.InventorToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemListMineService		itemListMineService;

	@Autowired
	protected InventorItemShowService	itemShowService;
	
	@Autowired
	protected InventorToolkitItemListService toolkitItemListService;
	
	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemDeleteService deleteService;
	
	@Autowired
	protected InventorItemUpdateService updateService;
	
	@Autowired
	protected InventorItemPublishService publishService;


	@PostConstruct
	protected void initialise() {
		super.addCommand("create", this.createService); 
		super.addCommand( "list", this.itemListMineService);
		super.addCommand("show", this.itemShowService);
		super.addCommand("listToolkitItems", "list", this.toolkitItemListService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
		super.addCommand("publish", this.publishService);
		
	}
	
}
