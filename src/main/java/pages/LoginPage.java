package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final Locator usernameElement = page.locator("[data-test=\"username\"]");
    private final Locator passwordElement = page.locator("[data-test=\"password\"]");
    private final Locator loginButtonElement = page.locator("[data-test=\"login-button\"]");
    public LoginPage(Page page) {
        super(page);
    }

    public void fillLoginForm(String username, String password) {
        this.typeText(usernameElement, username);
        this.typeText(passwordElement, password);
        this.clickElement(loginButtonElement);
    }
}
