package pageObjectModel;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    public void clickOnRegister()
    {
        clickElement(By.linkText("Register"));
    }

    public void clickOnComputers()
    {
       clickElement(By.linkText("Computers"));
    }

    public void clickOnNotbooks()
    {
        hoverAndClick(By.linkText("Computers"),By.linkText("Notebooks"));
    }

    public void clickOnShoppingCart()
    {
        clickElement(By.linkText("Shopping cart"));
    }

    public void clickOnLogIn()
    {
        clickElement(By.linkText("Log in"));
    }


}
