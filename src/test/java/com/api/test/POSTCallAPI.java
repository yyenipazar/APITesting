package com.api.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallAPI {
	
	//Creat
	
	@Test
	public void createUserWithPOSTTest(){
		RestAssured.baseURI="https://gorest.co.in";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD");
		request.contentType("application/json");
		
		File file=new File("/Users/yaseminarslan/Documents/workspace/APITesting/src/test/java/com/api/test/createuser.json");
		
		request.body(file);
		
		Response response=request.post("/public-api/users");
		
		System.out.println(response.prettyPrint());
		
	}

}
