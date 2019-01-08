package pageObjectModel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    RegistrationPage registrationPage = new RegistrationPage();
    ProductPage productPage = new ProductPage();
    HomePage homePage = new HomePage();
    ShoppinCartPage shoppinCartPage = new ShoppinCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

@Test
    public void userShouldBeRegisterSuccessfully()
    {
       registrationPage.toRegister();
    }

@Test
   public void registeredUserShouldBeAbleToSendEmailToFriend()
   {
       registrationPage.toRegister();
       productPage.toSendEmailWithProduct();
   }

@Test
   public void unregisteredUserShouldNotBeAbleToSendEmailToFriend()
   {
       productPage.toSendEmailWithProduct();
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
        homePage.clickOnRegister();
        registrationPage.toRegister();
        clickElement(By.xpath("//input[@name='register-continue']"));
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        waitForElementToBeClickable(By.xpath("//*[@id=\"termsofservice\"]"),20);
        clickElement(By.xpath("//*[@id=\"termsofservice\"]"));
        shoppinCartPage.clickOnCheckOut();
        checkOutPage.toPurchase();
    }

@Test
    public void userShouldNotBeAbleToProceedToCheckoutWithoutAgreeingTermAndConditions()
    {
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        shoppinCartPage.clickOnCheckOut();
    }
}
