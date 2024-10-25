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
		
'6. Open detail contact'
Pages.contactListPage.clickDataOnTable('Email', contactEmail)

'7. Click Edit Contact button'
Pages.contactDetailPage.clickDeleteContact().confirmDelete()
		
WebUI.delay(3)

'8. Verify data is deleted'
int countContactRowAfterDelete = countContactRow - 1

Pages.contactListPage.verifyNumberOfRow(countContactRowAfterDelete)

'9. Verify data is not displayed in table'
Pages.contactListPage.verifyDataNotDisplay('Email', contactEmail)