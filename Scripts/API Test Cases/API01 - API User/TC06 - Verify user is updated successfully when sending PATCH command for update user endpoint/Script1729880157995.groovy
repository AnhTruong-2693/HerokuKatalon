import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import heroku.api.ApiObjects
import internal.GlobalVariable


'1. Send the Login User request'
// Create loginPayload
String loginPayload = JsonOutput.toJson([
    "email": GlobalVariable.email,
    "password": GlobalVariable.password
])

// Send the POST Login User request
ApiObjects.baseAPI.createRequestObject()
    .sendRequest('/users/login', 'POST', loginPayload)

'2. Get token after login'
ApiObjects.baseAPI.getToken()

'3. Send an add user request'
// Create random email and password
String userEmail = ApiObjects.baseAPI.createRandomEmail()
String password = ApiObjects.baseAPI.createRandomPassword()

// Create addUserPayload
String addUserPayload = JsonOutput.toJson([
    "firstName": firstName,
    "lastName": lastName,
    "email": "${userEmail}",
    "password": "${password}"
])

// Send the POST Add User request
ApiObjects.baseAPI.sendRequest('/users', 'POST', addUserPayload)

'4. Verify the status code is 201'
ApiObjects.baseAPI.verifyStatusCode(201)

'5. Verify the response data'
ApiObjects.baseAPI.verifyUserData("firstName", firstName)
		.verifyUserData("lastName", lastName)
		.verifyUserData("email", "${userEmail}")
		
'6. Get token after login'
ApiObjects.baseAPI.getToken()
		
'7. Send the POST Add User request'
// Create updateUserPayload
String updateUserPayload = JsonOutput.toJson([
    "firstName": updatedFirstName,
    "lastName": updatedLastName,
    "email": "new${userEmail}",
    "password": "${password}"
])

// Send the POST Update User request
ApiObjects.baseAPI.sendRequest('/users/me', 'PATCH', updateUserPayload)

'8. Verify the status code is 200'
ApiObjects.baseAPI.verifyStatusCode(200)

'9. Verify the response data'
// Parse the JSON string to access properties
def parsedUpdateUserPayload = new JsonSlurper().parseText(updateUserPayload)

// Verify data
ApiObjects.baseAPI.verifyResponseData("firstName", parsedUpdateUserPayload.firstName)
		.verifyResponseData("lastName", parsedUpdateUserPayload.lastName)
		.verifyResponseData("email", parsedUpdateUserPayload.email)
		
'10. Send the GET User Profile request to verify yaer is updated correctly or not'
ApiObjects.baseAPI.sendRequest('/users/me', 'GET')

'11. Verify the status code is 200'
ApiObjects.baseAPI.verifyStatusCode(200)

'12. Verify the response data'
ApiObjects.baseAPI.verifyResponseData("firstName", parsedUpdateUserPayload.firstName)
		.verifyResponseData("lastName", parsedUpdateUserPayload.lastName)
		.verifyResponseData("email", parsedUpdateUserPayload.email)