package co.uk.coenie.property_comparator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.uk.coenie.property_comparator.config.SpringTestConfig;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;
import co.uk.coenie.property_comparator.service.PriceComparisonService;

public class TestQuestions {

	AnnotationConfigApplicationContext context;
	PriceComparisonService service;
	
	@Before
	public void setUp(){
		context = new AnnotationConfigApplicationContext(SpringTestConfig.class);
		service = context.getBean(PriceComparisonService.class);
	}
	
	@Test
	// Find the mean price in the postcode outward �W1F�?
	public void findMeanPriceOutwardPostcode(){
		double expected = 1158750;
		double actual = service.findAveragePriceByPostcode("W1F").getAveragePrice();
		
		assertEquals(expected,actual,0.0);
	}

	@Test
	// Find the difference in average property prices between detached houses and flats?
	public void findAverageDifferenceByPropretyType(){
		double expected = 43420.625;
		double actual = service.findAveragePriceDifferenceByPropertyType(PropertyType.DETACHED, PropertyType.FLAT).getPriceDifference();
		
		assertEquals(expected,actual, 0.0);
	}

	@Test
	// Find the top 10% most expensive properties
	public void findTop10PercentByPrice(){
		List<PropertyListing> expected = new ArrayList<>();
		expected.add(
				new PropertyListing()
				.setPropertyReference(12)
				.setPrice(7500000)
				.setBedrooms(11)
				.setBathrooms(4)
				.setAddress("Brighton Road")
				.setRegion("Surrey")
				.setPostcode("GU13 4DD")
				.setPropertyType(PropertyType.MANSION)
				);
		expected.add(
				new PropertyListing()
				.setPropertyReference(13)
				.setPrice(2500000)
				.setBedrooms(7)
				.setBathrooms(2)
				.setHouseNumber("1")
				.setAddress("Station Road")
				.setRegion("London")
				.setPostcode("W1F 3UT")
				.setPropertyType(PropertyType.MANSION)
				);
				
		List<PropertyListing> actual = service.findMostExpensivePropertiesByPercentage(10);

		assertEquals(expected, actual);
	}

}
