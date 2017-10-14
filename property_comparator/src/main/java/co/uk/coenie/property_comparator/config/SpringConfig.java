package co.uk.coenie.property_comparator.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.relique.jdbc.csv.CsvDriver");
        dataSource.setUrl("jdbc:relique:csv:data/property-data.csv");
		
		return dataSource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
}
