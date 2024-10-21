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

'7. Edit all data in contact fields then click Cancel'
Pages.addContactPage.inputFirstName(firstNameEdit)
		.inputLastName(lastNameEdit)
		.inputDateOfBirth(dateOfBrithEdit)
		.inputEmail(emailEdit)
		.inputPhone(phoneEdit)
		.inputStreetAddress1(streetAddress1Edit)
		.inputStreetAddress2(streetAddress2Edit)
		.inputCity(cityEdit)
		.inputStateOrProvince(stateOrProvinceEdit)
		.inputPostalCode(postalCodeEdit)
		.inputCountry(countryEdit)
		.clickCancel()

'8. Verify data in the table'
Pages.contactDetailPage.verifyUpdatedData('First Name:',firstName)
		.verifyUpdatedData('Last Name:',lastName)
		.verifyUpdatedData('Date of Birth:',dateOfBrith)
		.verifyUpdatedData('Email:',contactEmail)
		.verifyUpdatedData('Phone:',phone)
		.verifyUpdatedData('Street Address 1:',streetAddress1)
		.verifyUpdatedData('Street Address 2:',streetAddress2)
		.verifyUpdatedData('City:',city)
		.verifyUpdatedData('State or Province:',stateOrProvince)
		.verifyUpdatedData('Postal Code:',postalCode)
		.verifyUpdatedData('Country:',country)