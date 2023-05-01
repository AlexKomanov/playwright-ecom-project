package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class ProductsPage extends BasePage {

    private final List<Locator> items = page.locator("[class=\"inventory_item_description\"]").all();
    private final Locator shoppingCartElement = page.locator("[class=\"shopping_cart_link\"]");

    public ProductsPage(Page page) {
        super(page);
    }

    public void chooseItemByTitle(String requiredTitle) {
        for (Locator item : items) {
            Locator itemTitle = item.locator("[class=\"inventory_item_name\"]");
            if (itemTitle.textContent().equals(requiredTitle)) {
                this.clickElement(item.locator("button"));
            }
        }
    }

    public void validateCartNumber(String numberOfItems) {
        assertThat(shoppingCartElement).hasText(numberOfItems);
    }

    public void validateCartNumber(int numberOfItems) {
        int actualNumber = Integer.parseInt(this.getTextContent(shoppingCartElement));
        Assert.assertEquals(actualNumber, numberOfItems);
    }


}
