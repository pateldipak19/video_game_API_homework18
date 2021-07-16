package com.videogamedb.videoGame;

import com.videogamedb.VideoGamesPojo;
import com.videogamedb.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class VideoGameTest extends TestBase {

    Response response;


    //GET Requests

    @Test
    public void getAllGames(){

        response = given().header("Accept","application/json")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getGameByName(){

        HashMap<String,Object> qParam =new HashMap<>();
        qParam.put("name","Grand Theft Auto III");
        response=given().header("Accept","application/json")
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }


    @Test
    public void getGameByID(){

        response=given().header("Accept","application/json")
                .pathParam("id","3")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getGameByReleaseDate(){

        HashMap<String, Object> qParam= new HashMap<>();
        qParam.put("releaseDate",2005);

        response=given().header("Accept","application/json")
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getGameByReviewScore(){

        HashMap<String,Integer> qParam = new HashMap<>();
        qParam.put("reviewScore",90);

        response=given().header("Accept","application/json")
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void getGameByCategory(){

        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("category","Driving");

        response=given().header("Accept","application/json")
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void getGameByRating(){

        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("rating","PG-13");

        response=given().header("Accept","application/json")
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }


//POST Requests


    @Test
    public void createNewGameData() {
        VideoGamesPojo videoGamesPojo = new VideoGamesPojo();

        videoGamesPojo.setId(15);
        videoGamesPojo.setName("FIF3ACricket");
        videoGamesPojo.setReleaseDate("2020-11-05");
        videoGamesPojo.setReviewScore(100);
        videoGamesPojo.setCategory("Cricket");
        videoGamesPojo.setRating("Universal");

        response=given()
                .header("Content-Type","application/json")
                .body(videoGamesPojo)
                .when()
                .post();
        response.then().statusCode(200);
        response.prettyPrint();


    }

    //PUT Requests

    @Test
    public void updateGameData() {
        VideoGamesPojo videoGamesPojo = new VideoGamesPojo();
        videoGamesPojo.setName("MiniGames");
        videoGamesPojo.setId(5);

        response=given()
                .pathParam("id",5)
                .header("Content-Type","application/json")
                .body(videoGamesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteGameData(){

        response=given()
                .pathParam("id","7")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
