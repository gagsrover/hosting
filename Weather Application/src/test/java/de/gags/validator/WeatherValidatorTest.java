package de.gags.validator;

import de.gags.model.WeatherInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

public class WeatherValidatorTest
{
    private WeatherInfo weatherInfo;
    private WeatherValidator validator;
    private BindingResult result;

    @Before
    public void setup()
    {
        weatherInfo = new WeatherInfo();
        validator = new WeatherValidator();
        result = new BeanPropertyBindingResult(weatherInfo, "weatherInfo");
    }
    @After
    public void tearDown()
    {
        weatherInfo = null;
        validator = null;
        result = null;
    }

    @Test
    public void testEmptyZipCode()
    {
        weatherInfo.setZipCode("");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be empty", result.hasErrors());
    }

    @Test
    public void testWhiteSpaceZipCode()
    {
        weatherInfo.setZipCode(" ");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be null", result.hasErrors());
    }

    @Test
    public void testZipCodeLength()
    {
        weatherInfo.setZipCode("1");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code value should be greater than equal to 5", result.hasErrors());
    }

    @Test
    public void testInvalidZipCode()
    {
        weatherInfo.setZipCode("335#sff");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be alphanumeric", result.hasErrors());
    }
}
