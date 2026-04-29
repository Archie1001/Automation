import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class XKomPage extends BasePage {

    @FindBy(xpath = "//button[@data-name=\"AcceptPermissionButton\"]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//input[contains(@class, 'parts__Input')]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'parts__ButtonIcon')]")
    private WebElement searchButton;

    @FindBy(xpath = "//h3[@title=\"Smartfon / Telefon Apple iPhone 17 Pro 1TB Srebrny\"]")
    private WebElement productTitle;

    @FindBy(xpath = "//span[contains(@class, 'parts__Price')]")
    private WebElement productPrice;

    @FindBy(xpath = "//h3[@title ='Promocje i inspiracje']/following-sibling::ul")
    private WebElement footerLinksContainer;

    public XKomPage(WebDriver driver) {
        super(driver);
    }

    public XKomPage open(String string) {
        driver.get(string);
        return this;
    }

    public XKomPage acceptCookies() {
        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        acceptCookiesButton.click();
        return this;
    }

    public XKomPage searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(productName);
        searchButton.click();
        return this;
    }

    public XKomPage clickProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productTitle));
        productTitle.click();
        return this;
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText();
    }

    public List<WebElement> getFooterLinks() {
        wait.until(ExpectedConditions.visibilityOf(footerLinksContainer));
        return footerLinksContainer.findElements(By.tagName("a"));
    }

    public void printLinksText() {
        for (WebElement link : getFooterLinks()) {
            System.out.println(link.getText());
        }
    }
}
