import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class HomeWorkTest {
    WebDriver driver;

    @Before
    public void openBrowser() {

        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToBooksPage() {
        WebElement booksLink = driver.findElement(By.linkText("Books"));
        booksLink.click();

        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1"));
        String expectedText = "Books";
        String actualText = welcomeMessage.getText();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Expected Result : "+ expectedText);
        System.out.println("Actual Result : "+ actualText);

    }

    @Test
    public void booksPage() {

        WebElement books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        books.click();

        WebElement sortBy = driver.findElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        sortBy.click();

        // Obtaining the array list of all the book items thru its weblink text and printing it.
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.tagName("h2"));
        for (WebElement links : elementList) {
            obtainedList.add(links.getText());
        }

        // Using sorting and collection method to assert the obtained list and the sorted list
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(obtainedList);
        Collections.sort(sortedList);
        Assert.assertEquals(sortedList, obtainedList);
        System.out.println("Obtained Product List :" + obtainedList);   // printing the list of items
        System.out.println("Sorted Product list :" + sortedList);
    }
    @Test
    public void showWishList() {
        WebElement books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        books.click();

        WebElement sortBy = driver.findElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        sortBy.click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@name='products-orderby']"));
        dropDown.click();

        WebElement wishList = driver.findElement(By.xpath(" //div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        wishList.click();

        WebElement wishListText = driver.findElement(By.xpath("//p[@class='content']"));
        String expectedText = "The product has been added to your wishlist";
        String actualText = wishListText.getText();
        Assert.assertEquals(expectedText, actualText);
        System.out.println(wishListText.getText());
    }


    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
