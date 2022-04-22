package acme.features.patron.patronagereport;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron; 
 
@Controller 
public class PatronPatronageReportController extends AbstractController<Patron, PatronageReport> { 
	//Internal State 
	 
	@Autowired 
	protected PatronPatronageReportListService listRecentService; 
	@Autowired 
	protected PatronPatronageReportShowService showService; 
	 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
	} 
 
} 
