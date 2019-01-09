package pageObjectModel;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    HomePage homePage = new HomePage();

    public void toRegister()
    {
//   1. Click on Register button
        homePage.clickOnRegister();
//   2.	Select gender.
        clickElement(By.id("gender-male"));
//   3.	Enter your first name in First Name field.
        enterText(By.id("FirstName"),"Rajesh");
//   4.	Enter your last name in Last Name field
        enterText(By.id("LastName"),"Parekh");
//   5.	Select your date of birth.
        selectByIndex(By.xpath("//select[@name='DateOfBirthDay']\n"),20);
        selectByVisibleText(By.xpath("//select[@name='DateOfBirthMonth']\n"),"May");
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']\n"),"1980");
//   6.	Enter your email address in Email field.
        enterText(By.id("Email"),"rajeshparekh"+timeStamp()+"@yahoo.com");
//   7.	Enter your company name.
        enterText(By.id("Company"),"Parekh Ltd");
//   8.	Select/deselect Newsletter option.
        clickElement(By.id("Newsletter"));
//   9.	Enter password in Password field.
        enterText(By.id("Password"),"rajesh123");
//   10.Enter password in Confirm Password field.
        enterText(By.id("ConfirmPassword"),"rajesh123");
//   11.Click on Register button.
        clickElement(By.id("register-button"));
        //String actualRegisterMessage = getText(By.xpath("//div[@class='result']"));
//   12.Click on continue button.
//      clickElement(By.linkText("Log out"));
    }
}
