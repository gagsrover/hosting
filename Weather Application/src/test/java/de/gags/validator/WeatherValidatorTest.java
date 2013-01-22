/*
 * System : WeatherApplication
 * Package: de.gags.validator
 * Class  : WeatherValidatorTest
 *
 * Veristrat Software 2013
 */
package de.gags.validator;

import de.gags.model.WeatherInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

/**
 * This class tests the WeatherValidator implementation.
 */
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

    /**
     * This method test the empty zip code value.
     */
    @Test
    public void testEmptyZipCode()
    {
        weatherInfo.setZipCode("");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be empty", result.hasErrors());
    }

    /**
     * This method test the zip code value containing white space.
     */
    @Test
    public void testWhiteSpaceZipCode()
    {
        weatherInfo.setZipCode(" ");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be null", result.hasErrors());
    }

    /**
     * This method tests the length of the zip code.
     */
    @Test
    public void testZipCodeLength()
    {
        weatherInfo.setZipCode("1");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code value should be greater than equal to 5", result.hasErrors());
    }

    /**
     * This method tests the invalid zip code value.
     */
    @Test
    public void testInvalidZipCode()
    {
        weatherInfo.setZipCode("335#sff");
        validator.validate(weatherInfo, result);
        Assert.assertTrue("Zip code can't be alphanumeric", result.hasErrors());
    }

} // End Class WeatherValidatorTest
