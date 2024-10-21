package heroku

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages


public class ContactDetailPage {

	def ContactDetailPage clickEditContact() {
		WebUI.click(Pages.elementPage.button('edit-contact'))
		return this
	}

	def ContactDetailPage clickDeleteContact() {
		WebUI.click(Pages.elementPage.button('delete'))
		return this
	}

	def ContactDetailPage clickReturnToContactList() {
		WebUI.click(Pages.elementPage.button('return'))
		return this
	}

	def ContactDetailPage confirmDelete() {
		WebUI.waitForAlert(10)
		WebUI.acceptAlert()
	}

	def ContactDetailPage confirmNotDelete() {
		WebUI.waitForAlert(10)
		WebUI.dismissAlert()
	}

	def ContactDetailPage verifyUrl(String expectedUrl) {
		String actualUrl = WebUI.getUrl()
		WebUI.verifyEqual(actualUrl, expectedUrl)
		return this
	}

	def ContactDetailPage verifyUpdatedData(String labelName, String expectedValue) {
		String xpath = "//form[@id='contactDetails']/p/label[normalize-space(text())='${labelName}']/following-sibling::span"

		String actualValue = WebUI.getText(Pages.elementPage.byXpath(xpath))
		WebUI.verifyEqual(actualValue, expectedValue)
		return this
	}
}
