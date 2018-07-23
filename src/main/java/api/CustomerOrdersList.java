package main.java.api;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrdersList {
	public static List<CustomerOrder> customerOrders = new ArrayList<>();
	
	public static void addCustomerOrder(CustomerOrder order) {
		customerOrders.add(order);
	}
}
