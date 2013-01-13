package de.gags.service;

import de.gags.model.WeatherInfo;

public interface WeatherService
{
    public void fetchWeatherData(WeatherInfo weatherInfo) throws Exception;
}
