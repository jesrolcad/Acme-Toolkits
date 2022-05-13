package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron; 
 
@Controller 
public class PatronPatronageController extends AbstractController<Patron, Patronage> { 
	//Internal State 
	 
	@Autowired 
	protected PatronPatronageListService listRecentService; 
	@Autowired 
	protected PatronPatronageShowService showService; 
	@Autowired 
	protected PatronPatronageCreateService createService; 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
		super.addCommand("create", this.createService); 

	} 
 
} 
