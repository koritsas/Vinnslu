package org.koritsas.vinnslu.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.koritsas.vinnslu.utils.GeometryModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public GeometryModelMapper geometryModelMapper(){return new GeometryModelMapper();}


    @Bean
    public JtsModule jtsModule()
    {
        return new JtsModule();
    }
}
