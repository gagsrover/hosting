/*
 * System : WeatherApplication
 * Package: de.gags.service
 * Class  : WeatherService
 *
 * Veristrat Software 2013
 */
package de.gags.service;

import de.gags.model.WeatherInfo;

/**
 * This is the Weather service interface, classes should implement this interface to provide the implementation of
 * fetching weather data.
 */
public interface WeatherService
{
    public void fetchWeatherData(WeatherInfo weatherInfo) throws Exception;

} // End Interface WeatherService
