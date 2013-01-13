package de.gags.service;

import de.gags.exception.WeatherException;
import de.gags.model.WeatherInfo;
import de.gags.service.impl.WeatherServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherServiceTest
{
    private WeatherInfo weatherInfo;
    private WeatherService weatherService;

    @Before
    public void setup()
    {
        weatherInfo = new WeatherInfo();
        weatherService = new WeatherServiceImpl();
    }

    @After
    public void tearDown()
    {
        weatherInfo = null;
        weatherService = null;
    }

    @Test
    public void testWeatherService() throws Exception
    {
        weatherInfo.setZipCode("94117");
        weatherService.fetchWeatherData(weatherInfo);
        Assert.assertNotNull("Error in fetching weather information", weatherInfo.getTempData());
    }

    @Test(expected = WeatherException.class)
    public void testWeatherServiceForIncorrectZipCode() throws Exception
    {
        weatherInfo.setZipCode("986763");
        weatherService.fetchWeatherData(weatherInfo);
    }
}
