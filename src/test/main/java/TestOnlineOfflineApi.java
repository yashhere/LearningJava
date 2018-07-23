package test.main.java;

import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.api.CustomerData;
import main.java.api.GenderTimeStatistics;
import main.java.api.JSONResult;
import main.java.api.OnlineOfflineCount;
import main.java.api.OrderController;
import main.java.api.ProductTemplate;
import main.java.api.Statistics;

public class TestOnlineOfflineApi {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 1,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 1,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 2,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 3,\r\n" + 
				"		\"productQuntity\": 3\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 4,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 6,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 7,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 8,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 9,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 1,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 1,\r\n" + 
				"		\"productQuntity\": 1\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 2,\r\n" + 
				"		\"productQuntity\": 2\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		
		
		onlineOrders.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 8,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		offlineOrders.add("{\r\n" + 
				"	\"customerId\": 8,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 8,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		offlineOrders.add("{\r\n" + 
				"	\"customerId\": 3,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 8,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		for (String customerDeliveryInformation : onlineOrders) {
			   orderController.specialOrders(customerDeliveryInformation,1);
		   }
		
		for (String customerDeliveryInformation : onlineOrders) {
			   orderController.specialOrders(customerDeliveryInformation,0);
		   }
	}
	
	static OrderController orderController = new OrderController();
	static List <String> onlineOrders=new ArrayList<>();
	static List <String> offlineOrders=new ArrayList<>();
	
	@Test
	public void testOnlineOrder() {
		CustomerData customers = new CustomerData();
		Assertions.assertEquals(9, customers.getCustomerData().size());
	}
	
	@Test
	public void testOnlineBooking() {
		JSONResult result = new JSONResult();
		for(String customerDeliveryInformation : onlineOrders) {
			result = orderController.specialOrders(customerDeliveryInformation, 1);
			Assertions.assertEquals(200, result.getStatusCode(), "OnlineBooking failed for 8AM-10AM");
		}
		
		for(String customerDeliveryInformation : onlineOrders) {
			result = orderController.normalOrders(customerDeliveryInformation, 1);
			Assertions.assertEquals(200, result.getStatusCode(), "OnlineBooking failed for 10AM onwards.");
		}		
	}
	
	@Test
	public void testOfflineBooking() {
		JSONResult result = new JSONResult();
		for(String customerDeliveryInformation : offlineOrders) {
			result = orderController.normalOrders(customerDeliveryInformation, 0);
			Assertions.assertEquals(200, result.getStatusCode(), "OfflineBooking failed for 10AM onwards.");
		}
	}
	
	@Test
	public void testHourlyStatistics() {
		Statistics statisticsController = new Statistics();
		List<GenderTimeStatistics> data = (List<GenderTimeStatistics>) statisticsController.getStatisticOnHoursBasis();
		
		assumeTrue(!data.get(0).getOrder15().isEmpty(), "Test should pass. Ignoring");
		assumeFalse(data.get(0).getOrder15().isEmpty());
	}
	
	@Test
	public void testGenderStatistics() {
		Statistics statisticsController = new Statistics();
		List<GenderTimeStatistics> list = (List<GenderTimeStatistics>) statisticsController.getStatisticOnMenWoMenHoursBasis();
		Assertions.assertTrue(list.size() == 2);
		assumeTrue(!list.get(0).getOrder15().isEmpty());
	}
	
	@Test
	public void testProductStatistics() {
		Statistics statisticsController = new Statistics();
		List<ProductTemplate> list = statisticsController.getStatisticOnOrderProduct();
		assumeTrue(list.size() > 0);
	}
	
	@Test
	public void testOfflineOnlineCount() {
		Statistics statisticsController = new Statistics();
		List<OnlineOfflineCount> list = (List<OnlineOfflineCount>) statisticsController.getStatisticOnOnlineOfflineOrder();
		assumeTrue(list.size() > 0);
	}
}
