package pageObjectModel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    RegistrationPage registrationPage = new RegistrationPage();
    ProductPage productPage = new ProductPage();
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
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
        shoppingCartPage.clickOnCheckOut();
        checkOutPage.toPurchase();
    }

@Test
    public void userShouldNotBeAbleToProceedToCheckoutWithoutAgreeingTermAndConditions()
    {
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckOut();
    }
}
