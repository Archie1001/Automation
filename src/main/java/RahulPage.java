import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RahulPage {

    WebDriver driver;

   @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

   @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

   @FindBy(id = "login")
    WebElement loginButton;

   @FindBy(xpath = "//div[@role='alert' and contains(text(), ' Product Added To Cart ')]")
    WebElement alertMessage;

   protected void waitForAlert(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       wait.until(ExpectedConditions.visibilityOf(alertMessage));
   }

}
