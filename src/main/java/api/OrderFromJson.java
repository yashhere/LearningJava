package main.java.api;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrderFromJson {
	@JsonProperty("productId")
	private int productId;

	@JsonProperty("productQuantity")
	private int productQuantity;

	@JsonProperty("productId")
	public int getProductId() {
		return productId;
	}

	@JsonProperty("productId")
	public void setProductId(int productId) {
		this.productId = productId;
	}

	@JsonProperty("productQuantity")
	public int getProductQuantity() {
		return productQuantity;
	}

	@JsonProperty("productQuantity")
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	

}
