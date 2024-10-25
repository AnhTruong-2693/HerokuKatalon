import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'3. Click Add a New Contact button'
Pages.contactListPage.clickAddNewContact()

'4. Create a new contact'
// Generate a random email
String contactEmail = Pages.addContactPage.createRandomEmail()

// Input data to all fields then click Submit
Pages.addContactPage.inputFirstName(firstName)
        .inputLastName(lastName)
        .inputDateOfBirth(dateOfBrith)
        .inputEmail(contactEmail)
        .inputPhone(phone)
        .inputStreetAddress1(streetAddress1)
        .inputStreetAddress2(streetAddress2)
		.inputCity(city)
        .inputStateOrProvince(stateOrProvince)
        .inputPostalCode(postalCode)
        .inputCountry(country)
		.clickSubmit()

'5. Open detail contact'
Pages.contactListPage.clickDataOnTable('Phone', phone)

'6. Click Edit Contact button'
Pages.contactDetailPage.clickEditContact()

'7. Enter date with invalid format to "Date of Birth" field then click Submit'
Pages.addContactPage.inputDateOfBirth(dateOfBrithEdit)
		.clickSubmit()

'8. Verify user get an error message'
Pages.addUserPage.verifyErrorMessage(expectedMessage)