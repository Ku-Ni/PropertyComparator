package co.uk.coenie.property_comparator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.coenie.property_comparator.dao.PropertyDao;
import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

@Service
public class PriceComparisonServiceImpl implements PriceComparisonService{

	private PropertyDao dao;
	
	@Autowired
	public PriceComparisonServiceImpl(PropertyDao dao){
		this.dao = dao;
	}
	
	@Override
	public AveragePrice findAveragePriceByPostcode(String postcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AveragePriceDifference findAveragePriceDifferenceByPropertyType(PropertyType propertyType1,
			PropertyType propertyType2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyListing> findMostExpensivePropertiesByPercentage(double percent) {
		// TODO Auto-generated method stub
		return null;
	}

}
