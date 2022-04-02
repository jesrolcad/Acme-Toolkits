package acme.features.authenticated.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Patronage;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated; 
 
@Controller 
public class AuthenticatedPatronPatronageController extends AbstractController<Authenticated, Patronage> { 
	//Internal State 
	 
	@Autowired 
	protected AuthenticatedPatronPatronageListService listRecentService; 
	@Autowired 
	protected AuthenticatedPatronPatronageShowService showService; 
	 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
	} 
 
} 
