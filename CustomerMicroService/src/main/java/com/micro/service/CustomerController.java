package com.micro.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CruiseRepository cruiseRepo;
	
	private Customer customer;
	private int customerID;

	@GetMapping("/")
	public String home() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		Date dat1=cal.getTime();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		Date dat2=cal.getTime();
		
		Cruise cr1 = new Cruise(1234,"Pindi Express",dat1,6,200.4f);
		Cruise cr2 = new Cruise(4321,"Lahore Express",dat2,7,350);
		
		List<Cruise> cruiseList = new ArrayList<Cruise>();
		cruiseList.add(cr2);
		cruiseList.add(cr1);
		
		cruiseRepo.saveAll(cruiseList);
		
		return "home";
	}

	@PostMapping("/register")
	public ModelAndView register(@RequestParam("custId") int custId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("address") String address,
			@RequestParam("city") String city, @RequestParam("country") String country,
			@RequestParam("phone") float phone, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		customerID = custId;
		
		customer = new Customer();
		customer.setCustId(customerID);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setCountry(country);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setPassword(password);

		customerRepo.save(customer);
		return new ModelAndView("dashboard", "customer", customer);

	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
		List<Customer> customers = customerRepo.findAll();
		customer = null;
		for (Customer c : customers) {
			String mail = c.getEmail();
			String pass = c.getPassword();
			if (mail.equals(email) && pass.equals(password))
				customer = c;
		}
			
		if (customer == null)
			return new ModelAndView("error");
		else 		
			return new ModelAndView("dashboard", "customer", customer);
	}
	
	@PostMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("customer",customer);
		return "profile";
	}
	
	@PostMapping("/edit")
	public String edit(Model model) {
		model.addAttribute("customer", customer);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("custid") int custId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("address") String address,
			@RequestParam("city") String city,
			@RequestParam("country") String country,
			@RequestParam("phone") float phone,
			@RequestParam("email") String email) {
		customer.setCustId(custId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setCountry(country);
		customer.setPhone(phone);
		customer.setEmail(email);
		
		customerRepo.save(customer);
		
		return "profile";
	}
	
	@PostMapping("/history")
	public String history(Model model) {
		model.addAttribute("bookings", bookingRepo.findAll());
		return "history";
	}
	
	@PostMapping("/book")
	public String booking(Model model) {
		model.addAttribute("cruises", cruiseRepo.findAll());
		model.addAttribute("customer", customer);
		return "booking";
	}
	
	@PostMapping("/booked")
	public @ResponseBody String booked(@RequestParam("custId") int custID,
			@RequestParam("cruiseId") int cruiseId,
			@RequestParam("price") float price,
			@RequestParam("numberOfGuests") int numberOfGuests) {
		Booking booking = new Booking();
		booking.setCruiseId(cruiseId);
		booking.setCustId(custID);
		booking.setNumberOfGuests(numberOfGuests);
		booking.setTotalAmount(numberOfGuests*price);
		booking.setStatus("Reserved");
		
		bookingRepo.save(booking);
		
		return "booking successful";
	}

}
