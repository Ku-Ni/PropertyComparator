package co.uk.coenie.property_comparator.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import co.uk.coenie.property_comparator.model.PropertyListing;
import co.uk.coenie.property_comparator.model.PropertyType;

@Repository
public class PropertyListingDaoImpl implements PropertyListingDao{

	private final String selectAveragePriceByPostcode = 
			"select AVG(PRICE) as AVERAGE_PRICE from property-data where POSTCODE like :postcode";
	private final String selectAveragePriceByPropertyType = 
			"select AVG(PRICE) as AVERAGE_PRICE from property-data where PROPERTY_TYPE = :propertyType";
	private final String selectAllProperties = 
			"select * from property-data";
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public PropertyListingDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public double selectAveragePriceByPostcode(String postcode) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("postcode", postcode+"%");
		return (double) namedParameterJdbcTemplate.queryForMap(selectAveragePriceByPostcode, paramMap).get("AVERAGE_PRICE");
	}

	@Override
	public double selectAveragePriceByPropertyType(PropertyType propertyType) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("propertyType", propertyType.getName());
		return (double) namedParameterJdbcTemplate.queryForMap(selectAveragePriceByPropertyType, paramMap).get("AVERAGE_PRICE");
	}

	@Override
	public List<PropertyListing> selectAllProperties() {
		return namedParameterJdbcTemplate.query(selectAllProperties, (rs, rowNum) -> {
			return new PropertyListing()
					.setPropertyReference(rs.getInt("PROPERTY_REFERENCE"))
					.setPrice(rs.getInt("PRICE"))
					.setBedrooms(rs.getInt("BEDROOMS"))
					.setBathrooms(rs.getInt("BATHROOMS"))
					.setHouseNumber(rs.getString("HOUSE_NUMBER"))
					.setAddress(rs.getString("ADDRESS"))
					.setRegion(rs.getString("REGION"))
					.setPostcode(rs.getString("POSTCODE"))
					.setPropertyType(PropertyType.valueOf(StringUtils.upperCase(rs.getString("PROPERTY_TYPE"))));
		});
	}

}
