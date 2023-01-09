package clarusway.tests;

import clarusway.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class deneme {
    @Test
    public void testDeneme() {
        Driver.getDriver().get("https://www.saucedemo.com/");
        WebElement username=Driver.getDriver().findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password=Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement submit=Driver.getDriver().findElement(By.id("login-button"));
        submit.click();

        Select select=new Select(Driver.getDriver().findElement(By.tagName("select")));
        select.selectByValue("lohi");

        List<WebElement> list=Driver.getDriver().findElements(By.className("inventory_item_price"));
        list.forEach(x-> System.out.println(x.getText()));//

    }


}
