
# **Framework Introduction**

## **Automation**

### Profile
- default: store global variables that are used for UI test case
- profileAPI: store global variables that are used for API test case


###  **Test Cases**
- Store API test cases
   + API01 - API User
   + API02 - API Contact

- Store UI test cases
   + UI01 - User
   + UI02 - Contact
   + UI03 - Full Flow


###  **Object Repository**
- Test Object: Define common dynamic elements to avoid creating a object many times


### **Test Suites**
- Master Test Suite API: Store API test suites
   + API01 - API User
   + API02 - API Contact

- Master Test Suite UI: Store UI test suites
   + UI01 - User
   + UI02 - Contact
   + UI03 - Full Flow
   
- Suit Collection: Group multiple test suites to run together


###  **Keywords**
- hekoru: Contains classes with functions and properties are used in UI test cases
   + PageObjects: Generate new instances to avoid creating new instances in test case
   + ElementPage.groovy: Define method to return common element in pages
   + <specificPage>Page.groovy: Contains functions and properties are used in this specific page

- hekoruAPI: Contains classes with functions and properties are used in API test cases
   + ApiObjects: Generate new instances BaseAPI
   + BaseAPI.groovy: Contains functions and properties are used in API User and API Contact


###  **Test Listeners**
- BrowserListener class: Open and close the browser automatically so that do not add manual in test cases
