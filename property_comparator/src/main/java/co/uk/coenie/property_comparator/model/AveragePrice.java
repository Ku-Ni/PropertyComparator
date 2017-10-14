package co.uk.coenie.property_comparator.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AveragePrice {

	@JsonProperty
	private String postcode;
	@JsonProperty
	private PropertyType propertyType;
	@JsonProperty
	private double averagePrice;
	
	
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
	public double getAveragePrice() {
		return averagePrice;
	}
	
	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}
	
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AveragePrice))
			return false;
		AveragePrice castOther = (AveragePrice) other;
		return Objects.equals(postcode, castOther.postcode) && Objects.equals(propertyType, castOther.propertyType)
				&& Objects.equals(averagePrice, castOther.averagePrice);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(postcode, propertyType, averagePrice);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("postcode", postcode)
				.append("propertyType", propertyType).append("averagePrice", averagePrice).toString();
	}
	
}
