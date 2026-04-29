import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XKomTest {

    private WebDriver driver;
    private XKomPage xkomPage;

    @DataProvider(name = "LoginData")
    public Object[][] getDataFromProvider() {
        return new Object[][]{
                {"test", "user"},
                {"test2", "password"}
        };
    }

    // Metoda pomocnicza do tworzenia drivera z opcjonalnym trybem headless
    private void setupDriver(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-gpu");
        }
        driver = new ChromeDriver(chromeOptions);
        if (!headless) {
            driver.manage().window().maximize();
        }
        xkomPage = new XKomPage(driver);
    }

    @Test
    public void shouldSearchAndGetProductPrice() {
        // Ten test odpalamy w trybie NORMALNYM (okienkowym)
        setupDriver(false); 
        
        String price = xkomPage.open(BasePage.url)
                .acceptCookies()
                .searchForProduct("Iphone 17 Pro")
                .clickProduct()
                .getProductPrice();

        System.out.println("Cena to: " + price);
        Assert.assertNotNull(price, "Cena nie powinna być nullem");
    }

    @Test
    public void shouldGetFooterLinks() {
        try {
            setupDriver(true);
            xkomPage.open(BasePage.url).acceptCookies().getFooterLinks();
            System.out.println("Liczba linków na stronie: " + xkomPage.getFooterLinks().size());
            xkomPage.printLinksText();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test(dataProvider = "LoginData")
    public void shouldLogin(String username, String password) {
        setupDriver(true);
        System.out.println(username + " " + password);
    }

    // Zmiana na @AfterMethod - driver jest zamykany po KAŻDYM teście
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
