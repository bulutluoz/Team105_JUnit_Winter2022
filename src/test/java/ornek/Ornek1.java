package ornek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class Ornek1 {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin



    @Test
    public void yanlisEmailTesti() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("mehmet@abc.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("Az.123123123");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));
        loginButonu.click();

        Thread.sleep(1000);
        kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());


        driver.close();
    }

    @Test
    public void yanlisPasswordTesti() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("a@a.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("123456");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));
        loginButonu.click();

        Thread.sleep(1000);
        kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());


        driver.close();
    }

    @Test
    public void yanlisUsernameYanlisPasswordTesti() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("abc@gmail.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("123456");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));
        loginButonu.click();

        Thread.sleep(1000);
        kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());


        driver.close();
    }

}
