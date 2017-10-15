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

import co.uk.coenie.property_comparator.dao.PropertyListingDao;
import co.uk.coenie.property_comparator.model.AveragePrice;
import co.uk.coenie.property_comparator.model.AveragePriceDifference;
import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

public class PriceComparisonServiceImplTest {

	@Mock PropertyListingDao mockDao;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 

	PriceComparisonServiceImpl service;

	@Before
	public void setUp() throws Exception {
		service = new PriceComparisonServiceImpl(mockDao);

		
	}

	
	@Test
	public void testFindAveragePriceByPostcode() {
		setUpFindAveragePriceByPostcodeMock();
		AveragePrice expected = new AveragePrice()
				.setPostcode("W1")
				.setAveragePrice(560138.5);

		assertEquals(expected, service.findAveragePriceByPostcode("W1"));
	}

	private void setUpFindAveragePriceByPostcodeMock() {
		when(mockDao.selectAveragePriceByPostcode(any(String.class))).thenReturn(560138.5);
	}

	
	@Test
	public void testFindAveragePriceDifferenceByPropertyType() {
		setUpFindAveragePriceDifferenceByPropertyTypeMock();
		AveragePriceDifference expected = new AveragePriceDifference();
		expected.addPropertyType(PropertyType.FLAT, 320579.125);
		expected.addPropertyType(PropertyType.TERRACED, 363999.75);
		expected.setPriceDifference(363999.75-320579.125);

		assertEquals(expected, service.findAveragePriceDifferenceByPropertyType(PropertyType.FLAT, PropertyType.TERRACED));
	}

	private void setUpFindAveragePriceDifferenceByPropertyTypeMock() {
		when(mockDao.selectAveragePriceByPropertyType(any(PropertyType.class))).thenReturn(320579.125, 363999.75);
	}

	
	@Test
	public void testFindMostExpensivePropertiesByPercentage() {
		setUpFindMostExpensivePropertiesByPercentageMock();
		List<PropertyListing> expected = new ArrayList<>();

		expected.add(
				new PropertyListing()
				.setPropertyReference(10)
				.setPrice(10*21)
				.setHouseNumber(10+"")
				.setAddress("London Road")
				.setRegion("London")
				.setPostcode("EC"+10+" 2AW")
				.setBathrooms(2)
				.setBedrooms(3)
				.setPropertyType(PropertyType.FLAT)
				);
		expected.add(
				new PropertyListing()
				.setPropertyReference(9)
				.setPrice(9*21)
				.setHouseNumber(9+"")
				.setAddress("London Road")
				.setRegion("London")
				.setPostcode("EC"+9+" 2AW")
				.setBathrooms(2)
				.setBedrooms(3)
				.setPropertyType(PropertyType.FLAT)
				);
		expected.add(
				new PropertyListing()
				.setPropertyReference(9)
				.setPrice(9*21)
				.setHouseNumber(9+"")
				.setAddress("London Road")
				.setRegion("London")
				.setPostcode("EC"+9+" 2AW")
				.setBathrooms(2)
				.setBedrooms(3)
				.setPropertyType(PropertyType.FLAT)
				);

		assertEquals(expected, service.findMostExpensivePropertiesByPercentage(20));
	}

	private void setUpFindMostExpensivePropertiesByPercentageMock() {
		List<PropertyListing> mockListings = new ArrayList<>();

		for(int i=1; i<=10; i++){
			mockListings.add(
					new PropertyListing()
					.setPropertyReference(i)
					.setPrice(i*21)
					.setHouseNumber(i+"")
					.setAddress("London Road")
					.setRegion("London")
					.setPostcode("EC"+i+" 2AW")
					.setBathrooms(2)
					.setBedrooms(3)
					.setPropertyType(PropertyType.FLAT)
					);
		}
		// Adding duplicate of border value
		mockListings.add(
				new PropertyListing()
				.setPropertyReference(9)
				.setPrice(9*21)
				.setHouseNumber(9+"")
				.setAddress("London Road")
				.setRegion("London")
				.setPostcode("EC"+9+" 2AW")
				.setBathrooms(2)
				.setBedrooms(3)
				.setPropertyType(PropertyType.FLAT)
				);

		when(mockDao.selectAllProperties()).thenReturn(mockListings);
	}

}
