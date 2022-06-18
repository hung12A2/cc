package com;

import org.junit.Before;
import io.restassured.RestAssured;

import model.constant.constant;


public class baseRestAssured {

    @Before
    public static void init() {
        RestAssured.baseURI = constant.API_URL;
    }
}
