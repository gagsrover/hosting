package de.gags.validator;

import de.gags.model.WeatherInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WeatherValidator implements Validator
{
    @Override
    public boolean supports(Class aClass)
    {
        return WeatherInfo.class.isAssignableFrom(aClass);
    }

    @Override
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
}
