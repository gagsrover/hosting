package de.gags.service.impl;

import de.gags.common.WeatherConstants;
import de.gags.exception.WeatherException;
import de.gags.model.WeatherInfo;
import de.gags.service.WeatherService;
import de.gags.util.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService, WeatherConstants
{
    @Override
    public void fetchWeatherData(WeatherInfo weatherInfo) throws Exception
    {
        String zipCode = weatherInfo.getZipCode().toString();
        String url = WEATHER_API_URL + zipCode + FILE_EXT_SEPARATOR + JSON_FILE_SUFFIX;
        try
        {
            JSONObject json = JsonReader.readJsonFromUrl(url);
            JSONObject currentObservation = (JSONObject)json.get("current_observation");
            JSONObject observationLocation = (JSONObject)currentObservation.get("observation_location");
            weatherInfo.setState(observationLocation.get("state").toString());
            weatherInfo.setCity(observationLocation.get("city").toString());
            weatherInfo.setCountry(observationLocation.get("country").toString());
            weatherInfo.setTempData(currentObservation.get("temperature_string").toString());
        }
        catch (UnknownHostException uhe)
        {
            throw new WeatherException("Unable to connect to host wunderground.com!!!");
        }
        catch (IOException e)
        {
            throw e;
        }
        catch (JSONException e)
        {
            throw new WeatherException("Weather information not found, please check zip code entered!!!");
        }

    }
}
