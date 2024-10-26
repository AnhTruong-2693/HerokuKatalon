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
		
'2. Get token after login'
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

'5. Verify the response data for new contact'
ApiObjects.baseAPI.verifyResponseData("firstName", firstName)
		.verifyResponseData("lastName", lastName)
		.verifyResponseData("birthdate", birthdate)	
		.verifyResponseData("email", "${contactEmail}")
		.verifyResponseData("phone", phone)
		.verifyResponseData("street1", street1)
		.verifyResponseData("street2", street2)
		.verifyResponseData("city", city)
		.verifyResponseData("stateProvince", stateProvince)
		.verifyResponseData("postalCode", postalCode)
		.verifyResponseData("country", country)

'6. Send the PATCH Update Contact request' 
// Define updateContactPayload
def updateContactPayload = JsonOutput.toJson([
	"firstName": updatedFirstName,
	"lastName": updatedLastName,
	"birthdate": updatedBirthdate,
	"email": "update${contactEmail}",
	"phone": updatedPhone,
	"street1": updatedStreet1,
	"street2": updatedStreet2,
	"city": updatedCity,
	"stateProvince": updatedStateProvince,
	"postalCode": updatedPostalCode,
	"country": updatedCountry
])

// Send the PATCH Update Contact request
ApiObjects.baseAPI.sendRequest('/contacts', 'PATCH', updateContactPayload)

'7. Verify the status code is 503'
ApiObjects.baseAPI.verifyStatusCode(503)