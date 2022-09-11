package steps;

import net.thucydides.core.annotations.Step;
import pages.ContactPage;
import pages.LoginPage;


public class FullContactSteps {

    LoginPage loginPage;
    ContactPage contactPage;


    @Step("Open website")
    public FullContactSteps openUrl(String url) {
        loginPage.openUrl(url);
        return this;
    }

    @Step("Login to the system")
    public void loginToTheSystem(String email, String password) {
        loginPage.doLogin(email, password);
    }

    @Step("navigate to contact page")
    public void navigateToContact() {
        contactPage.navigateToContact();
    }
    @Step("add contact")
    public void addContact(String name, String phone) {
        contactPage.addContact(name, phone);
    }
    @Step("export contact to excel")
    public void exportExcel() {
        contactPage.exportToExcel();
    }

    @Step("delete contact")
    public void deleteContact(String name) {
        contactPage.deleteContact(name);
    }


    @Step("get values from exported excel and verify")
    public void checkValueOfExcel(String name, String phone) {
        contactPage.verifyDataInExcel(name, phone);
    }

    @Step("delete file in downloads folder")
    public void deleteFile(String path) {
        contactPage.deleteFile(path);
    }




}
