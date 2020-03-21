package actionclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class TestMouseOver {

    private String baseUrl = "https://letskodeit.teachable.com/p/practice";
    private WebDriver driver;
    private JavascriptExecutor jse;


    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000,0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        jse = (JavascriptExecutor) driver;


    }

    @Test
    public void mouseHoverExample() throws InterruptedException {

        jse.executeScript("window.scrollBy(0, 800)");

        WebElement mainElement = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainElement).perform();
        Thread.sleep(3000);
        WebElement subElement = driver.findElement(By.xpath("//a[contains(text(),'Top')]"));

        actions.moveToElement(subElement).click().perform();
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
