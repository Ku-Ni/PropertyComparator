package co.uk.coenie.property_comparator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;
import co.uk.coenie.property_comparator.service.PriceComparisonService;

@Controller
public class PropertyComparatorController {

	private PriceComparisonService priceComparisonService;

	@Autowired
	public PropertyComparatorController(PriceComparisonService priceComparisonService){
		this.priceComparisonService = priceComparisonService;
	}

	@RequestMapping(value="/average-price/postcode",method=RequestMethod.GET)
	public @ResponseBody AveragePrice findAveragePriceByPostcode(
			@RequestParam(value="postcode", required=true) String postcode) {
		return priceComparisonService.findAveragePriceByPostcode(postcode);
	}

	@RequestMapping(value="/average-price-difference/property-types",method=RequestMethod.GET)
	public @ResponseBody AveragePriceDifference findAveragePriceByPropertyType(
			@RequestParam(value="property-type1", required=true) String propertyType1, 
			@RequestParam(value="property-type2", required=true) String propertyType2) {
		return priceComparisonService.findAveragePriceDifferenceByPropertyType(PropertyType.valueOf(propertyType1), PropertyType.valueOf(propertyType2));
	}

	@RequestMapping(value="/average-price-difference/property-types",method=RequestMethod.GET)
	public @ResponseBody List<PropertyListing> findMostExpensivePropertiesByPercentage(
			@RequestParam(value="percentage", required=true) double percentage) {
		return priceComparisonService.findMostExpensivePropertiesByPercentage(percentage);
	}

}
