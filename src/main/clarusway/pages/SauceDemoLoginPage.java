package clarusway.pages;

import clarusway.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoLoginPage {


    //init elements methodu O-Page class i initalize etmek adina kullanilir
    public SauceDemoLoginPage(){// parametresiz constuctor  (class ismiyle ayni ismi alan method demek

        PageFactory.initElements(Driver.getDriver(),this);// init elementler :driver ve clasimizin kendisi (this bu sayfa demek)
    }

    //@FindBy anatasyonu elementleri locate ederken kullandigimiz ve initElements methodu ile elementlerin bulunmasini saglayan bir anotasyondur

    //pageclasimizda her bir elementler field, aksiyonlar methoda denk gelir.
    @FindBy(id="user-name")// page classa entegre etmek icin kullanilir. FindBy(ANATASYONU)= bunlari id si ile mi xpathi ilemi nasil bulacağimizi soyleyen ANATASYONDUR,
    public WebElement txtUsername;// bunlar fielddir.  basına yada sonuna txt konur : bu alanin text alanimi button mu oldugunu anlamak icin kullanilir

    @FindBy(id="password")
    public WebElement txtPassword;// bunlar fielddir.  basına yada sonuna txt konur : bu alanin text alanimi button mu oldugunu anlamak icin kullanilir

    @FindBy(xpath="//*[@id='login-button']")
    public WebElement btnLogin;// bunlar fielddir.  basına yada sonuna btn konur : bu alanin text alanimi button mu oldugunu anlamak icin kullanilir

    //Ornek olmasi acisindan  @FindAll anatotion kullanimi. Page classtan bagimzsizdir.
    @FindAll(
            {
                    @FindBy(id="user-name"),
                    @FindBy(id="password")  ,
                    @FindBy(xpath="//*[@id='login-button']")
            }
    )
    public List<WebElement> inputElements;
}
