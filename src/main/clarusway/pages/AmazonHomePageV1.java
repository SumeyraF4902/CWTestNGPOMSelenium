package clarusway.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePageV1 {

    private WebDriver ldriver;//local driver kisaltilmasi ldriver

    public AmazonHomePageV1(WebDriver ldriver) {
        this.ldriver = ldriver;

        PageFactory.initElements(ldriver, this);
    }

    @FindBy(id = "twotabsearchtextbox")//search butonu
    WebElement txtSearch;

    @FindBy(id = "nav-link-accountList")//liste butonu
    WebElement accountAndList;

    @FindBy(id = "nav_prefetch_yourorders")//siparislerim butonu
    WebElement orders;

    public void searchFor(String key) {
        txtSearch.sendKeys(key + Keys.ENTER);
    }
        public void navigateToOrders(){//siparisler sayfasina git methodu
            Actions actions=new Actions(ldriver);
            actions.moveToElement(accountAndList).perform();//hesap ve listelerin uzerine gel dedik


            WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(orders)).click();//elementimin (yani siparislerim butonu gelene kadar)}} gorunur oldugu ana kadar bekle
    }



}
