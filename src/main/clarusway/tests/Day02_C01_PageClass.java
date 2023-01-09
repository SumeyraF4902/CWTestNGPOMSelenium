package clarusway.tests;
import clarusway.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Day02_C01_PageClass {// driveri class olarak kullandigimiz icin exdent etmedik  bu sayfayi page class olmadan yaptik
/*
Navigate to https://www.saucedemo.com/
Enter the user name as standard_user
Enter the password as secret_sauce
Click on login button.
- Choose price low to high with soft Assert.
- Verify item prices are sorted from low to high with hard Assert.

https://www.saucedemo.com/ adresine gidin
Kullanıcı adını standard_user olarak girin
şifreyi secret_sauce olarak girin
Giriş düğmesine tıklayın.
- Yumuşak Assert ile fiyatı düşükten yükseğe seçin.
- Hard Assert ile ürün fiyatlarının düşükten yükseğe doğru sıralandığını doğrulayın.
 */


        @Test
        public void test(){
            //Navigate to https://www.saucedemo.com/
            Driver.getDriver().get("https://www.saucedemo.com/");// driveri classdan cagirdik get methoduyla
            //Enter the user name as standard_user
            WebElement username = Driver.getDriver().findElement(By.id("user-name"));
            username.sendKeys("standard_user");
//        Enter the password as secret_sauce
            WebElement password = Driver.getDriver().findElement(By.id("password"));
            password.sendKeys("secret_sauce");
//        Click on login button.
            WebElement loginButton = Driver.getDriver().findElement(By.id("login-button"));
            loginButton.click();

//        - Choose price low to high. dusukten yuksege sıralama secenegi
            Select dropdown = new Select(Driver.getDriver().findElement(By.tagName("select")));
            dropdown.selectByValue("lohi");//usukten yuksege sıralama seceneginin valuesi


//        - Verify item prices are sorted from low to high with hard Assert. fiyatların herbirini listeye ekledik
            List<WebElement> itemPrices = Driver.getDriver().findElements(By.className("inventory_item_price"));
            itemPrices.forEach(x-> System.out.println(x.getText()));//her urunun fiyat,n, yazdirdi

            List<Double> urunFiyatlari = itemPrices.stream()
                    .map(x -> x.getText().substring(1))      //ilk indexden itibaren al $ isaretinden kurtulduk $ isareti 0 indexteydi biz onun icin 1. indexden itibaren aldik
                    .map(x -> Double.parseDouble(x))// $ isaretinden kurtulduktan sonra dobule cevirdik
                    .collect(Collectors.toList());// liste haline getirdik

            for (int i = 0; i < urunFiyatlari.size()-1; i++) {//son indexte hata almamak icin -1 i yazdik

                Assert.assertTrue(urunFiyatlari.get(i) <= urunFiyatlari.get(i+1));//urunler kucukten buyuge mi siralanmiz kontrolu yapiliyor
            }

            Driver.closeDriver();


        }

}
