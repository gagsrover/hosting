/*
 * System : WeatherApplication
 * Package: de.gags.controller
 * Class  : BaseWebControllerTest
 *
 * Veristrat Software 2013
 */

package de.gags.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class acts as a base class for other test controller classes.
 */
public class BaseWebControllerTest
{
    @Autowired
    protected ApplicationContext context;
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;
    protected HandlerAdapter adapter;

    /**
     * This is a setup method. Subclasses will override this method.
     */
    public void before()
    {
        adapter = context.getBean(HandlerAdapter.class);
    }

    /**
     * This method handles the request coming from the test methods.
     *
     * @param request HttpRequest object.
     * @param response HttpResponse object.
     *
     * @return ModelAndView object.
     *
     * @throws Exception is the request could not be handled.
     */
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final HandlerMapping mapping = context.getBean(HandlerMapping.class);
        final HandlerExecutionChain handler  = mapping.getHandler(request);
        Assert.assertNotNull("No handler found for request, check your handler mapping", handler);

        final Object controller = handler.getHandler();

        return adapter.handle(request, response, controller);
    }

} // End Class BaseWebControllerTest
