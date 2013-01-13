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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/weather")
public class WeatherController {
    private WeatherService weatherService;
    private WeatherValidator weatherValidator;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherValidator weatherValidator) {
        this.weatherService = weatherService;
        this.weatherValidator = weatherValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showWeatherForm(ModelMap modelMap) {
        WeatherInfo weatherInfo = new WeatherInfo();
        modelMap.addAttribute("weatherInfo", weatherInfo);

        return "weatherForm";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("weatherInfo") WeatherInfo weatherInfo, BindingResult result,
                                SessionStatus status) throws Exception
    {

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

}
