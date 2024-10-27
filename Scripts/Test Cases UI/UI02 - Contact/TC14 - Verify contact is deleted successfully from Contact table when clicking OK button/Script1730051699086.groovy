import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'3. Click Add a New Contact button'
Pages.contactListPage.clickAddNewContact()

'4. Create a new contact'
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

'5. Count contact row'
int countContactRow = Pages.contactListPage.countRow()
		
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

'7. Open detail contact'
Pages.contactListPage.clickDataOnTable('Phone', phone)

'8. Click Edit Contact button'
Pages.contactDetailPage.clickDeleteContact().confirmDelete()
		
WebUI.delay(3)

'9. Verify contact is deleted by counting number of contact row'
int countContactRowAfterDelete = countContactRow - 1

Pages.contactListPage.verifyNumberOfRow(countContactRowAfterDelete)

'10. Verify data is not displayed in table'
Pages.contactListPage.verifyDataNotDisplay('Email', contactEmail)