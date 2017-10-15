package co.uk.coenie.property_comparator.dao;

import java.util.List;

import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

public interface PropertyListingDao {
	
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
	double selectAveragePriceByPropertyType(PropertyType propertyType);
	
	/**
	 * Returns all property listings
	 * 
	 * @return
	 */
	List<PropertyListing> selectAllProperties();
	
}
