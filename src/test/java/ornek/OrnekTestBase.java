package ornek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class OrnekTestBase extends TestBase {
    @Test
    public void yanlisEmailTesti() throws InterruptedException {

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("mehmet@abc.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("Az.123123123");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));

        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());

        Thread.sleep(3000);
    }

    @Test
    public void yanlisPasswordTesti() throws InterruptedException {

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("a@a.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("123456");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));

        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());

        Thread.sleep(3000);
    }

    @Test
    public void yanlisUsernameYanlisPasswordTesti() throws InterruptedException {

        driver.get("https://www.qualitydemy.com/");
        WebElement ilkLoginLinki= driver.findElement(By.xpath("//*[text()='Log in']"));
        ilkLoginLinki.click();

        WebElement kullaniciEmailKutusu= driver.findElement(By.id("login-email"));
        kullaniciEmailKutusu.sendKeys("abc@gmail.com");

        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys("123456");

        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));

        Assert.assertTrue(kullaniciEmailKutusu.isDisplayed());

        Thread.sleep(3000);
    }
}
