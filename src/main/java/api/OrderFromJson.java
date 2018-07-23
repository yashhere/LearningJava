package main.java.api;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrderFromJson {
	@JsonProperty("productId")
	private int productId;

	@JsonProperty("productQuntity")
	private int productQuntity;

	@JsonProperty("productId")
	public int getProductId() {
		return productId;
	}

	@JsonProperty("productId")
	public void setProductId(int productId) {
		this.productId = productId;
	}

	@JsonProperty("productQuntity")
	public int getProductQuantity() {
		return productQuntity;
	}

	@JsonProperty("productQuntity")
	public void setProductQuantity(int productQuntity) {
		this.productQuntity = productQuntity;
	}
	
	

}
