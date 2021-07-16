package com.videogamedb.testBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/app/videogames";
    }
}
