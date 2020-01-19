package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GETCallAPI {
	//BDD Approach technique
	
	@Test(priority=1,enabled=false)
	public void getUserAPITest(){
		RestAssured.baseURI="https://gorest.co.in";//baseIRI--it is my domain URL
		given().log().all()//we get all log file from the system//loggs provide all informations
		.contentType("application/json")//to access my database
		.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD")//to access my database
		.when().log().all()
		.get("public-api/users")//to reach to my service url
		.then().log().all()
		.statusCode(200)
		.and()
		.header("Server","nginx")//we choose it because server is important
		.header("X-Rate-Limit-Limit", "30");
		
}
	
	@Test(priority=2,enabled=false)
	public void getSingleUserAPI(){
		RestAssured.baseURI="https://gorest.co.in";
		given().log().all()
		.contentType("/application/json")
		.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD")
		.when().log().all()
		.get("public-api/users?first_name=Harmon")
		.then().log().all()
		.statusCode(200)
		.and()
		.header("Server","nginx")
		.header("X-Rate-Limit-Limit", "30");
		
	}
	@Test(priority=3,enabled=true)
	public void getUserWithOneQueryParameterAPITest(){
		RestAssured.baseURI="https://gorest.co.in";
		given().log().all()
		.contentType("application/json")
		.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD")	
		.queryParam("first_name", "Harmon")
		.queryParam("gender", "male")
		.when().log().all()
		.get("public-api/users")
		.then().log().all()
		.statusCode(200)
		.and()
		.header("Server","nginx")
		.header("X-Rate-Limit-Limit", "30");
		
	}


}
