import heroku.PageObjects as Pages


'1. Navigate to Sign up page'
Pages.signUpPage.navToPage()

'2. Click on Sign up button'
Pages.signUpPage.clickSignUp()
		.verifyGoToAddUserPage(addUserUrl)

'3. Input data to FirstName, LastName and Password with password less than 7 chars'
Pages.addUserPage.inputFirstName(userFirstName)
		.inputLastName(userLastName)
		.inputEmail(userEmail)
		.inputPassword(userPassword)
		.clickSubmit()

'4. Verify user get an error message'
String expectedMessage = "User validation failed: password: Path `password` (`${userPassword}`) is shorter than the minimum allowed length (7)."
Pages.addUserPage.verifyErrorMessage(expectedMessage)