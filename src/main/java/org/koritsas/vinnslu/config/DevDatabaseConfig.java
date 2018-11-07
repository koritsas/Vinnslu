package org.koritsas.vinnslu.config;

import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration()
@Profile("dev")
public class DevDatabaseConfig {
    @Bean
    public GeometryModelMapper geometryModelMapper(){
        return new GeometryModelMapper();
    }

}
