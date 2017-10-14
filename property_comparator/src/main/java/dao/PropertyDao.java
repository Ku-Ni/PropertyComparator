package dao;

import java.util.List;

import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyListingType;

public interface PropertyDao {
	
	/**
	 * Returns the average price for postcodes starting with
	 * supplied value.
	 * 
	 * @param postcode
	 * @return mean average price
	 */
	double selectAveragePriceByPostcode(String postcode);
	
	/**
	 * Returns the average price for the PropertyListingType
	 * 
	 * @param propertyType
	 * @return mean average price
	 */
	double selectAveragePriceByPropertyType(PropertyListingType propertyType);
	
	/**
	 * Returns all property listings
	 * 
	 * @return
	 */
	List<PropertyListing> selectAllProperties();
	
}
