package com;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.constant.constant;
import model.reqmodel.loginReqModel;
import model.resUnitTest.resUnitTest;
import model.resmodel.loginResModel;
import model.constant.constant.Request.RequestApiLogin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class loginRestAssured extends baseRestAssured {
    
    public static resUnitTest UnitTest000() {
    	RestAssured.baseURI = constant.API_URL;
    	loginReqModel requestBody = RequestApiLogin.UnitTest000.requestBody;
    	resUnitTest rut = new resUnitTest(); 
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString;
		try {
			
			jsonString = mapper.writeValueAsString(requestBody);
	    	Response res = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(jsonString)
	                .post(RequestApiLogin.apiPath);


            loginResModel resObj = mapper.readValue(res.asString(), loginResModel.class);
	        
	        rut.setInput(jsonString);
	        rut.setName("API_LOGIN_000");
	        rut.setOutput(res.asPrettyString());
	        
			assertFalse("code != 1000 ", resObj.getCode() != 1000);
			assertFalse("mess != OK",  !resObj.getMessage().equals("OK"));
	
	        // not null user data
	        assertNotNull(resObj.getData().getUser());
	        // not null access token
	        assertNotNull(resObj.getData().getAccessToken());
	        
	        constant.ACCESS_TOKEN = "Bearer " + resObj.getData().getAccessToken();
	        
	        

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rut;
    }
	
	//API LOGIN NHAP KHONG DUNG DINH DANG EMAIL - MA CODE 1001
    @Test
    public static resUnitTest UnitTest001() {
    	
    	loginReqModel requestBody = RequestApiLogin.UnitTest001.requestBody;
    	resUnitTest rut = new resUnitTest(); 
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString;
		try {
			jsonString = mapper.writeValueAsString(requestBody);
			Response res = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(jsonString)
	                .post(RequestApiLogin.apiPath);

			rut.setInput(jsonString);
			rut.setName("API_LOGIN_001");
	        rut.setOutput(res.asPrettyString());

			
			loginResModel resObj = mapper.readValue(res.asString(), loginResModel.class);
			assertFalse("code != 1001 ", resObj.getCode() != 1001 );
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rut;
    }
    
  //API LOGIN NHAP KHONG DUNG EMAIL PASSWORD - MA CODE 1002
    @Test
    public static resUnitTest UnitTest002() {
    	
    	loginReqModel requestBody = RequestApiLogin.UnitTest002.requestBody;
    	resUnitTest rut = new resUnitTest(); 
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString;
		try {
			jsonString = mapper.writeValueAsString(requestBody);
			
			Response res = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(jsonString)
	                .post(RequestApiLogin.apiPath);

	        //res.prettyPrint();
			rut.setInput(jsonString);
			rut.setName("API_LOGIN_002");
	        rut.setOutput(res.asPrettyString());
			
			loginResModel resObj = mapper.readValue(res.asString(), loginResModel.class);
			assertFalse("code != 1002 ", resObj.getCode() != 1002);
			
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rut;
    }
    
}
