package main.java.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class CustomerDeliveryInformation {
	@JsonProperty("customerId")
	private int customerId;

	@JsonProperty("mobileNumber")
	private int mobileNumber;

	@JsonProperty("deliveryAddress")
	private String deliveryAddress;

	@JsonProperty("pincode")
	private int pincode;

	@JsonProperty("email")
	private String email;

	@JsonProperty("orders")
	public List<OrderFromJson> orderFromJsons = null;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("couponCode")
	private String couponCode;

	@JsonProperty("customerId")
	public int getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("mobileNumber")
	public int getMobileNumber() {
		return mobileNumber;
	}

	@JsonProperty("mobileNumber")
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonProperty("deliveryAddress")
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	@JsonProperty("deliveryAddress")
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@JsonProperty("pincode")
	public int getPincode() {
		return pincode;
	}

	@JsonProperty("pincode")
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("orders")
	public List<OrderFromJson> getOrders() {
		return orderFromJsons;
	}

	@JsonProperty("orders")
	public void setOrders(List<OrderFromJson> orderFromJsons) {
		this.orderFromJsons = orderFromJsons;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "CustomerDeliveryInformation [customerId=" + customerId + ", mobileNumber=" + mobileNumber
				+ ", deliveryAddress=" + deliveryAddress + ", pincode=" + pincode + ", email=" + email
				+ ", orderFromJsons=" + orderFromJsons + "]";
	}

}
