package acme.features.patronage.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.forms.PatronageDashboard;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
@RequestMapping("/administrator/dashboard/")
public class PatronageDashboardController extends AbstractController<Administrator, PatronageDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronageDashboardShowService showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);

	}

}