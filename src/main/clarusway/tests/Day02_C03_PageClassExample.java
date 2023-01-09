package clarusway.tests;

import clarusway.pages.HtmlGoodiesHomePage;
import clarusway.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

public class Day02_C03_PageClassExample {

    @Test
    public void test() {

        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        HtmlGoodiesHomePage hp=new HtmlGoodiesHomePage();

        Actions actions=new Actions(Driver.getDriver());//dragAndDrop ile işlem yapabilmek icin actionsdan obce olusturarak islem yaptik

        actions
                .dragAndDrop(hp.copenhag, hp.denmark)
                .dragAndDrop(hp.seoul, hp.sKorea)
                .dragAndDrop(hp.washington,hp.us)
                .dragAndDrop(hp.rome, hp.italy)
                .dragAndDrop(hp.madrid, hp.spain)
                .dragAndDrop(hp.oslo,hp.norway)
                .dragAndDrop(hp.stockholm,hp.sweden)
                .perform();


    }

}
