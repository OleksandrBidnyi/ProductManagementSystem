package com.management.product.controller;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Aleksandr on 11.09.2017.
 */
public class AuthorizationControllerTest {
    private AuthorizationController authorizationController;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public AuthorizationControllerTest() {
        this.authorizationController = new AuthorizationController();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
    }

    @Test
    public void loginPageTest() {
        assertEquals(authorizationController.loginPage(), "login");
    }

    @Test
    public void logoutPageTest() {
        assertEquals(authorizationController.logoutPage(request, response), "redirect:/login?logout");
    }


}