package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    // 3 farkli test method'u olusturun
    // her bir method'un basinda driver'i olusturup
    // 1- amazon.com
    // 2- wisequarter.com
    // 3- youtube.com'a gidip
    // title'lari yazdirin ve method'dan sonra driver'i kapatin
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("setUp method'u calisti");
    }

    @After
    public void tearDown(){
        System.out.println("teardown method'u calisti");
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
}
