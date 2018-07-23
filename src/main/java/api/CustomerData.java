package main.java.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import main.java.api.CustomerTemplate;

public class CustomerData {
	private List<CustomerTemplate> customerData = new ArrayList<>();

	public CustomerData() {
		Calendar cal = Calendar.getInstance();

		CustomerTemplate customer = new CustomerTemplate();
		customer.setCustomerId(1);
		customer.setName("Jan Koum");
		customer.setAddress("Mumbai Boriwali");
		cal.set(1985, 1, 8); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(2);
		customer.setName("Tony Bates");
		customer.setAddress("Mumbai dombiwali");
		cal.set(1978, 05, 12); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(3);
		customer.setName("Marissa Mayer");
		customer.setAddress("Navi Mumbai");
		cal.set(1978, 03, 04); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(4);
		customer.setName("Jeff Weiner");
		customer.setAddress("pune");
		cal.set(1978, 107, 29); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(5);
		customer.setName("Sundar Pichai");
		customer.setAddress("nagpur");
		cal.set(1978, 06, 06); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(6);
		customer.setName("Mark Zuckerberg");
		customer.setAddress("kolhapur");
		cal.set(1978, 01, 30); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("M");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(7);
		customer.setName("Roshani");
		customer.setAddress("kolhapur");
		cal.set(2000, 01, 30); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("F");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(7);
		customer.setName("Pooja");
		customer.setAddress("kolhapur");
		cal.set(2000, 01, 30); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("F");
		this.customerData.add(customer);

		customer = new CustomerTemplate();
		customer.setCustomerId(7);
		customer.setName("Sanjna");
		customer.setAddress("kolhapur");
		cal.set(1994, 01, 30); // Assumes MM/dd/yyyy
		customer.setDob(cal.getTime());
		customer.setGender("F");
		this.customerData.add(customer);
	}

	public List<CustomerTemplate> getCustomerData() {
		return this.customerData;
	}
	
	public void addCustomerData(CustomerTemplate customer) {
		this.customerData.add(customer);
	}
}
