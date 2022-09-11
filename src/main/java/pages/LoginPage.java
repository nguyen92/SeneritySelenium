package pages;

import base.BasePage;

public class LoginPage extends BasePage {
    String emailInput = "xpath=//input[@name='email']";
    String passwordInput = "xpath=//input[@name='password']";
    String loginBtn = "xpath=//button[text()='Login']";

    public void doLogin(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(loginBtn);
    }
}
