import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebsiteTest {

    public static WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.daraz.com.np/");

    }

    @Test
    public void searchAndAddToCart() throws InterruptedException {
        WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='q']")));
        searchBox.sendKeys("laptop");  // search
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='search-box__button--1oH7']"));
        searchButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[1]/div/a/div/img"));
        firstProduct.click();
        Thread.sleep(300);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"module_add_to_cart\"]/div/button[2]/span/span"));
        addToCartButton.click();
        Thread.sleep(300);


    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
