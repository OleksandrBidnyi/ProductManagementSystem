package com.management.product.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr on 11.09.2017.
 */
public class IllegalAccessControllerTest {

    private IllegalAccessController illegalAccessController;

    public IllegalAccessControllerTest() {
        this.illegalAccessController = new IllegalAccessController();
    }

    @Test
    public void getIllegalAccessExceptionTest() {
        IllegalAccessException exception = new IllegalAccessException(
                "The user doesn`t have rights to access the request"
        );
        try {
            illegalAccessController.getIllegalAccessExceprion();
        } catch (IllegalAccessException e) {
            assertEquals(e.getMessage(), exception.getMessage());
        }
    }

}