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

			for (int i = 0; i < productQuantities.length; i++) {
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

	@Path("/getStatisticOnOnlineOfflineOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@POST

	public Object getStatisticOnOnlineOfflineOrder() {
		List<OnlineOfflineCount> list = new ArrayList<>();

		int online = 0, offline = 0;
		try {
			List<CustomerOrder> orders = CustomerOrdersList.customerOrders;
			for (CustomerOrder order : orders) {
				if (order.getOrderType() == 1) {
					online++;
				} else {
					offline++;
				}
			}

			OnlineOfflineCount obj = new OnlineOfflineCount();
			obj.setOffline(offline);
			obj.setOnline(online);

			list.add(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Path("/getStatisticMenWomenOnHoursBasis")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Object getStatisticOnMenWoMenHoursBasis() {
		int MaleOrderTime[];
		MaleOrderTime = new int[24];

		int FemaleOrderTime[];
		FemaleOrderTime = new int[24];

		for (int i = 0; i < 24; i++) {
			MaleOrderTime[i] = 0;
			FemaleOrderTime[i] = 0;
		}

		List<GenderTimeStatistics> list = new ArrayList<>();
		try {
			List<CustomerOrder> orders = CustomerOrdersList.customerOrders;
			CustomerData customerData = new CustomerData();
			List<CustomerTemplate> customers = customerData.getCustomerData();

			for (CustomerOrder order : orders) {
				for (CustomerTemplate customer : customers) {
					if (customer.getCustomerId() == order.getCustomerId()) {
						int time = order.getOrderTime().getHours();
						if (customer.getGender().equals("M")) {

							MaleOrderTime[time]++;
						} else {
							FemaleOrderTime[time]++;
						}
					}
				}
			}

			int totalOrders = 0;
			for (int i = 0; i < MaleOrderTime.length; i++) {
				totalOrders += MaleOrderTime[i] + FemaleOrderTime[i];
			}

			GenderTimeStatistics male = new GenderTimeStatistics();
			male.setGender("M");
			male.setOrder0(MaleOrderTime[0] * 100 / totalOrders + "%");
			male.setOrder1(MaleOrderTime[1] * 100 / totalOrders + "%");
			male.setOrder2(MaleOrderTime[2] * 100 / totalOrders + "%");
			male.setOrder3(MaleOrderTime[3] * 100 / totalOrders + "%");
			male.setOrder4(MaleOrderTime[4] * 100 / totalOrders + "%");
			male.setOrder5(MaleOrderTime[5] * 100 / totalOrders + "%");
			male.setOrder6(MaleOrderTime[6] * 100 / totalOrders + "%");
			male.setOrder7(MaleOrderTime[7] * 100 / totalOrders + "%");
			male.setOrder8(MaleOrderTime[8] * 100 / totalOrders + "%");
			male.setOrder9(MaleOrderTime[9] * 100 / totalOrders + "%");
			male.setOrder10(MaleOrderTime[10] * 100 / totalOrders + "%");
			male.setOrder11(MaleOrderTime[11] * 100 / totalOrders + "%");
			male.setOrder12(MaleOrderTime[12] * 100 / totalOrders + "%");
			male.setOrder13(MaleOrderTime[13] * 100 / totalOrders + "%");
			male.setOrder14(MaleOrderTime[14] * 100 / totalOrders + "%");
			male.setOrder15(MaleOrderTime[15] * 100 / totalOrders + "%");
			male.setOrder16(MaleOrderTime[16] * 100 / totalOrders + "%");
			male.setOrder17(MaleOrderTime[17] * 100 / totalOrders + "%");
			male.setOrder18(MaleOrderTime[18] * 100 / totalOrders + "%");
			male.setOrder19(MaleOrderTime[19] * 100 / totalOrders + "%");
			male.setOrder20(MaleOrderTime[20] * 100 / totalOrders + "%");
			male.setOrder21(MaleOrderTime[21] * 100 / totalOrders + "%");
			male.setOrder22(MaleOrderTime[22] * 100 / totalOrders + "%");
			male.setOrder23(MaleOrderTime[23] * 100 / totalOrders + "%");

			list.add(male);

			GenderTimeStatistics female = new GenderTimeStatistics();
			female.setGender("F");
			female.setOrder0(FemaleOrderTime[0] * 100 / totalOrders + "%");
			female.setOrder1(FemaleOrderTime[1] * 100 / totalOrders + "%");
			female.setOrder2(FemaleOrderTime[2] * 100 / totalOrders + "%");
			female.setOrder3(FemaleOrderTime[3] * 100 / totalOrders + "%");
			female.setOrder4(FemaleOrderTime[4] * 100 / totalOrders + "%");
			female.setOrder5(FemaleOrderTime[5] * 100 / totalOrders + "%");
			female.setOrder6(FemaleOrderTime[6] * 100 / totalOrders + "%");
			female.setOrder7(FemaleOrderTime[7] * 100 / totalOrders + "%");
			female.setOrder8(FemaleOrderTime[8] * 100 / totalOrders + "%");
			female.setOrder9(FemaleOrderTime[9] * 100 / totalOrders + "%");
			female.setOrder10(FemaleOrderTime[10] * 100 / totalOrders + "%");
			female.setOrder11(FemaleOrderTime[11] * 100 / totalOrders + "%");
			female.setOrder12(FemaleOrderTime[12] * 100 / totalOrders + "%");
			female.setOrder13(FemaleOrderTime[13] * 100 / totalOrders + "%");
			female.setOrder14(FemaleOrderTime[14] * 100 / totalOrders + "%");
			female.setOrder15(FemaleOrderTime[15] * 100 / totalOrders + "%");
			female.setOrder16(FemaleOrderTime[16] * 100 / totalOrders + "%");
			female.setOrder17(FemaleOrderTime[17] * 100 / totalOrders + "%");
			female.setOrder18(FemaleOrderTime[18] * 100 / totalOrders + "%");
			female.setOrder19(FemaleOrderTime[19] * 100 / totalOrders + "%");
			female.setOrder20(FemaleOrderTime[20] * 100 / totalOrders + "%");
			female.setOrder21(FemaleOrderTime[21] * 100 / totalOrders + "%");
			female.setOrder22(FemaleOrderTime[22] * 100 / totalOrders + "%");
			female.setOrder23(FemaleOrderTime[23] * 100 / totalOrders + "%");

			list.add(female);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Path("/getStatisticOnHoursBasis")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Object getStatisticOnHoursBasis() {
		int OrderTime[];
		OrderTime = new int[24];

		for (int i = 0; i < 24; i++) {
			OrderTime[i] = 0;
		}

		List<GenderTimeStatistics> list = new ArrayList<>();
		try {
			List<CustomerOrder> orders = CustomerOrdersList.customerOrders;
			CustomerData customerData = new CustomerData();
			List<CustomerTemplate> customers = customerData.getCustomerData();

			for (CustomerOrder order : orders) {
				for (CustomerTemplate customer : customers) {
					if (customer.getCustomerId() == order.getCustomerId()) {
						int time = order.getOrderTime().getHours();
						OrderTime[time]++;
					}
				}
			}

			int totalOrders = 0;
			for (int i = 0; i < OrderTime.length; i++) {
				totalOrders += OrderTime[i];
			}

			GenderTimeStatistics data = new GenderTimeStatistics();
			data.setGender(null);
			data.setOrder0(OrderTime[0] * 100 / totalOrders + "%");
			data.setOrder1(OrderTime[1] * 100 / totalOrders + "%");
			data.setOrder2(OrderTime[2] * 100 / totalOrders + "%");
			data.setOrder3(OrderTime[3] * 100 / totalOrders + "%");
			data.setOrder4(OrderTime[4] * 100 / totalOrders + "%");
			data.setOrder5(OrderTime[5] * 100 / totalOrders + "%");
			data.setOrder6(OrderTime[6] * 100 / totalOrders + "%");
			data.setOrder7(OrderTime[7] * 100 / totalOrders + "%");
			data.setOrder8(OrderTime[8] * 100 / totalOrders + "%");
			data.setOrder9(OrderTime[9] * 100 / totalOrders + "%");
			data.setOrder10(OrderTime[10] * 100 / totalOrders + "%");
			data.setOrder11(OrderTime[11] * 100 / totalOrders + "%");
			data.setOrder12(OrderTime[12] * 100 / totalOrders + "%");
			data.setOrder13(OrderTime[13] * 100 / totalOrders + "%");
			data.setOrder14(OrderTime[14] * 100 / totalOrders + "%");
			data.setOrder15(OrderTime[15] * 100 / totalOrders + "%");
			data.setOrder16(OrderTime[16] * 100 / totalOrders + "%");
			data.setOrder17(OrderTime[17] * 100 / totalOrders + "%");
			data.setOrder18(OrderTime[18] * 100 / totalOrders + "%");
			data.setOrder19(OrderTime[19] * 100 / totalOrders + "%");
			data.setOrder20(OrderTime[20] * 100 / totalOrders + "%");
			data.setOrder21(OrderTime[21] * 100 / totalOrders + "%");
			data.setOrder22(OrderTime[22] * 100 / totalOrders + "%");
			data.setOrder23(OrderTime[23] * 100 / totalOrders + "%");

			list.add(data);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
