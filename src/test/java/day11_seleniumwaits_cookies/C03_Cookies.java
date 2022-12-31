package day11_seleniumwaits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti= driver.manage().getCookies();
        int siraNo=1;
        for (Cookie eachCookie:cookiesSeti
             ) {
            System.out.println(siraNo +"- " + eachCookie);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieDegeri="USD";
        String actualCookieDegeri="";
        for (Cookie eachCookie:cookiesSeti
        ) {

            if (eachCookie.getName().equals("i18n-prefs")){
                actualCookieDegeri=eachCookie.getValue();
            }

        }

        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin

        Cookie benimCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);

        cookiesSeti= driver.manage().getCookies();
        siraNo=1;
        for (Cookie eachCookie:cookiesSeti
        ) {
            System.out.println(siraNo +"- " + eachCookie);
            siraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        expectedCookieDegeri="cikolatali";
        actualCookieDegeri="";
        for (Cookie eachCookie:cookiesSeti
        ) {

            if (eachCookie.getName().equals("en sevdigim cookie")){
                actualCookieDegeri=eachCookie.getValue();
            }

        }

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");

        cookiesSeti= driver.manage().getCookies();
        int skinCookieSayisi=0;
        for (Cookie eachCookie:cookiesSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinCookieSayisi++;
            }

        }

        Assert.assertEquals(0,skinCookieSayisi);


        //8- tum cookie’leri silin ve silindigini test edin


        driver.manage().deleteAllCookies();
        cookiesSeti= driver.manage().getCookies();

        Assert.assertEquals(0,cookiesSeti.size());

    }
}
