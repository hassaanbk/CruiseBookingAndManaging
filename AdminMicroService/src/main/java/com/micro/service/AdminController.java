package com.micro.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class AdminController {

	@Autowired
	private CruiseService cruiseService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	private String home() {
		return "home";
	}

	@PostMapping("/login")
	private @ResponseBody String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		List<Employee> employees = (List<Employee>) employeeService.getAll();

		for (Employee e : employees) {

			String user = e.getUsername();
			String pass = e.getPassword();
			if (user.equals(username) && pass.equals(password))
				return "dashboard";
		}

		return "error";
	}

	@PostMapping("/register")
	private String register(@RequestParam("empId") int empId, @RequestParam("empName") String empName,
			@RequestParam("username") String username, @RequestParam("password") String password) {
		employeeService.save(new Employee(empId, empName, username, password));
		return "dashboard";
	}

	@PostMapping("/add")
	private String add() {
		return "add";
	}

	@PostMapping("/addCruise")
	private String addCruise(@RequestParam("cruiseId") int cruiseId,
			@RequestParam("cruiseDestination") String cruiseDestination, @RequestParam("cruiseLine") String cruiseLine,
			@RequestParam("departureDate") Date departureDate, @RequestParam("vistingPlaces") String visitingPlaces,
			@RequestParam("duration") int duration, @RequestParam("price") float price) {

		cruiseService.save(
				new Cruise(cruiseId, cruiseDestination, cruiseLine, departureDate, visitingPlaces, duration, price));

		return "dashboard";
		
	}
	
	@PostMapping("/view")
	private String view(Model model) {
		model.addAttribute("cruises",cruiseService.getAll());
		return "view";
	}
	
	@PostMapping("/update")
	private String edit(@RequestParam("cruiseId") int cruiseId,
			@RequestParam("cruiseDestination") String cruiseDestination, @RequestParam("cruiseLine") String cruiseLine,
			@RequestParam("departureDate") Date departureDate, @RequestParam("vistingPlaces") String visitingPlaces,
			@RequestParam("duration") int duration, @RequestParam("price") float price) {
		cruiseService.save(
				new Cruise(cruiseId, cruiseDestination, cruiseLine, departureDate, visitingPlaces, duration, price));

		return "view";
	}
	@PostMapping("/delete")
	private String delete(@RequestParam("cruiseId") int cruiseId) {
		cruiseService.delete(cruiseId);

		return "view";
	}

}
