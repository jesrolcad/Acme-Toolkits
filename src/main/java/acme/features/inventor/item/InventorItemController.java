package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.features.inventor.toolkit.ToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolListMineService		toolListMineService;

	@Autowired
	protected InventorComponentListMineService	componentListMineService;
	
	//Este es de la funcionalidad de poder acceder a una lista de items desde un toolkit
	@Autowired
	protected ToolkitItemListService		toolkitItemListService;

		@Autowired
		protected InventorItemShowService	showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("listTools", "list", this.toolListMineService);
			super.addCommand("listComponents", "list", this.componentListMineService);
			super.addCommand("show", this.showService);
			
			
			//Este es de la funcionalidad de poder acceder a una lista de items desde un toolkit
			super.addCommand("listToolkitItems", "list", this.toolkitItemListService);
		}

}
