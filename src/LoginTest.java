import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class LoginTest extends Utility{

    // Declare Web driver global variable


    @Before
    public void openBrowser(){
        // Open chrome browser
        String baseUrl = "https://demo.nopcommerce.com//";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(2000, 0));//display into second screen
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }



    @Test
    public void verifyUserShouldNavigateToLoginPage(){
        // Finding the login link element and click on login link element
        /*WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();*/
        clickOnElement(By.linkText("Log in"));
        // Finding the Welcome text element
//        WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        // This is expected text from Requirement
        String expectedText = "Welcome, Please Sign In!";
        // Get text from Welcome text element from web site
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        // verifying actualText and expectedText
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyErrorMessageWhenWrongUserNameIsEntered() throws InterruptedException {
        // Finding the login link element and click on login link element
        /*WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();*/
        clickOnElement(By.linkText("Log in"));
        // Thread.slip method used for hold execution
        Thread.sleep(1000);
        // Finding the emailField element
        /*WebElement emailField = driver.findElement(By.id("Email"));
        // Send email address to emailField element
        emailField.sendKeys("abc@gmail.com");*/
        sendTextToElement(By.id("Email"), "abc@gamil.com");

        // Finding the passwordField element
      /*  WebElement passwordField = driver.findElement(By.name("Password"));
        // Send password to passwordField element
        passwordField.sendKeys("Abc123");*/
        sendTextToElement(By.name("Password"), "Abc123");


        //Finding the login button element
       /* WebElement loginBtn =driver.findElement(By.xpath("//input[@value='Log in']"));
        // Clicking on login button element
        loginBtn.click();*/
        clickOnElement(By.xpath("//input[@value='Log in']"));
        //Finding element of error message
//        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        //        // This is expected message from Requirement
        String expectedErrorMessage ="Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        // This is actual error message from web site
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        // Asserting expectedMessage and actualMessage
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        // Closing the browser
        driver.quit();
    }
}
