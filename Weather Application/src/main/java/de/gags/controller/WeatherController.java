/*
 * System : WeatherApplication
 * Package: de.gags.controller
 * Class  : WeatherController
 *
 * Veristrat Software 2013
 */

package de.gags.controller;

import de.gags.model.WeatherInfo;
import de.gags.service.WeatherService;
import de.gags.validator.WeatherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * This is the controller class that routes the request coming via url pattern <AppContext>/weather/
 */
@Controller
@RequestMapping(value = "/weather")
public class WeatherController {
    private WeatherService weatherService;
    private WeatherValidator weatherValidator;

    /**
     * Constructs the WeatherController object.
     *
     * @param weatherService WeatherService object.
     * @param weatherValidator Validator object.
     */
    @Autowired
    public WeatherController(WeatherService weatherService, WeatherValidator weatherValidator) {
        this.weatherService = weatherService;
        this.weatherValidator = weatherValidator;
    }

    /**
     * This method takes the GET request and return the input form to the user.
     *
     * @param modelMap Model object.
     *
     * @return the String value returning the view to be called.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWeatherForm(ModelMap modelMap)
    {
        WeatherInfo weatherInfo = new WeatherInfo();
        modelMap.addAttribute("weatherInfo", weatherInfo);

        return "weatherForm";
    }

    /**
     * This method takes the POST request to validate and submit the input form. It returns the weather data on
     * success and input form on failure
     *
     * @param weatherInfo WeatherInfo object containing the input data
     * @param result BindingResult object containing the validation data.
     * @param status Session status information.
     *
     * @return the String value indicating the view to be called.
     *
     * @throws Exception if some exception occurs while fetching weather information.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("weatherInfo") WeatherInfo weatherInfo, BindingResult result,
                                SessionStatus status) throws Exception
    {

        // Validates the input data.
        weatherValidator.validate(weatherInfo, result);

        if (result.hasErrors())
        {
            return "weatherForm";
        }
        else
        {
            status.setComplete();
            weatherService.fetchWeatherData(weatherInfo);
            return "weatherSuccess";
        }
    }

} // End Class WeatherController
