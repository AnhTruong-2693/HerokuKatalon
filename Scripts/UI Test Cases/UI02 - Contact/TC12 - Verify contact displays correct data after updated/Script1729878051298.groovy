import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'3. Click Add a New Contact button'
Pages.contactListPage.clickAddNewContact()

'4. Create a new contact'
// Generate a random email
String contactEmail = Pages.addUserPage.createRandomEmail()

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

'7. Edit all data in Contact form then click Submit'
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
		.clickSubmit()

'8. Verify newly updated data in the Contact form'
Pages.contactDetailPage.verifyUpdatedData('First Name:',firstNameEdit)
		.verifyUpdatedData('Last Name:',lastNameEdit)
		.verifyUpdatedData('Date of Birth:',dateOfBrithEdit)
		.verifyUpdatedData('Email:',emailEdit)
		.verifyUpdatedData('Phone:',phoneEdit)
		.verifyUpdatedData('Street Address 1:',streetAddress1Edit)
		.verifyUpdatedData('Street Address 2:',streetAddress2Edit)
		.verifyUpdatedData('City:',cityEdit)
		.verifyUpdatedData('State or Province:',stateOrProvinceEdit)
		.verifyUpdatedData('Postal Code:',postalCodeEdit)
		.verifyUpdatedData('Country:',countryEdit)