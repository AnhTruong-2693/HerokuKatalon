import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


'1. Login to the site'
Pages.signUpPage.navToPage().logIn()

'2. Clean-up data before creating new contact'
Pages.contactListPage.cleanUpContactRow('Phone', phone)

'3. Click Add a New Contact button on Contact List page'
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

'5. Count contact row'
int countContactRow = Pages.contactListPage.countRow()

'6. Open detail contact'
Pages.contactListPage.clickDataOnTable('Phone', phone)

'7. Click Edit Contact button'
Pages.contactDetailPage.clickDeleteContact().confirmNotDelete()
		
WebUI.delay(3)

'8. Verify user is still on Contact Detail page'
Pages.contactDetailPage.verifyUrl(contactDetailsUrl)

'9. Click Return to Contact List'
Pages.contactDetailPage.clickReturnToContactList()

WebUI.delay(3)

'10. Verify number of record'
Pages.contactListPage.verifyNumberOfRow(countContactRow)

'11. Verify data is displayed in table'
Pages.contactListPage.verifyDataInTable('Name', expectedName)
		.verifyDataInTable('Birthdate', dateOfBrith)
		.verifyDataInTable('Email', contactEmail)
		.verifyDataInTable('Phone', phone)
		.verifyDataInTable('Address', expectedAddress)
		.verifyDataInTable('City, State/Province, Postal Code', expectedCityCode)