package co.uk.coenie.property_comparator.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import co.uk.coenie.property_comparator.dao.PropertyDao;
import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

public class PriceComparisonServiceImplTest {
	
	@Mock PropertyDao mockDao;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	
	PriceComparisonServiceImpl service;

	@Before
	public void setUp() throws Exception {
		service = new PriceComparisonServiceImpl(mockDao);
		
		List<PropertyListing> mockListings = setupMockListings();
		
		when(mockDao.selectAveragePriceByPostcode(any(String.class))).thenReturn(560138.5);
		when(mockDao.selectAveragePriceByPropertyType(any(PropertyType.class))).thenReturn(320579.125, 363999.75);
		when(mockDao.selectAllProperties()).thenReturn(mockListings);
	}

	private List<PropertyListing> setupMockListings() {
		List<PropertyListing> listings = new ArrayList<>();
		
		for(int i=1; i<=10; i++){
			PropertyListing listing = new PropertyListing();
			listing.setPropertyReference(i);
			listing.setPrice(i*21);
			listing.setHouseNumber(i+"");
			listing.setAddress("London Road");
			listing.setRegion("London");
			listing.setPostcode("EC"+i+" 2AW");
			listing.setBathrooms(2);
			listing.setBedrooms(3);
			listing.setPropertyType(PropertyType.FLAT);
		}
		
		return listings;
	}

	@Test
	public void testFindAveragePriceByPostcode() {
		AveragePrice expected = new AveragePrice();
		expected.setPostcode("W1");
		expected.setAveragePrice(560138.5);
		
		assertEquals(expected, service.findAveragePriceByPostcode("W1"));
	}


	@Test
	public void testFindAveragePriceDifferenceByPropertyType() {
		AveragePriceDifference expected = new AveragePriceDifference();
		List<AveragePrice> propertyTypes = new ArrayList<>();
		
		AveragePrice type1 = new AveragePrice();
		type1.setPropertyType(PropertyType.FLAT);
		type1.setAveragePrice(320579.125);
		propertyTypes.add(type1);
		
		AveragePrice type2 = new AveragePrice();
		type2.setPropertyType(PropertyType.TERRACED);
		type2.setAveragePrice(363999.75);
		propertyTypes.add(type2);
		
		expected.setPropertyTypes(propertyTypes);
		expected.setPriceDifference(363999.75-320579.125);
				
		assertEquals(expected, service.findAveragePriceDifferenceByPropertyType(PropertyType.FLAT, PropertyType.TERRACED));
	}

	
	@Test
	public void testFindMostExpensivePropertiesByPercentage() {
		List<PropertyListing> expected = new ArrayList<>();

		PropertyListing listing1 = new PropertyListing();
		listing1.setPropertyReference(10);
		listing1.setPrice(10*21);
		listing1.setHouseNumber(10+"");
		listing1.setAddress("London Road");
		listing1.setRegion("London");
		listing1.setPostcode("EC"+10+" 2AW");
		listing1.setBathrooms(2);
		listing1.setBedrooms(3);
		listing1.setPropertyType(PropertyType.FLAT);
		expected.add(listing1);
		
		PropertyListing listing2 = new PropertyListing();
		listing2.setPropertyReference(9);
		listing2.setPrice(9*21);
		listing2.setHouseNumber(9+"");
		listing2.setAddress("London Road");
		listing2.setRegion("London");
		listing2.setPostcode("EC"+9+" 2AW");
		listing2.setBathrooms(2);
		listing2.setBedrooms(3);
		listing2.setPropertyType(PropertyType.FLAT);
		expected.add(listing2);
		
		assertEquals(expected, service.findMostExpensivePropertiesByPercentage(20));
	}

}
