package co.uk.coenie.property_comparator.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.coenie.property_comparator.dao.PropertyListingDao;
import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

@Service
public class PriceComparisonServiceImpl implements PriceComparisonService{

	private PropertyListingDao dao;

	@Autowired
	public PriceComparisonServiceImpl(PropertyListingDao dao){
		this.dao = dao;
	}


	@Override
	public AveragePrice findAveragePriceByPostcode(String postcode) {
		double averagePrice = dao.selectAveragePriceByPostcode(postcode);

		return new AveragePrice().setPostcode(postcode).setAveragePrice(averagePrice);
	}


	@Override
	public AveragePriceDifference findAveragePriceDifferenceByPropertyType(PropertyType propertyType1,
			PropertyType propertyType2) {

		double averagePrice1 = dao.selectAveragePriceByPropertyType(propertyType1);
		double averagePrice2 = dao.selectAveragePriceByPropertyType(propertyType2);
		double difference = Math.abs(averagePrice1-averagePrice2);

		AveragePriceDifference response = new AveragePriceDifference();
		response.addPropertyType(propertyType1, averagePrice1);
		response.addPropertyType(propertyType2, averagePrice2);
		response.setPriceDifference(difference);

		return response;
	}


	@Override
	public List<PropertyListing> findMostExpensivePropertiesByPercentage(double percent) {
		List<PropertyListing> allListings = dao.selectAllProperties();

		// sort allListings by price and take a substring for percentage
		allListings.sort(Comparator.comparing(PropertyListing::getPrice).reversed());
		int numListings = (int) (allListings.size()*(percent/100));
		List<PropertyListing> result = new ArrayList<>(allListings.subList(0, numListings));

		// Add listings where the listing price falls within the top percentage selected
		if (result.size()>0 && result.size()<allListings.size())
			while (result.get(numListings-1).getPrice()==allListings.get(numListings).getPrice()){
				result.add(allListings.get(numListings));
				numListings++;
			}
		
		return result;
	}

}
