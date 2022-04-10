package com.poli.arq.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DatabaseConfiguration {

	@Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties abcDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "h2DataSource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource abcDataSource() {
        return abcDataSourceProperties().initializeDataSourceBuilder().build();
    }
	
    
    @Bean(name = "namedJdbcABC")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("h2DataSource") DataSource datasource) {
        return new NamedParameterJdbcTemplate(datasource);
    }
    
}
