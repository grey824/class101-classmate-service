package net.class101.classmate.config.common;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DomainApplicationContextConfig {

    @Bean(name = "modelMapper")
    @Primary
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addConverter(new AbstractConverter<String, String>() {
            @Override
            protected String convert(String source) {
                return StringUtils.isBlank(source) ? null : source.trim();
            }
        });
        return modelMapper;
    }

}
