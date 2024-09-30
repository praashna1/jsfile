import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SeleniumTest {
   public  static  ChromeOptions options;
public static WebDriver  driver;

    @BeforeTest
   public static void setup(){

        options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver =new ChromeDriver(options);
        driver.get("https://english.onlinekhabar.com/90s-popular-candies-childhood.html ");
    }
    @Test
    void test(){
        driver.findElement(By.xpath("//*[@id=\"page\"]/header/div[1]/div/div[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[4]/a")).click();
    }
}
