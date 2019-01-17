package pageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuit extends BaseTest
{
    RegistrationPage registrationPage = new RegistrationPage();
    ProductPage productPage = new ProductPage();
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    LogInPage logInPage = new LogInPage();

    private final static String expectedRegisterMessage = "Your registration completed";
    private final static String expectedEmailSentMessage = "Your message has been sent.";
    private final static String expectedEmailNotSentMessage = "Only registered customers can use email a friend feature";
    private final static String expectedOrderSuccessfulMessage = "Your order has been successfully processed!";
    private final static String expectedTermsAndConditionsMessage = "Please accept the terms of service before the next step.";

@Test
    public void userShouldBeRegisterSuccessfully()
    {
       registrationPage.toRegister();
       String actualRegisterMessage = getText(By.xpath("//div[@class='result']"));
       Assert.assertEquals("Test case scenario user should be able to register successfully is failed",expectedRegisterMessage,actualRegisterMessage);
    }

@Test
   public void registeredUserShouldBeAbleToSendEmailToFriend()
   {
       registrationPage.toRegister();
       productPage.toSendEmailWithProduct();
       String actualEmailSentMessage = getText(By.xpath("//div[@class='result']"));
       Assert.assertEquals("Test case scenario registered user should be able to send an email to friend is failed",expectedEmailSentMessage,actualEmailSentMessage);
   }

@Test
   public void unregisteredUserShouldNotBeAbleToSendEmailToFriend()
   {
       productPage.toSendEmailWithProduct();
       String actualEmailNotSentMessage = getText(By.xpath("//li[contains(.,'Only registered customers can use email a friend feature')]\n"));
       Assert.assertEquals("Test case scenario unregistered user should not be able to send an email is failed",expectedEmailNotSentMessage,actualEmailNotSentMessage);
   }

@Test
    public void userShouldBeAbleToSortByPriceHighToLow()
    {
        homePage.clickOnNotbooks();
        productPage.productSortByHighToLow();
    }

@Test
    public void registeredUserShouldAbleToPurchaseAProduct()
    {
        logInPage.toLogIn();
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage.acceptTermsAndConditions();
        shoppingCartPage.clickOnCheckOut();
        checkOutPage.toPurchase();
        String actualOrderSuccessfullMessage = getText(By.xpath("//strong[contains(.,'Your order has been successfully processed!')]"));
        Assert.assertEquals("Test case scenario to place an order successfully is failed",expectedOrderSuccessfulMessage,actualOrderSuccessfullMessage);
    }

@Test
    public void userShouldNotBeAbleToProceedToCheckoutWithoutAgreeingTermAndConditions()
    {
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckOut();
        String actualTermsAndConditionsMessage = getText(By.xpath("//div[@id='terms-of-service-warning-box']/p"));
        Assert.assertEquals("Test case scenario user should not be able to procced without agreeing to Terms and conditions is failed",expectedTermsAndConditionsMessage,expectedTermsAndConditionsMessage);
    }

@Test
    public void verifyAddToCartButtonIsPresentForAllProductsOnHomepage()
    {
//        List<WebElement> allProducts = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div/div/div[2]/div[3]/div[2]/input[1]"));
//        //toFindList(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div/div/div[2]/div[3]/div[2]/input[1]"));
//        for (WebElement text:allProducts)
//        {
//            System.out.println(text.getAttribute("value"));
//        }
//        toGetTextOfElements(By.xpath("\"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div/div/div[2]/div[3]/div[2]/input[1]\""),"value");
//        System.out.println("Value");
    }

@Test
    public void userShouldBeAbleToChangeCurrencyToEuroOnJewelryPage()
    {
        homePage.clickOnJewelry();
        homePage.changeCurrencyToEuro();
    }

@Test
    public  void userShouldBeAbleYoChangeCurrencyToUSDollarOnJewelryPage()
    {
        homePage.clickOnJewelry();
        homePage.changeCurrencyToDollar();
    }
}
