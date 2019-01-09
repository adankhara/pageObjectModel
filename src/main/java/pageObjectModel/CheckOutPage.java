package pageObjectModel;

import org.openqa.selenium.By;

public class CheckOutPage extends Utils
{
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
   public void toPurchase()
   {
//  1. To accept terms and conditions
//       shoppingCartPage.acceptTermsAndConditions();
//  2. Click on check out
//       shoppingCartPage.clickOnCheckOut();
//  3. Click on continue.
       clickElement(By.xpath("//input[@onclick='Billing.save()']"));
//  4. Select shipping speed as "Next day Air".
       clickElement(By.id("shippingoption_1"));
//  5. Click on continue.
       clickElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']"));
//  6. Select Credit card as payment option.
       clickElement(By.id("paymentmethod_1"));
//  7. Click on continue
       clickElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
//  8. Enter card holder's name
       enterText(By.id("CardholderName"),"Rajesh Parekh");
//  9. Enter card number
       enterText(By.id("CardNumber"),"4111 1111 1111 1111");
//  10.Select card expiry date
       selectByValue(By.id("ExpireMonth"),"2");
       selectByValue(By.id("ExpireYear"),"2021");
//  11.Enter card cvv code.
       enterText(By.id("CardCode"),"737");
//  12.Click on continue
       clickElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
//  13.Click on confirm order.
       clickElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
   }

}
