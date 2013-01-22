/*
 * System : WeatherApplication
 * Package: de.gags.model
 * Class  : WeatherInfo
 *
 * Veristrat Software 2013
 */
package de.gags.model;

/**
 * This is a model object that stores the weather data.
 */
public class WeatherInfo
{
    private String zipCode;

    private String state;

    private String city;

    private String country;

    private String tempData;

    /**
     * Gets the zip code
     *
     * @return the String value of the zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code
     *
     * @param zipCode the String value of the zip code to be set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the state
     *
     * @return the String value of the state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state
     *
     * @param state the String value of the State to be set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city
     *
     * @return the String value of the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city
     *
     * @param city the String value of the city to be set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the country.
     *
     * @return the String value of the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the String value of the country to be set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the temperature data in fahrenheit
     *
     * @return the String value of the temperature.
     */
    public String getTempData() {
        return tempData;
    }

    /**
     * Sets the temperature data.
     *
     * @param tempData the String value of temperature to be set.
     */
    public void setTempData(String tempData) {
        this.tempData = tempData;
    }

} // End Class WeatherInfo
