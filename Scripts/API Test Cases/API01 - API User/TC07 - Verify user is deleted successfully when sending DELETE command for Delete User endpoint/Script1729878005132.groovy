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
				
'5. Get token after creating user'
ApiObjects.baseAPI.getToken()
		
'6. Send an delete user request'
ApiObjects.baseAPI.sendRequest('/users/me', 'DELETE')

'7. Verify the status code is 200'
ApiObjects.baseAPI.verifyStatusCode(200)

'8. Verify the response data is empty'
ApiObjects.baseAPI.verifyEmptyBody()