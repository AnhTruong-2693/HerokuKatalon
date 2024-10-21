package heroku
import heroku.AddContactPage as AddContactPage
import heroku.AddUserPage as AddUserPage
import heroku.ContactDetailPage as ContactDetailPage
import heroku.ContactListPage as ContactListPage
import heroku.SignUpPage as SignUpPage
import heroku.ElementPage as ElementPage


public class PageObjects {
	static SignUpPage signUpPage = new SignUpPage()
	static AddUserPage addUserPage = new AddUserPage()
	static AddContactPage addContactPage = new AddContactPage()
	static ContactListPage contactListPage = new ContactListPage()
	static ContactDetailPage contactDetailPage = new ContactDetailPage()
	static ElementPage elementPage = new ElementPage()
}