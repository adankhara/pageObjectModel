package pageObjectModel;

import org.openqa.selenium.By;

public class ProductPage extends Utils {
    RegistrationPage registrationPage = new RegistrationPage();

    public void toSendEmailWithProduct() {


//   1. To select a products
        hoverAndClick(By.linkText("Computers"), By.linkText("Desktops"));
//   2. To click on products
        clickElement(By.linkText("Build your own computer"));
//   3.	Click on Email a friend.
        clickElement(By.xpath("//input[contains(@onclick,'/productemailafriend/1')]\n"));
//   4.	Enter your friend’s email in Friend’s Email field.
        enterText(By.id("FriendEmail"), "test123@yahoo.com");
//   5. Enter your email address
        //getTextFromBox(By.xpath("//input[@id='YourEmailAddress']\n"),"type");
        String s1 = (getTextFromBox(By.xpath("//input[@id='YourEmailAddress']\n"), "value"));
        if (s1.isEmpty()) {
            enterText(By.xpath("//input[@id='YourEmailAddress']\n"), "test4343@gmail.com");
        }
//   6.	Enter personal message in personal message field.
            enterText(By.id("PersonalMessage"), "Look at this product.");
//   7.	Click on send email button.
            clickElement(By.xpath("//input[@name='send-email']"));
    }

    public void productSortByHighToLow()
    {
        selectByVisibleText(By.id("products-orderby"),"Price: High to Low");
    }

    public void addToCart()
    {
//   1.	Click on product(Build your computer).
        clickElement(By.linkText("Build your own computer"));
//   2. Select hdd.
        clickElement(By.id("product_attribute_3_6"));
//   3. Click on add to cart button.
        clickElement(By.id("add-to-cart-button-1"));
    }
}
