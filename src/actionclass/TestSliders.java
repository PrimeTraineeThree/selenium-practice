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
public class TestSliders {

    private String baseUrl = "https://jqueryui.com/resources/demos/slider/default.html";
    private WebDriver driver;

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
    }

    @Test
    public void sliderExample(){

        WebElement mainSlider = driver.findElement(By.xpath("//div[@id='slider']"));

        int width = mainSlider.getSize().width;
        int halfWidth = width/2;


        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, halfWidth, 0).perform();

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}
