package co.uk.coenie.property_comparator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AveragePriceDifference {
	@JsonProperty
	private List<AveragePrice> propertyTypes;
	@JsonProperty
	private double priceDifference;
	
	
	public List<AveragePrice> getPropertyTypes() {
		return propertyTypes;
	}
	public void setPropertyTypes(List<AveragePrice> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}
	
	public double getPriceDifference() {
		return priceDifference;
	}
	public void setPriceDifference(double priceDifference) {
		this.priceDifference = priceDifference;
	}
	
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AveragePriceDifference)) {
			return false;
		}
		AveragePriceDifference castOther = (AveragePriceDifference) other;
		return Objects.equals(propertyTypes, castOther.propertyTypes)
				&& Objects.equals(priceDifference, castOther.priceDifference);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(propertyTypes, priceDifference);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("propertyTypes", propertyTypes)
				.append("priceDifference", priceDifference).toString();
	}
	
		
}
