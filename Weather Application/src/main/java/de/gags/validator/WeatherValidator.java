/*
 * System : WeatherApplication
 * Package: de.gags.validator
 * Class  : WeatherValidator
 *
 * Veristrat Software 2013
 */
package de.gags.validator;

import de.gags.model.WeatherInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * This class validates the input data.
 */
public class WeatherValidator implements Validator
{
    public boolean supports(Class aClass)
    {
        return WeatherInfo.class.isAssignableFrom(aClass);
    }

    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "required.zipCode", "Zip Code is required!");

        WeatherInfo weatherInfo = (WeatherInfo) target;

        try
        {
            if (weatherInfo.getZipCode().length() < 5)
            {
                errors.rejectValue("zipCode", "invalid.zipCode");
                return;
            }

            Integer.parseInt(weatherInfo.getZipCode());

        } catch (NumberFormatException e) {
            errors.rejectValue("zipCode", "invalid.zipCode");
        }
    }

} // End Class WeatherValidator
