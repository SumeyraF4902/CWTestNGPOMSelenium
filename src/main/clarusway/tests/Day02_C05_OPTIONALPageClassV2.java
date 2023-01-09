package clarusway.tests;

import clarusway.pages.AmazonHomePageV1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_C05_OPTIONALPageClassV2 {



        /*
        pageObject model kullandinmi nasil kullandin  neden kullandin diye sorarlarsa;
        pageObject model ; sayfalarimizin locate lerini bir arada tutmamizi saglayan bir konseptir
         kod tekrarini azaltma , okunabilirliigini attirma
         bakim maliyetini dusurmek adina kullanilir,
         Locaterlar tek elle tutulacagindan,
         ve herhangi bir degisiklikte tek bir classtaki degisiklik tum classlarimizida  etkileyeceginden,
          ve page objelerimizle yani sayfalardaki webelementlerlerimizle test methodlari arasinda bir ayrim olacagindan bakimi, okunabilirligi cok daha kolaydir
        bir dizayn patterdir
         */
        @Test
        public void test() {

// Driver objemiz static degil ise bu driver objemizi page class imizda kullanmak adina constructor kullaniriz
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.amazon.com.tr/");


            // Driver objemiz static degil ise bu driver objemizi page class imizda kullanmak adina constructor kullaniriz
            AmazonHomePageV1 homePage = new AmazonHomePageV1(driver);

            homePage.searchFor("modem"); //methodla direl sendkeys yapildi

            homePage.navigateToOrders();



        }
    }

