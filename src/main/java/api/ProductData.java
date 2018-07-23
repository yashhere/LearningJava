package main.java.api;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
	List<ProductTemplate> products = new ArrayList<>();
	
	public ProductData() {
		ProductTemplate product=new ProductTemplate();
		product.setProductId(1);
		product.setProductName("Veg McMuffin");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		product=new ProductTemplate();
		product.setProductId(2);
		product.setProductName("Veg Supreme McMuffin");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		product=new ProductTemplate();
		product.setProductId(3);
		product.setProductName("McEgg");
		product.setProductPrice(50);
		product.setType(1);
		products.add(product);
		
		product=new ProductTemplate();
		product.setProductId(4);
		product.setProductName("Egg & Cheese McMuffin");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		
		product=new ProductTemplate();
		product.setProductId(5);
		product.setProductName("Sausage McMuffin");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		product=new ProductTemplate();
		product.setProductId(6);
		product.setProductName("Sausage McMuffin with Egg");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		
		product=new ProductTemplate();
		product.setProductId(7);
		product.setProductName("McAloo Tikki");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		
		product=new ProductTemplate();
		product.setProductId(8);
		product.setProductName("McVeggie");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
		
		product=new ProductTemplate();
		product.setProductId(9);
		product.setProductName("McSpicy Paneer");
		product.setProductPrice(50);
		product.setType(0);
		products.add(product);
	}
	
	public List<ProductTemplate> getProducts() {
		return this.products;
	}
}
