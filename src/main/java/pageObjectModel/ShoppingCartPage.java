package pageObjectModel;

import org.openqa.selenium.By;

public class ShoppingCartPage extends Utils
{
    HomePage homePage = new HomePage();
    public void clickOnCheckOut()
    {
//   1. To click on shopping cart
//        homePage.clickOnShoppingCart();
//   2. To click on check out button
        clickElement(By.id("checkout"));
    }

    public void acceptTermsAndConditions()
    {
//   1. To click on shopping cart
//        homePage.clickOnShoppingCart();
//   2. To accept terms and conditions
        clickElement(By.xpath("//*[@id=\"termsofservice\"]"));
    }
}
