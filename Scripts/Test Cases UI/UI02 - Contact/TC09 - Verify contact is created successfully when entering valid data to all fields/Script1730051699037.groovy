import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'3. Count number of contact before adding new one'
int countContactBeforeAdd = Pages.contactListPage.countRow()

'4. Click on Add a New Contact button'
Pages.contactListPage.clickAddNewContact()

'5. Create a new contact'
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

'6. Verify newly created data in the table'
// Prepare expected values for combine fields
String expectedName = "${firstName} ${lastName}"
String expectedAddress = "${streetAddress1} ${streetAddress2}"
String expectedCityCode = "${city} ${stateOrProvince} ${postalCode}"

// Verify data shown in table
Pages.contactListPage.verifyDataInTable('Name', expectedName)
		.verifyDataInTable('Birthdate', dateOfBrith)
		.verifyDataInTable('Email', contactEmail)
		.verifyDataInTable('Phone', phone)
		.verifyDataInTable('Address', expectedAddress)
		.verifyDataInTable('City, State/Province, Postal Code', expectedCityCode)

'7. Verify number of Contact row'
int countContactAfterAdd = countContactBeforeAdd + 1

Pages.contactListPage.verifyNumberOfRow(countContactAfterAdd)