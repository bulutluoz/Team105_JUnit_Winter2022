package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //     ve  konsolda yazdirin.
        WebElement actualSayfaYazisiElementi= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(3000);
        //	- Text Box’a “Merhaba Dunya!” yazin.

        // normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        // yani elementi bulamadi
        // kontrol ederken istedigimiz webelement'in bir iframe icinde oldugunu gorduk
        // Bu durumda once o iframe'e switchTo() yapmaliyiz

        WebElement iframeWebElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframeWebElementi);

        WebElement yaziKutuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
        //    ve  konsolda yazdirin.

        // Iframe'in icine girdikten sonra, oradan cik denilinceye kadar
        // driver iframe'in icinde kalir
        // eger disina cikmak isterseniz

        //driver.switchTo().parentFrame(); // bulundugu iframe'den bir ust html sayfasina gecer
        // bu daha cok ic icice iframe'ler oldugunda tercih edilir
        driver.switchTo().defaultContent(); // anasayfaya gecis yapar

        WebElement elemantalSeleniumLinkElementi= driver.findElement(By.xpath("//div[text()='Powered by '] "));

        Assert.assertTrue(elemantalSeleniumLinkElementi.isDisplayed());
        System.out.println(elemantalSeleniumLinkElementi.getText());

    }


}
