package pageObjectModel;

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
        logInPage.toLogIn();
        productPage.addToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage.acceptTermsAndConditions();
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

@Test
    public void verifyAddToCartButtonIsPresentForAllProductsOnHomepage()
    {
        List<WebElement> allProducts = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div/div/div[2]/div[3]/div[2]/input[1]"));
        for (WebElement text:allProducts)
        {
            System.out.println(text.getAttribute("value"));
        }
    }
}
