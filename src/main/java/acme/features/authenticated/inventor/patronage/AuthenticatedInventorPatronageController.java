package acme.features.authenticated.inventor.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Patronage;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated; 
 
@Controller 
public class AuthenticatedInventorPatronageController extends AbstractController<Authenticated, Patronage> { 
	//Internal State 
	 
	@Autowired 
	protected AuthenticatedInventorPatronageListService listRecentService; 
	@Autowired 
	protected AuthenticatedInventorPatronageShowService showService; 
	 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
	} 
 
} 
