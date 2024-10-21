
# **Framework Introduction**

## **1. UI Automation**

### Profile
- default: store global variables (Ex: url, email, password)


###  **Test Cases**
- Store test cases


###  **Object Repository**
- Test Object: Define common dynamic elements to avoid creating a object many times


### **Test Suites**
- Store a set of test cases in a module
  + TS01- User: Store a set of test cases of User
  + TS02- Contact: Store a set of test cases of Contact


###  **Keywords**
- PageObjects: Generate new instances to avoid creating new instances in test case


###  **Test Listeners**
- BrowserListener class: Open and close the browser automatically so that do not add manual in test cases
