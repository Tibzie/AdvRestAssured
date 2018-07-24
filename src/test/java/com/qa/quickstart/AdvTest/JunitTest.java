package com.qa.quickstart.AdvTest;

import org.junit.Ignore;
import org.junit.Test;


import junit.framework.TestCase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class JunitTest {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Test
	@Ignore
	public void putTest() {
		JSONObject requestParams = new JSONObject();
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		
		request = given().contentType(ContentType.JSON);
		

		requestParams.put("city", "Edinburgh");
		requestParams.put("description", "This is another test");
		requestParams.put("name", "Speedy Gonzales");
		requestParams.put("rating", 15);
		
		System.out.println(request.body(requestParams.toString()));
		
		Response response = request.post("http://localhost:8090/example/v1/hotels/");
		
		System.out.println(response.getStatusCode());
		
	}
	
	@Test
	@Ignore
	public void getTest() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		
		response = request.get("http://localhost:8090/example/v1/hotels/5");
		System.out.println(response.prettyPrint());
	}
	
	@Test
	
	public void updateTest() {
		JSONObject updateParams = new JSONObject();
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels/");
		
		updateParams.put("city", "Glasgow");
		updateParams.put("description", "Updated test");
		updateParams.put("id", 5);
		updateParams.put("name", "Mass");
		updateParams.put("rating", 20);
		
		System.out.println(request.body(updateParams.toString()));
		
		Response response = request.put("http://localhost:8090/example/v1/hotels/5");
		
		System.out.println(response.getStatusCode());
	
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		
		Response response = request.delete("http://localhost:8090/example/v1/hotels/4");
		
		System.out.println(response.getStatusCode());
	}
}
