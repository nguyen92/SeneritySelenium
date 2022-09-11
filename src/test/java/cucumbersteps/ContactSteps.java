package cucumbersteps;

import io.restassured.response.Response;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.APISteps;
import steps.FullContactSteps;

import java.util.Random;

public class ContactSteps {

    @Steps
    FullContactSteps contact;

    @Steps
    APISteps api;
    Response response;
    Random rand = new Random();
    String contactName = "Nguyen" + String.valueOf(rand.nextInt(50));
    String phone = String.valueOf(rand.nextInt(99999999));

    @Given("^user login to the system with email (.*) and password (.*)$")
    public void userLoginToTheSystemWithEmailAndPassword(String email, String password){
        contact.openUrl("https://whatsapp-inbox-chat.clare.ai/");
        contact.loginToTheSystem(email,password);
    }

    @And("^go to the Contact page$")
    public void goToTheContactPage() {
        contact.navigateToContact();
    }

    @When("^user add new contact$")
    public void userAddNewContact() {
        contact.addContact(contactName,phone);
    }

    @And("^export the contacts to excel$")
    public void exportTheContactsToExcel() {
        contact.exportExcel();
    }

    @Then("^verify the excel file includes the created contact$")
    public void verifyTheExcelFileIncludesTheCreatedContact() {
        contact.checkValueOfExcel(contactName, phone);
        contact.deleteContact(contactName);
        contact.deleteFile(".\\downloads\\Contacts.xlsx");
    }

    @Given("^send post request to server$")
    public void sendPostRequestToServer() {
        response =  api.sendPostRequest(5, 0);
        api.verifyStatusCode(200);
    }

    @Then("^get the response that has Contact is Valid$")
    public void getTheResponseThatHasContactIsValid() {
        api.getTheContact(response);
    }
}
