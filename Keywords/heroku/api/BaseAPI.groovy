package heroku.api
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable


public class BaseAPI {

	// Create class-level variables
	RequestObject requestObject;
	ResponseObject responseObject;
	ArrayList httpHeader;

	// Initialize a new API request object
	def BaseAPI createRequestObject() {
		requestObject = new RequestObject()
		httpHeader = new ArrayList()
		return this
	}
	
	// Set httpHeader
	def setHttpHeaders() {
		// Clear and set content-type header
		httpHeader.clear()
		httpHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
	
		// Add Authorization header if token exists
		if (GlobalVariable.token) {
			httpHeader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Bearer ' + GlobalVariable.token))
		}
	
		// Set headers on the request object
		requestObject.setHttpHeaderProperties(httpHeader)		
	}

	// Set request body
	def void setRequestBody(String payload) {
	    if (payload) {
	        requestObject.setBodyContent(new HttpTextBodyContent(payload, "UTF-8", "application/json"))
	    }
	}
	
	// Send the request
	def ResponseObject sendRequest(String uri, String method, String payload = '') {
		// Set URL and method
		requestObject.setRestUrl(GlobalVariable.baseUrl + uri)
		requestObject.setRestRequestMethod(method)
		
		// Set httpHeader
		setHttpHeaders()

		// Set request body if payload is provided
		setRequestBody(payload)

		// Send the request and print out the response
		responseObject = WS.sendRequest(requestObject)
		println("Response body content is: " + responseObject.getResponseBodyContent())
		return responseObject
	}

	// Get the response
	def ResponseObject getResponse() {
		println("Response" + responseObject)
		return responseObject
	}

	// Verify response data for login or create new user
	def BaseAPI verifyUserData(String fieldName, String expectedValue) {
		def jsonResponse = new JsonSlurper().parseText(responseObject.getResponseBodyContent())

		// Extract the field value dynamically
		def actualValue = jsonResponse.user."${fieldName}"

		// Compare actual and expected values
		WS.verifyEqual(actualValue, expectedValue)

		println("${fieldName} verified successfully with actual value is: ${actualValue}")
		return this
	}

	// Verify response data for Contact or updated user
	def BaseAPI verifyResponseData(String fieldName, String expectedValue) {
		def jsonResponse = new JsonSlurper().parseText(responseObject.getResponseBodyContent())

		// Extract the field value dynamically
		def actualValue = jsonResponse."${fieldName}"

		// Compare actual and expected values
		WS.verifyEqual(actualValue, expectedValue)

		println("${fieldName} verified successfully with actual value is: ${actualValue}")
		return this
	}

	// Verify the status code
	def BaseAPI verifyStatusCode(int statusCode) {
		WS.verifyResponseStatusCode(responseObject, statusCode)
		println("Status code is " + statusCode)
		return this
	}

	// Verify response is a empty body
	def boolean verifyEmptyBody() {
		// Get the response body content
		def responseBody = responseObject.getResponseBodyContent()

		// Check if the response body is empty
		if (responseBody?.trim().isEmpty()) {
			println("Response body is empty.")
			return true
		}
		println("Response body is not empty.")
		return false
	}

	// Get token from response
	def BaseAPI getToken() {
		def jsonResponse = new JsonSlurper().parseText(responseObject.getResponseBodyContent())
		GlobalVariable.token = jsonResponse.token
		println("Token: " + GlobalVariable.token)
		return this
	}

	// Create a random email
	def String createRandomEmail() {
		int randomNum = (int)(Math.random() * 1000)
		String email = "emailtest${randomNum}@gmail.com"
		return email
	}

	// Create a random password
	def String createRandomPassword() {
		int randomNum = (int)(Math.random() * 1000)
		String password = "password@${randomNum}"
		return password
	}
}