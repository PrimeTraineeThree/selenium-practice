import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class BooksTest {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        // Open chrome browser
        String baseUrl = "https://demo.nopcommerce.com/books?orderby=0";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000, 0));//display into second screen
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test01() throws InterruptedException {

        List<String> booksNames = new ArrayList<>();

        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Name: Z to A");

        List<WebElement> booksList = driver.findElements(By.xpath("//div/div[2]/h2/a"));

        for (WebElement ele : booksList) {
            booksNames.add(ele.getText());
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll(booksNames);
        Collections.sort(tempList, Collections.reverseOrder());

        Assert.assertEquals(booksNames, tempList);


    }

    @Test
    public void test02() {

        List<String> booksPrice = new ArrayList<>();

        List<WebElement> books = driver.findElements(By.xpath("//div[3]/div[1]/span[2]"));
        for (WebElement ele : books) {
            booksPrice.add(ele.getText());
        }

        Collections.sort(booksPrice);
        Select select = new Select(driver.findElement(By.id("products-orderby")));
        select.selectByVisibleText("Price: Low to High");

        List<String> afterFilterPrice = new ArrayList<>();

        List<WebElement> books1 = driver.findElements(By.xpath("//div[3]/div[1]/span[2]"));
        for (WebElement ele : books1) {
            afterFilterPrice.add(ele.getText());
        }

        Assert.assertTrue(booksPrice.equals(afterFilterPrice));

    }

    @After
    public void closeBrowser() throws InterruptedException {
        // Closing the browser
        driver.quit();
    }

}
