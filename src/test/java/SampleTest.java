import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class SampleTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sampleTest() {

        RahulPage rahulPage = new RahulPage();
        PageFactory.initElements(driver, rahulPage);

        driver.navigate().to("https://rahulshettyacademy.com/client");
        rahulPage.emailField.sendKeys("testem@gmail.com");
        rahulPage.passwordField.sendKeys("Testpass1");
        rahulPage.loginButton.click();


        List<WebElement> products = driver.findElements(By.xpath("//div[contains (@class, 'col-lg-4')]"));
        WebElement product = products.stream().filter(p -> p.findElement(By.tagName("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);

//        rahulPage.addProductToCart(product);
//        rahulPage.waitForAlert();
//        rahulPage.goToCart();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
//        rahulPage.checkout();
    }
}
