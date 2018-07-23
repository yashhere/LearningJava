package main.java.api;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;

@Path("Order")
public class OnlineOrder {
	
	@Path("/test")
	@Produces("application/json")
	@POST
	public JSONResult test() {
		JSONResult result = new JSONResult();
		result.setStatusCode(HttpStatus.SC_FORBIDDEN);
		result.setMessage("Offline orders are not available between 8 AM to 10 AM.");	
		return result;
	}
	
	@Path("/Online")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public JSONResult getOrderOnline(@FormParam("CustomerDeliveryInformation") String customerDeliveryInformation) {
		JSONResult result = new JSONResult();
//		OrderController orderController = new OrderController();
//		int hour_now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//		System.out.println("Current time in online: " + hour_now);
//		try {
//			if(!(hour_now >= 8 && hour_now <= 10)) {
//				result = orderController.specialOrders(customerDeliveryInformation, 1);
//			}
//			else {
//				result = orderController.normalOrders(customerDeliveryInformation, 1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		result.setStatusCode(HttpStatus.SC_FORBIDDEN);
		result.setMessage("In Online");	
		return result;
	}
	
	@Path("/Offline")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public JSONResult getOrderOffline(@FormParam("CustomerDeliveryInformation") String customerDeliveryInformation) {
		JSONResult result = new JSONResult();
		OrderController orderController = new OrderController();
		int hour_now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		System.out.println("Current time in offline: " + hour_now);
		try {
			if(hour_now < 8 || hour_now > 10) {
				result = orderController.normalOrders(customerDeliveryInformation, 0);
			}
			else {
				result.setStatusCode(HttpStatus.SC_FORBIDDEN);
				result.setMessage("Offline orders are not available between 8 AM to 10 AM.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
