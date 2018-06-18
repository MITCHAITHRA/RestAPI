package com.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class GetWeatherDetailsTest 
{
@Test
public void getDetails()
{
	RestAssured.baseURI = "http://localhost:3000";//I have taken sample URL by installing Node JS
	// Get the RequestSpecification of the request that you want to sent
	// to the server. The server is specified by the BaseURI that we have
	// specified in the above step.
	RequestSpecification httpRequest = RestAssured.given();

	// Make a GET request call directly by using RequestSpecification.get() method.
	// Make sure you specify the resource name.
	Response response = httpRequest.get("/customer");

	// Response.asString method will directly return the content of the body
	// as String.
	 String resp = response.asString();
     System.out.println("Response Body is =>  " + response.asString());
	int statusCode = response.getStatusCode();
	// Assert that correct status code is returned.
	Assert.assertEquals(statusCode , 200 , "Correct status code returned");
	System.out.println("Status code  is =>  " + statusCode);
}
}

