package co.uk.coenie.property_comparator.model;

import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PropertyListing {
	private int propertyReference;
	private int price;
	private int bedrooms;
	private int bathrooms;
	private String houseNumber;
	private String address;
	private String region;
	private String postcode;
	private PropertyType propertyType;
	
	
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
	public PropertyType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PropertyListing)) {
			return false;
		}
		PropertyListing castOther = (PropertyListing) other;
		return Objects.equals(propertyReference, castOther.propertyReference) && Objects.equals(price, castOther.price)
				&& Objects.equals(bedrooms, castOther.bedrooms) && Objects.equals(bathrooms, castOther.bathrooms)
				&& Objects.equals(houseNumber, castOther.houseNumber) && Objects.equals(address, castOther.address)
				&& Objects.equals(region, castOther.region) && Objects.equals(postcode, castOther.postcode)
				&& Objects.equals(propertyType, castOther.propertyType);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(propertyReference, price, bedrooms, bathrooms, houseNumber, address, region, postcode,
				propertyType);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("propertyReference", propertyReference)
				.append("price", price).append("bedrooms", bedrooms).append("bathrooms", bathrooms)
				.append("houseNumber", houseNumber).append("address", address).append("region", region)
				.append("postcode", postcode).append("propertyType", propertyType).toString();
	}
	
	
}
