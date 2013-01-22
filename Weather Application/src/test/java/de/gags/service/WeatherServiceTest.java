/*
 * System : WeatherApplication
 * Package: de.gags.service
 * Class  : WeatherServiceTest
 *
 * Veristrat Software 2013
 */
package de.gags.service;

import de.gags.exception.WeatherException;
import de.gags.model.WeatherInfo;
import de.gags.service.impl.WeatherServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class test the WeatherService implementation.
 */
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

    /**
     * This method tests weather service for correct zip code value.
     *
     * @throws Exception while fetching weather data.
     */
    @Test
    public void testWeatherServiceForCorrectZipCode() throws Exception
    {
        weatherInfo.setZipCode("94117");
        weatherService.fetchWeatherData(weatherInfo);
        Assert.assertNotNull("Error in fetching weather information", weatherInfo.getTempData());
    }

    /**
     * This method tests weather service for incorrect zip code value.
     *
     * @throws Exception while fetching weather data.
     */
    @Test(expected = WeatherException.class)
    public void testWeatherServiceForIncorrectZipCode() throws Exception
    {
        weatherInfo.setZipCode("986763");
        weatherService.fetchWeatherData(weatherInfo);
    }

} // End Class WeatherServiceTest
