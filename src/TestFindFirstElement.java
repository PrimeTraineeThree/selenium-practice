import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class TestFindFirstElement {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "https://demo.nopcommerce.com//";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2000, 0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc@yehoo.com");

        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Abc123");

        WebElement loginBtn =driver.findElement(By.xpath("//input[@value='Log in']"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        System.out.println(errorMsg.getText());

        /*WebElement searchStore = driver.findElement(By.id("small-searchterms"));

        searchStore.sendKeys("Computer");*/
    }
}
