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

	@Path("/getStatisticOnOrderProduct")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductTemplate> getStatisticOnOrderProduct() {
		List<ProductTemplate> productsList = new ArrayList<>();
		try {
			List<CustomerOrder> orders = CustomerOrdersList.customerOrders;

			ProductData productData = new ProductData();
			List<ProductTemplate> products = productData.getProducts();

			int productQuantities[];
			productQuantities = new int[products.size()];

			for (int i = 0; i < products.size(); i++) {
				productQuantities[i] = 0;
			}

			for (CustomerOrder customerOrder : orders) {
				for (Order order : customerOrder.getOrders()) {
					for (ProductTemplate product : products) {
						if (product.getProductId() == order.getProductId()) {
							productQuantities[product.getProductId() - 1] += order.getProductQuantity();
						}
					}
				}
			}

			for (int i=0;i<productQuantities.length;i++) {
				System.out.println(productQuantities[i]);
			}
			
			for (ProductTemplate product : products) {
				product.setProductQuantity(productQuantities[product.getProductId() - 1]);
//				System.out.println(product.getProductQuantity(productQuantities[product.getProductId()-1]));
				productsList.add(product);
			}
			return productsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productsList;
	}
}
