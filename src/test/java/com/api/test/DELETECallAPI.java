package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETECallAPI {
	@Test
	public void deleteUserAPITest(){
	
		RestAssured.baseURI="https://gorest.co.in";	
		RequestSpecification request =RestAssured.given().log().all();
		request.header("Authorization","Bearer sgKjlFvS8gw0FL6nHdvBn_PENrNtW5eqIIKD");	
		
		Response response=request.delete("/public-api/users/15");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		//to delete function
		JsonPath js=response.jsonPath();
		System.out.println(js.get("result"));
		Assert.assertNull(js.get("result"));
		
	}

}
