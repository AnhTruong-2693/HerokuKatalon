package heroku
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


class AddUserPage {

	def AddUserPage inputFirstName(String value) {
		WebUI.sendKeys(Pages.elementPage.textbox('firstName'),value)
		return this
	}

	def AddUserPage inputLastName(String value) {
		WebUI.sendKeys(Pages.elementPage.textbox('lastName'),value)
		return this
	}


	def AddUserPage inputEmail(String value) {
		WebUI.sendKeys(Pages.elementPage.textbox('email'),value)
		return this
	}


	def AddUserPage inputPassword(String value) {
		WebUI.sendKeys(Pages.elementPage.textbox('password'),value)
		return this
	}

	def AddUserPage clickSubmit() {
		WebUI.click(Pages.elementPage.button('submit'))
		return this
	}

	def String createRandomEmail() {
		int randomNum = (int)(Math.random() * 1000);
		String email = "useremail${randomNum}@gmail.com"
		return email
	}

	def AddUserPage verifySignUpAndLogIn(String expectedUrl) {
		String actualUrl = WebUI.getUrl()
		WebUI.verifyEqual(actualUrl, expectedUrl)
		return this
	}

	def AddUserPage verifyErrorMessage(String expectedMessage) {
		String actualMessage = WebUI.getText(Pages.elementPage.span('error'))
		WebUI.verifyEqual(actualMessage, expectedMessage)
		return this
	}
}