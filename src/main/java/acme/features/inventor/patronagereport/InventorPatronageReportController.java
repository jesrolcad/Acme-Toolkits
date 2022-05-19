package acme.features.inventor.patronagereport;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor; 
 
@Controller 
public class InventorPatronageReportController extends AbstractController<Inventor, PatronageReport> { 
	//Internal State 
	 
	@Autowired 
	protected InventorPatronageReportListService listRecentService; 
	@Autowired 
	protected InventorPatronageReportShowService showService; 
	 
	@Autowired 
	protected InventorPatronageReportCreateService createService; 
	 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
		super.addCommand("create", this.createService); 

	} 
 
} 
