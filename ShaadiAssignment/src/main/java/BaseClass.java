import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseClass {


    @Test
    public static void initializeBrowser() {

        System.setProperty("webdriver.chrome.driver", "//home//vikaspandit//Documents//chromedriver_linux64//chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.marathishaadi.com/");
        driver.findElement(By.xpath("//button[@data-testid=\'lets_begin\']")).click();

        driver.findElement(By.xpath("//input[@data-testid='email']")).sendKeys("shaddiassignment@gmail.com");

        driver.findElement(By.xpath("//input[@data-testid='signup_password']")).sendKeys("Shaadi@1234");

        driver.findElement(By.xpath("//div[@class='Dropdown-control postedby_selector']")).click();


        driver.findElement(By.xpath("//div[contains(text(),'Daughter')]")).click();


        driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

        String community = driver.findElement(By.xpath("(//div[contains(text(),'Marathi')])[2]")).getText();


        Assert.assertEquals(community, "Marathi");

        driver.quit();


    }


}
