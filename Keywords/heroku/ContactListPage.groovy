package heroku
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import heroku.PageObjects as Pages
import internal.GlobalVariable


public class ContactListPage {

	def ContactListPage clickAddNewContact() {
		WebUI.click(Pages.elementPage.button('add-contact'))
		return this
	}

	def ContactListPage verifyDataInTable(String columnName, String expectedValue) {
		String xpath = "//thead/tr/th[text()='${columnName}']//following::td[text()='${expectedValue}']"
		boolean existingData = WebUI.verifyElementPresent(Pages.elementPage.byXpath(xpath), GlobalVariable.waitSomeTime, FailureHandling.OPTIONAL)
		String actualValue = " "

		if (existingData) {
			actualValue = WebUI.getText(Pages.elementPage.byXpath(xpath))
		}

		KeywordUtil.logInfo("The column '${columnName}' has actual value is " + actualValue.toString())
		WebUI.verifyEqual(actualValue, expectedValue)
		return this
	}


	def int countRow() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(10)
		WebElement tableElement = driver.findElement(By.xpath("//table[@class='contactTable']"))
		List<WebElement> bodyRows = tableElement.findElements(By.xpath("//tr[@class='contactTableBodyRow']"))

		if (bodyRows.isEmpty()) {
			KeywordUtil.logInfo("No rows found, returning count = 0")
			return 0
		}

		int count = bodyRows.size()
		KeywordUtil.logInfo("Number of rows in Contact table: " + count)
		return count
	}


	def ContactListPage verifyNumberOfRow(int countContact) {
		int finalRowCount = countRow()
		KeywordUtil.logInfo("Total number of rows in Contact table: " + finalRowCount)
		WebUI.verifyEqual(finalRowCount, countContact)
		return this
	}

	def ContactListPage clickDataOnTable(String columnName, String value) {
		WebUI.click(Pages.elementPage.byXpath("//thead/tr/th[text()='${columnName}']//following::td[text()='${value}']"))
		return this
	}

	def ContactListPage verifyURL(String expectedUrl) {
		String actualUrl = WebUI.getUrl()
		WebUI.verifyEqual(actualUrl, expectedUrl)
		return this
	}

	def ContactListPage cleanUpContactRow(String columnName, String value) {
		String cellXpath = "//thead/tr/th[text()='${columnName}']//following::td[text()='${value}']"

		WebUI.comment("Generated XPath: " + cellXpath)

		boolean existingData = WebUI.verifyElementPresent(Pages.elementPage.byXpath(cellXpath), GlobalVariable.waitSomeTime, FailureHandling.OPTIONAL)

		if (existingData) {
			WebUI.click(Pages.elementPage.byXpath(cellXpath))
			WebUI.click(Pages.elementPage.button('delete'))
			Pages.contactDetailPage.clickDeleteContact().confirmDelete()
		} else {
			WebUI.comment("No row found with value '${value}' in column '${columnName}'")
		}

		return this
	}

	def ContactListPage verifyDataNotDisplay (String columnName, String value) {
		WebUI.verifyElementNotPresent(Pages.elementPage.byXpath("//thead/tr/th[text()='${columnName}']//following::td[text()='${value}']"), GlobalVariable.waitSomeTime)
		return this
	}
}