package heroku
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages
import internal.GlobalVariable

public class SignUpPage {

	def SignUpPage navToPage() {
		WebUI.navigateToUrl(GlobalVariable.url)
		return this
	}

	def SignUpPage clickSignUp() {
		WebUI.click(Pages.elementPage.button('signup'))
		return this
	}

	def SignUpPage logIn() {
		WebUI.sendKeys(Pages.elementPage.textbox('email'),GlobalVariable.email)
		WebUI.sendKeys(Pages.elementPage.textbox('password'),GlobalVariable.password)
		WebUI.click(Pages.elementPage.button('submit'))
		return this
	}

	def SignUpPage verifyGoToAddUserPage (String expectedUrl) {
		String actualUrl = WebUI.getUrl()
		WebUI.verifyEqual(actualUrl,expectedUrl)
		return this
	}
}