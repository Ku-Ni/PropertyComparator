package co.uk.coenie.property_comparator.model;

public class PropertyListing {
	private int propertyReference;
	private int price;
	private int bedrooms;
	private int bathrooms;
	private String houseNumber;
	private String address;
	private String region;
	private String postcode;
	private PropertyListingType propertyType;
	
	
	public int getPropertyReference() {
		return propertyReference;
	}
	public void setPropertyReference(int propertyReference) {
		this.propertyReference = propertyReference;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public PropertyListingType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyListingType propertyType) {
		this.propertyType = propertyType;
	}
	
}
