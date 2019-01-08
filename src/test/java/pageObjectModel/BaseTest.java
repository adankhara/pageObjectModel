package pageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils
{
    @BeforeMethod
     public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
    }
//    @AfterMethod
//     public void tearDown()
//    {
//        driver.quit();
//    }
}
