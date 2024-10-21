package heroku
import org.openqa.selenium.WebElement
import heroku.PageObjects as Pages


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject

public class ElementPage {
	// Define method to return a button TestObject
	def TestObject button(String buttonId) {
		return findTestObject("TestObject/btn", [('id'): buttonId])
	}

	// Define method to return a text box TestObject
	def TestObject textbox(String inputId) {
		return findTestObject("TestObject/txt", [('id'): inputId])
	}

	// Define method to return a table TestObject
	def TestObject table(String tableId) {
		return findTestObject("TestObject/tbl", [('id'): tableId])
	}

	// Define method to return a label TestObject
	def TestObject label(String labelFor) {
		return findTestObject("TestObject/lbl", [('for'): labelFor])
	}

	// Define method to return a table TestObject
	def TestObject span(String spanId) {
		return findTestObject("TestObject/byId", [('id'): spanId])
	}

	// Define method to locate an element
	def TestObject byXpath(xpath) {
		return findTestObject("TestObject/byXpath",[('xpath'):xpath])
	}
}