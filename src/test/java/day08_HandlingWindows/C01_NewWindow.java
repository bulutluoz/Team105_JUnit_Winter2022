package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*
        Selenium 4 ile windows konusunda yeni bir ozellik geldi

        Istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
        Bu durumda driver'imiz da otomatik olarak yeni sayfaya gecmis olur.

        Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa
        o sayfada iken o sayfanin window Handle Degeri alinip kaydedilir
        ve o sayfaya gecemek istendiginde
        driver.switchTo().window(istenenSayfaninWindowHanleDegeri)
        kodu ile o sayfaya gecis yapilir.

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        // Testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        // amazon sayfasindayken bu window'un window handle degerini alip kaydetmeliyiz
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve gittigimizi test edin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime ="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

        // wisequarter testini yaptiktan sonra
        // yeniden amazon'un acik oldugu tab'a gecin
        // ve amazon anasayfanin acik oldugunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);
        actualUrl= driver.getCurrentUrl();
        expectedKelime ="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);
    }
}
