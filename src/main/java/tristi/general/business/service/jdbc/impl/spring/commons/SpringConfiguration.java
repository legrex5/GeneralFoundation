/*
 * Created on 10 Dec 2015 ( Time 04:32:01 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jdbc.impl.spring.commons;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 
 * Spring configuration class (replaces the "context.xml" spring file)
 *
 * @author Telosys Tools
 * 
 */
@Configuration
@ComponentScan(basePackages={"tristi.general.business.service.jdbc.impl.spring.commons", "tristi.general.business.service.jdbc.impl.spring"} ) // Packages where to search the components
@PropertySource("classpath:META-INF/config/database.properties") // Properties file name to be loaded
public class SpringConfiguration {

	@Autowired
	Environment env ; // Spring environment with the properties loaded from 'PropertySource'
	
	public SpringConfiguration() {
		System.out.println("Constructor " + this.getClass().getCanonicalName() );
	}

	/**
	 * Provides the bean named "dataSource" ( for Resource(name="dataSource") injection )
	 * @return
	 */
	@Bean
	public DataSource dataSource() { 
		// Creates a DBCP Connection Pool with the properties defined in the "jdbc.properties" file
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("database.driverClassName"));
		ds.setUrl(env.getProperty("database.url"));
		ds.setUsername(env.getProperty("database.username"));
		ds.setPassword(env.getProperty("database.password"));
		return ds ;
	}
}
