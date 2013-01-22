/*
 * System : WeatherApplication
 * Package: de.gags.common
 * Class  : WeatherConstants
 *
 * Veristrat Software 2013
 */
package de.gags.common;

/**
 * This interface contains constants that are used in the weather application.
 */
public interface WeatherConstants
{
    public static final String WEATHER_API_KEY = "ed044d75b91fb500";

    public static final String WEATHER_API_URL = "http://api.wunderground.com/api/" + WEATHER_API_KEY + "/conditions/q/";

    public static final String FILE_EXT_SEPARATOR = ".";

    public static final String JSON_FILE_SUFFIX = "json";

} // End Interface WeatherConstants
