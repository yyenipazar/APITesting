package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPINoBDD {
	@Test(priority=1,enabled=true)
	public void getUserAPITest(){
		RestAssured.baseURI="https://gorest.co.in";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD");
		
		Response response=request.get("/public-api/users");
		System.out.println(response.asString());//to print all result in JSON
		System.out.println(response.prettyPrint());	//to print on the console appropriate format
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String server=response.getHeader("Server");
		Assert.assertEquals(server,"nginx");
	
		
		
	}
	@Test(priority=1,enabled=false)
	public void getUSerByParamsTest(){
		RestAssured.baseURI="https://gorest.co.in";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD");
		request.queryParam("first_name", "Harmon");
		request.queryParam("gender", "male");
		request.queryParam("status", "active");
		
		Response response=request.get("/public-api/users");
		System.out.println(response.asString());//to print all result in JSON
		System.out.println(response.prettyPrint());	//to print on the console appropriate format
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String server=response.getHeader("Server");
		Assert.assertEquals(server,"nginx");
	
	}

}
