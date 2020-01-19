package com.api.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTCallAPI {
	
	//Update
	
	@Test
	public void updateUserWithPUTTest(){
		RestAssured.baseURI="https://gorest.co.in";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD");
		request.contentType("application/json");
		
		File file=new File("/Users/yaseminarslan/Documents/workspace/APITesting/src/test/java/com/api/test/Updateuser.json");
		
		request.body(file);
		
		Response response=request.put("/public-api/users/30");
		
		System.out.println(response.prettyPrint());
	}

}
