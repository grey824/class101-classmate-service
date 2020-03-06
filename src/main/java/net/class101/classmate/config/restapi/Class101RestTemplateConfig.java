package net.class101.classmate.config.restapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "class101.restapi")
public class Class101RestTemplateConfig {
    private int readTimeout;
    private int connectionTimeout;
    private int totalConnection;
    private int maxConnectionPerRoute;
}
