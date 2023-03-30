package demos;

import com.microsoft.playwright.*;

public class ElementsHandle {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(100)
        );

        Page page = browser.newPage();

        page.navigate("https://www.saucedemo.com/");

        String title = page.title();

        String url = page.url();

        System.out.println("title = " + title);
        System.out.println("url = " + url);

        Locator usernameInput = page.locator("#user-name");
        usernameInput.type("alex");
        page.waitForTimeout(2000);
        usernameInput.clear();
        page.waitForTimeout(2000);
        usernameInput.type("komanov");
        page.waitForTimeout(2000);
        usernameInput.fill("new value");
        page.locator("[data-test='password']").fill("alex");

        page.locator(".btn_action").click();

        String errorMessage = page.locator("[data-test=\"error\"]").textContent();
        System.out.println(errorMessage);

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();
    }
}
