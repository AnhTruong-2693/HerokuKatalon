package heroku
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable 


public class PageObjects {
	static SignUpPage signUpPage = new SignUpPage()
	static AddUserPage addUserPage = new AddUserPage()
	static AddContactPage addContactPage = new AddContactPage()
	static ContactListPage contactListPage = new ContactListPage()
	static ContactDetailPage contactDetailPage = new ContactDetailPage()
	static ElementPage elementPage = new ElementPage()
	//private static final EventFiringWebDriver eventFiring = GlobalVariable.isAPIRunning ? null : ((DriverFactory.getWebDriver()) as EventFiringWebDriver).register(new NWebDriverEventHandler());
}