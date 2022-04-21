package acme.features.any.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyToolkitController extends AbstractController<Any, Toolkit>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitListPublishedService		toolkitListPublishedService;

	@Autowired
	protected AnyToolkitShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", "list", this.toolkitListPublishedService);
		super.addCommand("show", this.showService);
	}

}
