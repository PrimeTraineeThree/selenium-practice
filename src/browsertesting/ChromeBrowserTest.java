package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static browsertesting.MultiBrowserTest.driver;

/**
 * Created by Jay
 */
public class ChromeBrowserTest {

    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "https://timesofindia.indiatimes.com/poll.cms";

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000,0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement yesPollbutton = driver.findElement(By.xpath("//input[@class=\"radio1\"]"));
        yesPollbutton.click();

        String mathquestionvalue = driver.findElement(By.xpath("//span[@id='mathq2']")).getText().trim();

        // remove space if exist
        String removespace = mathquestionvalue.replaceAll("\\s+", "");
        // get two numbers
        String[] parts = removespace.split("\\+");
        String part1 = parts[0];
        String part2 = parts[1];
        String[] parts1 = part2.split("=");
        String part11 = parts1[0];
        // sum two numbers
        int summation = Integer.parseInt(part1) + Integer.parseInt(part11);
        // Math Captcha value

        WebElement captcha = driver.findElement(By.xpath("//input[@id=\"mathuserans2\"]"));
        captcha.clear();
        captcha.sendKeys(""+summation);

//        WebElement voteButton = driver.findElement(By.xpath("//div[@class=\"homesprite vot\"]"));
//        voteButton.click();
    }




}
