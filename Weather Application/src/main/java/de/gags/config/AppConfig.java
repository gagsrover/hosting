package de.gags.config;

import de.gags.service.WeatherService;
import de.gags.service.impl.WeatherServiceImpl;
import de.gags.validator.WeatherValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public WeatherService weatherService()
    {
        return new WeatherServiceImpl();
    }

    @Bean
    public WeatherValidator weatherValidator()
    {
        return new WeatherValidator();
    }
}
