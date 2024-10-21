import heroku.PageObjects as Pages

'1. Navigate to Sign up page'
Pages.signUpPage.navToPage()

'2. Click on Sign up button'
Pages.signUpPage.clickSignUp()
		.verifyGoToAddUserPage(addUserUrl)
		
'3. Input data to FirstName, LastName and Password '
Pages.addUserPage.inputFirstName(userFirstName)
		.inputLastName(userLastName)
		.inputPassword(userPassword)
        .clickSubmit()
		
'4. Verify user get an error message'
Pages.addUserPage.verifyErrorMessage(expectedMessage)