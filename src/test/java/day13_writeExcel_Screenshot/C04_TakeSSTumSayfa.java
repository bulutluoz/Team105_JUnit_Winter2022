package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeSSTumSayfa extends TestBase {

    @Test
    public void test01(){

        // wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittiginizi test edin
        String expectedUrl="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaScreenshotCek(driver);
    }
}
