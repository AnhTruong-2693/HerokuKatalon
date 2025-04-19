import groovy.json.JsonOutput
import heroku.api.ApiObjects
import internal.GlobalVariable


'1. Send the Login User request'
// Define loginPayload
def loginPayload = JsonOutput.toJson([
	"email": GlobalVariable.email,
	"password": GlobalVariable.password
])
// Anh add codes
// Thuat add codes
// line 4
// Send the POST Login User request
ApiObjects.baseAPI.createRequestObject()
		.sendRequest('/users/login', 'POST', loginPayload)

'2. Verify the login status code'
ApiObjects.baseAPI.verifyStatusCode(200)

'3. Verify the response data'
ApiObjects.baseAPI.verifyUserData("firstName", GlobalVariable.firstName)
		.verifyUserData("lastName", GlobalVariable.lastName)
		.verifyUserData("email", GlobalVariable.email)
