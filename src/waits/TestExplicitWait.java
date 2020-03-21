package waits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jay
 */
public class TestExplicitWait {

    private String baseUrl = "https://letskodeit.teachable.com/pages/practice";
    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000,0));//display 2
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void implicitWaitExample(){
        By loginLink = By.linkText("Login");

        WebDriverWait wait = new WebDriverWait(driver, 3);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        element.click();

        driver.findElement(By.id("user_email")).sendKeys("test");
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
