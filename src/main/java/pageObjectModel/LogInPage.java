package pageObjectModel;

import org.openqa.selenium.By;

public class LogInPage extends Utils
{
    HomePage homePage = new HomePage();
    public void toLogIn()
    {
//   1. To click on Log in button
        homePage.clickOnLogIn();
//   2. Enter your registered email Id in email field.
        enterText(By.id("Email"),"rajesh.parekh123@gmail.com");
//   3.	Enter your password in password field.
        enterText(By.id("Password"),"rajesh9999");
//   4.	Click on Login button.
        clickElement(By.xpath("//input[@value='Log in']"));
    }


}
