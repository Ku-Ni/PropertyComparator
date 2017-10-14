/**
 * 
 */
package co.uk.coenie.property_comparator.service;

import java.util.List;

import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

/**
 * @author Coenie
 *
 */
public interface PriceComparisonService {
	
	/**
	 * Takes postcode or outward postcode and finds the average
	 * price for matching properties
	 * 
	 * @param postcode - Full postcode or outward postcode
	 * @return average price for matched properties
	 */
	AveragePrice findAveragePriceByPostcode(String postcode);	
	
	/**
	 * Takes two different PropertyTypes and returns the difference
	 * in average prices for the two
	 * 
	 * @param propertyType1
	 * @param propertyType2
	 * @return Difference in average price for propertyType1 and propertyType2
	 */
	AveragePriceDifference findAveragePriceDifferenceByPropertyType(PropertyType propertyType1, PropertyType propertyType2);
	
	/**
	 * Retrieves the top percentage of properties ordered by descending price value
	 * Properties outside the percentage valued the same as properties inside, will
	 * be included in the result.
	 * 
	 * @param percent - double amount for percentage to select e.g. 10.8%
	 * @return PropertyListings falling inside the bracket
	 */
	List<PropertyListing> findMostExpensivePropertiesByPercentage(double percent);
}
