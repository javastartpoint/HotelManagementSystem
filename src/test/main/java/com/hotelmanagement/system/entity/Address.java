package com.hotelmanagement.system.entity;
/**
 * @author Premala
 */
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Embeddable
@Table(name="address")
public class Address {
	@NotBlank(message="Address lines are required!!")
	@Column(name="address_lines") 
	private String addressLines;
	
	@Column(name="street_name")
	private String streetName;
	
	@NotBlank(message="City name is required..")
	private String city;
	
	@NotBlank(message="State name is required..")
	private String state;
	
	@NotBlank(message="Country name is required..")
	private String country;
	
	@NotNull(message="pinCode is required..")
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$",message="invalid pinCode")
	private long pinCode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Address(@NotBlank(message = "Address lines are required!!") String addressLines, String streetName,
			@NotBlank(message = "City name is required..") String city,
			@NotBlank(message = "State name is required..") String state,
			@NotBlank(message = "Country name is required..") String country,
			@NotNull(message = "pinCode is required..") @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$", message = "invalid pinCode") long pinCode) {
		super();
		this.addressLines = addressLines;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}



	public String getAddressLines() {
		return addressLines;
	}



	public void setAddressLines(String addressLines) {
		this.addressLines = addressLines;
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public long getPinCode() {
		return pinCode;
	}



	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}



	@Override
	public String toString() {
		return "Address [addressLines=" + addressLines + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}



	
	
}
