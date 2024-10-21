import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class BrowserListener {

    @BeforeTestCase
    def openBrowserBeforeTest(TestCaseContext testCaseContext) {
        WebUI.openBrowser('')
    }

    @AfterTestCase
    def closeBrowserAfterTest(TestCaseContext testCaseContext) {
        WebUI.closeBrowser()
    }
}