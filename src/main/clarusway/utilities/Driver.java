package clarusway.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {//singleton   tek deniyor

    private static WebDriver driver;//// static yaptık çünkü her classtan cagrilcak bu class icin kullanilacak driiver sayfasi static olacagi icin tum programda bu sayfa kullanilacak

    private Driver() {// Driver objesi oluşturduk

    }
    public static WebDriver getDriver(){

        if(driver == null){//driver yoksa driver obje olusturuyor

            String browser = ConfigReader.getProperty("browser");//browser bilgisi  propertyclasindan okunur
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
            //bu attakiler tum browserlar icin gecerli oldugu icin switchin  disina ifin icine yazdik
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
