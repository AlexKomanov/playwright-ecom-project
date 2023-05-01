package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void clickElement(Locator element) {
        element.click();
    }

    protected void fillText(Locator element, String text) {
        element.fill(text);
    }

    protected void typeText(Locator element, String text) {
        element.clear();
        element.type(text, new Locator.TypeOptions().setDelay(50));
    }

    protected String getTextContent(Locator element) {
        return element.textContent();
    }

    public void validatePageUrl(String url) {
        assertThat(page).hasURL(url);
    }


}
