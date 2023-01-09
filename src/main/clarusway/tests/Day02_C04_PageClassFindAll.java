package clarusway.tests;

import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;

public class Day02_C04_PageClassFindAll {

    /* FİNDBy elementleri locate etmemizi saglayan anatasyondur
    @FindBy  -->Tekli kriter
    @FindBy(id ="A")
    private WebElement A; gibi


    @FindBys-->iki kriter --> iki sartıda saglamasi gerekir.  Webelement objelerinin verilen tum kriterlerle eslesmesi gerektiginde. javadaki  and operatoru gibi
    @FindBys({
    @FindBy(id ="A")  ,
    @FindBys(id ="B")}
    public WebElement AB; GİBİ

    @FindAll--> EN AZ BIR KRITER  java daki or operatoru gibi calisir

    @FindAll({
    @FindBy(id ="A")  ,
    ..........
    @FindBys(id ="B")}
    public  List<WebElement> AandB; GİBİ  Webelement objelerinin verilen kriterlerden enaz biriyle eslesmesi gerektiginde
     */

    @Test
    public void test() {

        Driver.getDriver().get("https://www.saucedemo.com/");

        SauceDemoLoginPage lp=new SauceDemoLoginPage();
        Assert.assertEquals(3,lp.inputElements.size());// 3 elemanlimi

        Driver.closeDriver();


      /*  eger birsey gondermek istersek username , listenin ilk elamani oldgu icin get(0) deriz
        lp.inputElements.get(0).sendKeys("sumeyra"); user name  sendkeys gonderebiliriz

*/
    }
}
