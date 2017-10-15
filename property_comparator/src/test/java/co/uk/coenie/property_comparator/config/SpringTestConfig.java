package co.uk.coenie.property_comparator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
	"co.uk.coenie.property_comparator.config",
	"co.uk.coenie.property_comparator.service",
	"co.uk.coenie.property_comparator.dao"
	})
public class SpringTestConfig {

}
