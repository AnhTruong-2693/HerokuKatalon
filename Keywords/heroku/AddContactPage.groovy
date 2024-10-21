package heroku
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


public class AddContactPage{

	def AddContactPage clearTextThenSendKeys(TestObject to, String value) {
		WebUI.clearText(to)
		WebUI.sendKeys(to, value)
		return this
	}

	def AddContactPage inputFirstName (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('firstName'),value)
		return this
	}

	def AddContactPage inputLastName (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('lastName'),value)
		return this
	}

	def AddContactPage inputDateOfBirth (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('birthdate'),value)
		return this
	}

	def AddContactPage inputEmail (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('email'),value)
		return this
	}

	def AddContactPage inputPhone (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('phone'),value)
		return this
	}

	def AddContactPage inputStreetAddress1 (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('street1'),value)
		return this
	}

	def AddContactPage inputStreetAddress2 (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('street2'),value)
		return this
	}

	def AddContactPage inputCity (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('city'),value)
		return this
	}

	def AddContactPage inputStateOrProvince (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('stateProvince'),value)
		return this
	}

	def AddContactPage inputPostalCode (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('postalCode'),value)
		return this
	}

	def AddContactPage inputCountry (String value) {
		clearTextThenSendKeys(Pages.elementPage.textbox('country'),value)
		return this
	}

	def AddContactPage clickSubmit() {
		WebUI.click(Pages.elementPage.button('submit'))
		return this
	}

	def AddContactPage clickCancel() {
		WebUI.click(Pages.elementPage.button('cancel'))
		return this
	}

	def String createRandomEmail() {
		int randomNum = (int)(Math.random() * 1000);
		String email = "contactemail${randomNum}@gmail.com"
		return email
	}
}