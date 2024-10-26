import groovy.json.JsonOutput
import heroku.api.ApiObjects
import internal.GlobalVariable

'1. Send a login user request' 
// Define loginPayload
def loginPayload = JsonOutput.toJson([
    "email": GlobalVariable.email,
    "password": GlobalVariable.password
])

// Send the POST Login User request
ApiObjects.baseAPI.createRequestObject()
    .sendRequest('/users/login', 'POST', loginPayload)
		
'2. Get token after creating user'
ApiObjects.baseAPI.getToken()

'3. Send an add user request'
// Create a random email
String contactEmail = ApiObjects.baseAPI.createRandomEmail()

// Define addContactPayload
def addContactPayload = JsonOutput.toJson([
    "firstName": firstName,
    "lastName": lastName,
    "birthdate": birthdate,
    "email": "${contactEmail}",
    "phone": phone,
    "street1": street1,
    "street2": street2,
    "city": city,
    "stateProvince": stateProvince,
    "postalCode": postalCode,
    "country": country
])

// Send the POST Add Contact request
ApiObjects.baseAPI.sendRequest('/contacts', 'POST', addContactPayload)

'4. Verify the status code is 201'
ApiObjects.baseAPI.verifyStatusCode(201)

'5. Send the DELETE Delete Contact request'
ApiObjects.baseAPI.sendRequest('/contacts', 'DELETE')

'6. Verify the status code is 503'
ApiObjects.baseAPI.verifyStatusCode(503)