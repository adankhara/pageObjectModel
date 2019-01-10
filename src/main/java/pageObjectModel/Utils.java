package pageObjectModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils extends BasePage
{
    //to click on element
    public static void clickElement(By by)
    {
        driver.findElement(by).click();
    }
    // to enter text
    public static void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // To clear and enter text
    public static void clearAndEnter(By by,String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    // select from visible text
    public static void selectByVisibleText(By by, String text)
    {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    //Select from index
    public static void selectByIndex(By by, int number)
    {
        new Select(driver.findElement(by)).selectByIndex(number);
    }
    //Select from value
    public static void selectByValue(By by, String text)
    {
        new Select(driver.findElement(by)).selectByValue(text);
    }
    //To get plain text from
    public static String getText(By by)
    {
        driver.findElement(by).isDisplayed();
        return driver.findElement(by).getText();
    }
    // To get text from input box or text box
    public static String getTextFromBox(By by,String text)
    {
        driver.findElement(by).isDisplayed();
        return driver.findElement(by).getAttribute(text);
    }
    // To get text from list of  element

    //To generate timestamp
    public static String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    // Wait for element and click
    public static void waitAndClick(By by , int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        driver.findElement(by).click();
    }
    //    wait for element to invisible
    public static void waitForElementToBeInvisible(By by,int time)
    {
       WebDriverWait wait = new WebDriverWait(driver,time);
       wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
     }
    // Wait for element to be visible
    public static void waitForElementToBeVisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //wait for element to be clickable
    public static void waitForElementToBeClickable(By by, int time){

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
    // To check element is present on web page
    public static boolean elementIsDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }
    // To check element is enable on web page
    public static boolean elementIsEnabled(By by)
    {
        return driver.findElement(by).isEnabled();
    }
    //To check element is selected
    public static boolean elementIsSelected(By by)
    {
        return driver.findElement(by).isSelected();
    }
    //To do hoover effect
    public static void hoverAndClick(By by1, By by2)
    {
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(by1);
        action.moveToElement(webElement).perform();
        clickElement(by2);
    }

    public static void toFindNumersOfElements(By  by)
    {
         driver.findElements(by).size() ;
    }

    public static String toGetTextOfElements(By by, String text1)
    {
        List<WebElement> allProducts = driver.findElements(by);
        for (WebElement text:allProducts)
        {
            text.getAttribute(text1);
        }
        return text1;
    }

}
