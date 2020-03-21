package stateofelement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class TestIsElementSelected {

    private String baseUrl = "https://learn.letskodeit.com/p/practice";
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        driver.manage().window().setPosition(new Point(-2000,0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void isElementDisplayedExample() throws InterruptedException {
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        // Added code to scroll up because the element was hiding behind the top navigation menu
        js.executeScript("window.scrollBy(0, -190);");
        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
