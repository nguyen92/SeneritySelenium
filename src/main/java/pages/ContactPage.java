package pages;

import base.BasePage;
import org.junit.Assert;
import utilities.ExcelReader;
import java.io.File;
public class ContactPage extends BasePage {

    String nameInput = "xpath=//input[@placeholder='Name']";
    String phoneInput = "xpath=//input[@placeholder='Phone Number']";
    String saveBtn = "xpath=//button[text()='Save']";
    String contactLink = "xpath=//a[@href='/contacts']";
    String addContactBtn = "xpath=//div[@class='header__add-button']/button";
    String exportToExcelBtn = "xpath=//button[@data-testid='contacts-actionBar-contactBar-export-button']";
    String allContactBtn = "xpath=//span[text()='All contacts']/preceding-sibling::div";
    String applyBtn = "xpath=//button[text()='Apply']";

    String deleteBtn = "xpath=//td[@data-label='Contact.Actions']//button[@aria-label='delete']";

    String yesBtn = "xpath=//button[text()='Yes']";

    String okBtn = "xpath=//button[text()='OK']";

    String searchField = "xpath=//input[@placeholder='Search...']";

    public void addContact(String name, String phone) {
        click(addContactBtn);
        type(nameInput, name);
        type(phoneInput, phone);
        click(saveBtn);
    }

    public void navigateToContact() {
        click(contactLink);
    }

    public void exportToExcel() {
        click(exportToExcelBtn);
        click(allContactBtn);
        click(applyBtn);
        waitABit(5000);

    }

    public void deleteContact(String name) {
        type(searchField, name);
        waitABit(2000);
        click(deleteBtn);
        click(yesBtn);
        click(okBtn);
    }

    public void verifyDataInExcel(String name, String phone) {
        waitABit(5000);
        ExcelReader excelReader = new ExcelReader(".\\downloads\\Contacts.xlsx");
        String SheetName = "Contacts";
        String nameInExcel = excelReader.getCellData(SheetName, "Name", 2);
        System.out.println(nameInExcel);
        String phoneInExcel = excelReader.getCellData(SheetName, "Phone", 2);
        System.out.println(phoneInExcel);
        Assert.assertEquals(name, nameInExcel);
        Assert.assertEquals(phone, phoneInExcel);
    }

    public void deleteFile(String path) {
        File file
                = new File(path);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
    }

}
