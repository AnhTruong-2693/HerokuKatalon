import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


'1. Navigate to Sign up page then go to Add User Page'
Pages.signUpPage.navToPage()
        .clickSignUp()
        .verifyGoToAddUserPage(addUserUrl)

'2. Add a user'
// Generate a random email
String userEmail = Pages.addUserPage.createRandomEmail()

// Input user info
Pages.addUserPage.inputFirstName(userFirstName)
        .inputLastName(userLastName)
        .inputEmail(userEmail)  
        .inputPassword(userPassword)
        .clickSubmit()
		
WebUI.delay(3)

'3. Verify user signup and login successfully'
Pages.addUserPage.verifySignUpAndLogIn(contactListUrl)

'4. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'5. Click Add a New Contact button'
Pages.contactListPage.clickAddNewContact()

'6. Create a new contact'
//Create a random email
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

'7. Verify newly created data in the table'
// Prepare expected values
String expectedName = "${firstName} ${lastName}"
String expectedAddress = "${streetAddress1} ${streetAddress2}"
String expectedCityCode = "${city} ${stateOrProvince} ${postalCode}"

//Verify newly created data in the table
Pages.contactListPage.verifyDataInTable('Name', expectedName)
		.verifyDataInTable('Birthdate', dateOfBrith)
		.verifyDataInTable('Email', contactEmail)
		.verifyDataInTable('Phone', phone)
		.verifyDataInTable('Address', expectedAddress)
		.verifyDataInTable('City, State/Province, Postal Code', expectedCityCode)
		
'8. Verify number of contact row'
int countContactRow = Pages.contactListPage.countRow()

'9. Open detail contact'
Pages.contactListPage.clickDataOnTable('Email', contactEmail)

'10. Click Edit Contact button'
Pages.contactDetailPage.clickEditContact()

'11. Edit all data in contact'
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
		
'12. Verify newly created contact in the table'
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
		
'13. Click Delete Contact button'
Pages.contactDetailPage.clickDeleteContact().confirmDelete()
		
WebUI.delay(3)

'14. Verify data is deleted'
int countContactRowAfterDelete = countContactRow - 1

Pages.contactListPage.verifyNumberOfRow(countContactRowAfterDelete)

'15. Verify data is not displayed in table'
Pages.contactListPage.verifyDataNotDisplay('Email', contactEmail)