import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Click Add a New Contact button on Contact List page'
Pages.contactListPage.clickAddNewContact()

'3. Leave blank required fields, input data to all optional fields then Submit'
Pages.addContactPage.inputDateOfBirth(dateOfBrith)
        .inputEmail(email)
        .inputPhone(phone)
        .inputStreetAddress1(streetAddress1)
		.inputStreetAddress2(streetAddress2)
        .inputCity(city)
        .inputStateOrProvince(stateOrProvince)
        .inputPostalCode(postalCode)
        .inputCountry(country)
        .clickSubmit()

'4. Verify user get an error message'
Pages.addUserPage.verifyErrorMessage(expectedMessage)