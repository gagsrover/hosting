/*
 * System : WeatherApplication
 * Package: de.gags.controller
 * Class  : BaseWebControllerTest
 *
 * Veristrat Software 2013
 */
package de.gags.controller;

import de.gags.exception.WeatherException;
import de.gags.model.WeatherInfo;
import de.gags.service.WeatherService;
import de.gags.validator.WeatherValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class tests weather controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcher-servlet.xml"})
public class WeatherControllerTest extends BaseWebControllerTest {
    @Autowired
    private WeatherValidator validator;

    @Autowired
    private WeatherService service;

    @Autowired
    private ApplicationContext context;

    @Before
    public void before() {
        super.before();
    }

    /**
     * This method tests the input view.
     *
     * @throws Exception if request could not be handled
     */
    @Test
    public void testWeatherForm() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/weather");
        MockHttpServletResponse response = new MockHttpServletResponse();

        ModelAndView mv = handle(request, response);

        Assert.assertTrue(mv.getViewName().equals("weatherForm"));
    }

    /**
     * This method tests the error view.
     *
     * @throws Exception if request could not be handled
     */

    @Test
    public void testViewForError() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/weather");
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("zipCode", "94117agst");

        ModelAndView mv = handle(request, response);

        Assert.assertTrue(mv.getViewName().equals("weatherForm"));

    }

    /**
     * This method tests the success view.
     *
     * @throws Exception if request could not be handled
     */
    @Test
    public void testViewForSuccess() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/weather");
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("zipCode", "94117");

        ModelAndView mv = handle(request, response);

        Assert.assertTrue(mv.getViewName().equals("weatherSuccess"));
    }

    /**
     * This method tests the WeatherException.
     *
     * @throws Exception if request could not be handled
     */
    @Test(expected = WeatherException.class)
    public void testWeatherServiceException() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/weather");
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("zipCode", "9411734");

        ModelAndView mv = handle(request, response);
    }

    /**
     * This method tests is the service returned data.
     *
     * @throws Exception if request could not be handled
     */
    @Test
    public void testForData() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/weather");
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setParameter("zipCode", "94117");

        ModelAndView mv = handle(request, response);

        WeatherInfo weatherInfo = (WeatherInfo) mv.getModelMap().get("weatherInfo");

        Assert.assertNotNull(weatherInfo.getTempData());
    }

} // End Class WeatherControllerTest
