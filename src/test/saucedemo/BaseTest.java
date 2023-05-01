package test.saucedemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Page page;
    protected Playwright playwright;
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );

        page = browser.newPage();
        page.setViewportSize(1800, 950);
    }

    @AfterMethod
    public void tearDown() {
        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();
    }
}
