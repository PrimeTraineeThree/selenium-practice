package selectclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class TestDropDown {

    private String baseUrl = "https://letskodeit.teachable.com/p/practice";
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
    public void dropDownExample() throws InterruptedException {

        WebElement dropDown = driver.findElement(By.id("carselect"));

        Select select = new Select(dropDown);

        select.selectByVisibleText("Benz");

        Thread.sleep(3000);

        select.selectByValue("honda");

        List<WebElement> options = select.getOptions();
        for (WebElement element :options ) {
            System.out.println( element.getText());
        }


    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


//    @Test
//    public void testDropdown() throws Exception {
//        driver.get(baseUrl);
//        WebElement element = driver.findElement(By.id("carselect"));
//        Select sel = new Select(element);
//
//        Thread.sleep(2000);
//        System.out.println("Select Benz by value");
//        sel.selectByValue("benz");
//
//        Thread.sleep(2000);
//        System.out.println("Select Honda by index");
//        sel.selectByIndex(2);
//
//        Thread.sleep(2000);
//        System.out.println("Select BMW by visible text");
//        sel.selectByVisibleText("BMW");
//
//
//        Thread.sleep(2000);
//        System.out.println("Print the list of all options");
//        List<WebElement> options = sel.getOptions();
//        int size = options.size();
//
//        for (int i=0; i<size; i++) {
//            String optionName = options.get(i).getText();
//            System.out.println(optionName);
//        }
//    }

}
