package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class TestWebTable {
    public static void main(String[] args) {

        String baseUrl = "https://money.rediff.com/gainers/bsc/daily/groupa";

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver.manage().window().setPosition(new Point(-2000,0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");

        List<WebElement> rowNum = driver.findElements(By.xpath("//table[@id='product']//tbody/tr"));
        System.out.println("Total rows are : "+rowNum.size());

        List<WebElement> colNum = driver.findElements(By.xpath("//table[@id='product']//tbody/tr[2]/td"));

        System.out.println("Total cols are : " +colNum.size());

        for (int i = 2; i <=rowNum.size() ; i++) {
            for (int j = 1; j <colNum.size() ; j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id='product']//tbody/tr[" +i+"]/td["+j+"]")).getText()+" ");
            }
            System.out.println(" ");

        }

        /*List<WebElement> rowNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

        System.out.println("Total rows are : " + rowNum.size());

        List<WebElement> colNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));

        System.out.println("Total cols are : " + colNum.size());


        for(int rows=1; rows<=rowNum.size(); rows++) {

            for(int cols=1; cols<=colNum.size(); cols++) {


                System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"   ");


            }

            System.out.println();

        }*/

        driver.quit();


    }
}
