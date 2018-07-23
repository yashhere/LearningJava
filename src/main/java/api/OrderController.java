package main.java.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class OrderController {

	CustomerData customerData = new CustomerData();

	public CustomerDeliveryInformation mapStringToJson(String customDeliveryInformation) {
		ObjectMapper mapper = new ObjectMapper();
		CustomerDeliveryInformation obj = new CustomerDeliveryInformation();
		try {
			obj = mapper.readValue(customDeliveryInformation, CustomerDeliveryInformation.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.toString();
		return obj;
	}

	public boolean checkValidUser(int id1, int id2) {
		if (id1 == id2) {
			return true;
		} else {
			return false;
		}
	}

	public JSONResult specialOrders(String customerDeliveryInformation, int typeOfOrder) {
		JSONResult result = new JSONResult();
		CustomerDeliveryInformation details = this.mapStringToJson(customerDeliveryInformation);

		List<CustomerTemplate> customers = customerData.getCustomerData();
		boolean validUser = false;
		for (CustomerTemplate customer : customers) {
			if (checkValidUser(details.getCustomerId(), customer.getCustomerId())) {
				validUser = true;
				break;
			}
		}
		
		CustomerOrder addOrder = new CustomerOrder();
		if (validUser == true) {
			if (details.getCouponCode() != null) {
				if (!(details.getCouponCode().equals("coupon code"))) {
					result.setStatusCode(HttpStatus.SC_UNAUTHORIZED);
					result.setMessage("Invalid coupon code.\n");
					return result;
				}
			}
			
			addOrder.setCustomerAddress(details.getDeliveryAddress());
			addOrder.setCustomerId(details.getCustomerId());
			addOrder.setMobileNo(details.getMobileNumber());
			addOrder.setEmail(details.getEmail());
			addOrder.setOrderId(CustomerOrdersList.customerOrders.size() + 1);
			addOrder.setOrderType(typeOfOrder);
			addOrder.setPincode(details.getPincode());
			addOrder.setOrderTime(new Date());
			List<Order> orders = new ArrayList<>();
			for (OrderFromJson order : details.getOrders()) {
				Order obj = new Order();
				obj.setProductId(order.getProductId());
				obj.setProductQuantity(order.getProductQuantity());
				orders.add(obj);
			}
			addOrder.setOrders(orders);
			CustomerOrdersList.addCustomerOrder(addOrder);

		} else {
			result.setStatusCode(HttpStatus.SC_UNAUTHORIZED);
			result.setMessage("Invalid coupon code.\n");
			return result;
		}

		result.setStatusCode(HttpStatus.SC_OK);
		result.setMessage("OrderID : " + addOrder.getOrderId());
		return result;
	}

	public JSONResult normalOrders(String customerDeliveryInformation, int typeOfOrder) {
		JSONResult result = new JSONResult();
		CustomerDeliveryInformation details = this.mapStringToJson(customerDeliveryInformation);

		List<CustomerTemplate> customers = customerData.getCustomerData();
		boolean validUser = false;
		for (CustomerTemplate customer : customers) {
			if (checkValidUser(details.getCustomerId(), customer.getCustomerId())) {
				validUser = true;
				break;
			}
		}
		
		CustomerOrder addOrder = new CustomerOrder();
		if (validUser == true) {
			if (details.getCouponCode() != null) {
				if (details.getCouponCode().equals("coupon code")) {
					result.setStatusCode(HttpStatus.SC_UNAUTHORIZED);
					result.setMessage("Invalid coupon code.\n");
					return result;
				}
			}
			
			addOrder.setCustomerAddress(details.getDeliveryAddress());
			addOrder.setCustomerId(details.getCustomerId());
			addOrder.setMobileNo(details.getMobileNumber());
			addOrder.setEmail(details.getEmail());
			addOrder.setOrderId(CustomerOrdersList.customerOrders.size() + 1);
			addOrder.setOrderType(typeOfOrder);
			addOrder.setPincode(details.getPincode());
			addOrder.setOrderTime(new Date());
			List<Order> orders = new ArrayList<>();
			for (OrderFromJson order : details.getOrders()) {
				Order obj = new Order();
				obj.setProductId(order.getProductId());
				obj.setProductQuantity(order.getProductQuantity());
				orders.add(obj);
			}
			addOrder.setOrders(orders);
			CustomerOrdersList.addCustomerOrder(addOrder);

		} else {
			result.setStatusCode(HttpStatus.SC_UNAUTHORIZED);
			result.setMessage("Invalid coupon code.\n");
			return result;
		}

		result.setStatusCode(HttpStatus.SC_OK);
		result.setMessage("OrderID : " + addOrder.getOrderId());
		return result;
	}
}
