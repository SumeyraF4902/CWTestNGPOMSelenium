package clarusway.tests;

import clarusway.pages.SauceDemoHomePage;
import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;


public class Day02_C02_PageClass {// bu classi pageclass olusturarak yaptik. kac sayfada calistiysak o kadar  pages klasorunde class olustururuz
    /*
    Day02_C01_PageClass clasinda iki sayfada islem yapmistik, simdi burani islemi page klosorunde sitenin ismi + page adinda iki class olusturarak islem yapıyoruz
     1-SauceDemoLoginPage
    2-SauceDemoHomePage

     */

    @Test
    public void pageClassTest(){
        //Navigate to https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");

        //Login sayfasinda yapilan aksiyonlar
        SauceDemoLoginPage loginPage=new SauceDemoLoginPage();//Conscacteri calistirmak icin obje uretmemiz gerekir.
        // SauceDemoLoginPage clasini kullanmak icin bu classtan obje ureterek islem yaptik

        loginPage.txtUsername.sendKeys("standard_user");

        loginPage.txtPassword.sendKeys("secret_sauce");

        loginPage.btnLogin.click();

        //Burada homepag e gecis yaptigimizdan dolayi homepage classimizdan obje uretiriz
        SauceDemoHomePage homePage=new SauceDemoHomePage();// obje urettik


        Select select=new Select(homePage.filterDropdown);//web element oldugu icin select objesine cevirdik cunkuu webelement uzerinden secme islemi yapamayiz
        select.selectByValue("lohi");// bu sekilde secme islemi gerceklestirdik

        System.out.println("\n\n\n\n\n\n");
        homePage.products.forEach(p -> System.out.println(p.getText()));// butun fiyatlari kucukten buyuge yazdirdi products methoduyla

        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("low to high"));

        Driver.closeDriver();

    }
}
