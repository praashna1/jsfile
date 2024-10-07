import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class SeleniumTest {

    public static ChromeOptions options;
    public static WebDriver driver ;

    @BeforeTest
    public static void Setup()  {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }

    @Test
    void testsuite() throws InterruptedException, SQLException {
        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click(); //for clicking the element
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click(); //xpath is where element is exactly placed

        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("sa"); //a input field so using sendkeys
        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("sa");

        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));

        String actualFirstCategory = webElement.getText();  //gets xpath and store in string

        String expectedFirstCategory = "Formal Shoes";

        Assert.assertEquals(expectedFirstCategory, actualFirstCategory );  //asserts are validation or checkpoints for an application
        driver.close();


    }

}
