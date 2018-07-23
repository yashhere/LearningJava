package main.java.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.api.CustomerData;
import main.java.api.CustomerTemplate;

@Path("statistics")
public class Statistics {

	@Path("/getCustomerList")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerTemplate> getCustomerList() {
		List<CustomerTemplate> listOfCustomers = new ArrayList<>();
		try {
			CustomerData customerData = new CustomerData();
			if (customerData.getCustomerData().size() != 0)
				return customerData.getCustomerData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOfCustomers;
	}
}
