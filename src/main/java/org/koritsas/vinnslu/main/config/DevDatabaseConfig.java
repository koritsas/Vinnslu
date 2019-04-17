package org.koritsas.vinnslu.main.config;

import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
