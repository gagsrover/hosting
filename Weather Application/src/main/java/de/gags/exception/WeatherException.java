/*
 * System : WeatherApplication
 * Package: de.gags.exception
 * Class  : WeatherException
 *
 * Veristrat Software 2013
 */
package de.gags.exception;

/**
 * This is a custom exception which is thrown when weather information could not be retrieved.
 */
public class WeatherException extends Exception
{
    public WeatherException(String message)
    {
        super(message);
    }

} // End Class WeatherException
