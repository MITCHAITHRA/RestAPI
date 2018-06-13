package com.restassured.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class PostWeatherDetailsTest
{
	@Test
	public void getDetails()
	{
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		//JSONObject is a class that represents a simple
		// JSON adding Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		System.out.println(requestParams);
		request.header("Content-Type", "application/json");
		System.out.println(request.post("/customer").asString());
		requestParams.put("id", 101);
		requestParams.put("FirstName", "allen");
		requestParams.put("LastName", "joy"); 
		requestParams.put("Address", "103 Banglore");
		requestParams.put("Phone number",  "1234565671");
		requestParams.put("Email",  "xyz@gmail.com");
		requestParams.put("Password", "password1");
		System.out.println("**************************************************");
		System.out.println(requestParams.get("Email"));
		System.out.println(request.post("/register").asString());
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		// Post the request and check the response
		Response response = request.post("/register");
		int statusCode = response.getStatusCode();
		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

	}
}