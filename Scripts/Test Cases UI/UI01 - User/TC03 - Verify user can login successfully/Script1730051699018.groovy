import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages

'1. Navigate to Sign up page'
Pages.signUpPage.navToPage()

'2. Click on Sign up button'
Pages.signUpPage.clickSignUp()
        .verifyGoToAddUserPage(addUserUrl)

'3. Add a user'
// Generate a random email
String userEmail = Pages.addUserPage.createRandomEmail()

// Input user details then click Submit
Pages.addUserPage.inputFirstName(userFirstName)
        .inputLastName(userLastName)
        .inputEmail(userEmail)  
		.inputPassword(userPassword)
        .clickSubmit()

WebUI.delay(3)

'4. Verify user is taken to Contact List page'
Pages.addUserPage.verifySignUpAndLogIn(contactListUrl)