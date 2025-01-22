package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    public LoginPage clickLogin() {
        driver.findElement(By.id("header-account")).click();
        return this;
    }

    @Step ("E-mail alanı doldurulur")
     public LoginPage fillEmail(String text) {
         driver.findElement(By.id("header-email")).sendKeys(text);
         return this;
     }

    @Step ("Şifre alanı doldurulur")
     public LoginPage fillPassword(String text) {
        driver.findElement(By.cssSelector("#header-password")).sendKeys(text);
        return this;
    }

    @Step ("Beni Hatırla butonuna tıklanır")
    public LoginPage clickRememberMe() {
        driver.findElement(By.cssSelector(".input-checkbox")).click();
        return this;
    }

    @Step ("Giriş Yap butonuna tıklanır")
    public LoginPage clickLoginButton() {
        driver.findElement(By.cssSelector("[class='w-100 btn btn-primary text-uppercase']")).click();
        return this;
    }

    @Step ("Şifremi Unuttum butonuna tıklanır")
    public LoginPage forgotPasswordButton() {
        driver.findElement(By.xpath("//*[@id=\"header-member-panel-588\"]/div[2]/form/div/div[4]/a")).click();
        return this;
    }

    @Step ("E-mail alanı doldurulur")
    public LoginPage passwordEmail(String text) {
        driver.findElement(By.name("forgot-email")).sendKeys(text);
        return this;
    }

    @Step ("Şifremi Hatırlat butonuna tıklanır")
    public LoginPage forgotClick() {
        driver.findElement(By.id("forgot-password-btn-322")).click();
        return this;
    }

    @Step ("Kayıt Ol butonuna basılır")
    public LoginPage sigUpButton() {
        driver.findElement(By.xpath("//a[contains(text(),'Kayıt Ol')]")).click();
        return this;
    }

    @Step ("Ad alanı doldurulur")
    public LoginPage singUpName(String text) {
        driver.findElement(By.id("name")).sendKeys(text);
        return this;
    }

    @Step ("Soyad alanı doldurulur")
    public LoginPage singUpSurname(String text) {
        driver.findElement(By.id("surname")).sendKeys(text);
        return this;
    }

    @Step ("E-mail alanı doldurulur")
    public LoginPage singUpEmail(String text) {
        driver.findElement(By.id("email")).sendKeys(text);
        return this;
    }

    @Step ("İl bilgisi seçilir")
    public LoginPage cityClick() {
        WebElement dropdown = driver.findElement(By.id("city_code"));
        dropdown.findElement(By.xpath("//option[. = 'İl Seçiniz']")).click();
        WebElement dropdown2 = driver.findElement(By.id("city_code"));
        dropdown2.findElement(By.xpath("//option[. = 'İstanbul']")).click();
        return this;
    }

    @Step ("İlçe bilgisi seçilir")
    public LoginPage townClick() {
        WebElement dropdown = driver.findElement(By.id("town_code"));
        dropdown.findElement(By.xpath("//option[. = 'İlçe Seçiniz']")).click();
        WebElement dropdown2 = driver.findElement(By.id("town_code"));
        dropdown2.findElement(By.xpath("//option[. = 'Ümraniye']")).click();
        return this;
    }

    @Step ("Şifre alanı doldurulur")
    public LoginPage singupPassword(String text) {
        driver.findElement(By.id("password")).sendKeys(text);
        return this;
    }

    @Step ("Şifre Tekrar alanı doldurulur")
    public LoginPage singupPasswordAgain(String text) {
        driver.findElement(By.id("password_again")).sendKeys(text);
        return this;
    }

    public LoginPage confirmation() {
        driver.findElement(By.cssSelector("#label_mail_notify_318 > .input-checkbox")).click();
        driver.findElement(By.id("label_sms_notify_318")).click();
        driver.findElement(By.cssSelector("#label_phone_notify_318 > .input-checkbox")).click();
        return null;
    }

    public LoginPage acceptance() {
        driver.findElement(By.cssSelector("#label_privacy_318 > .input-checkbox")).click();
        return this;
    }

    @Step ("Kayıt Ol butonuna basılır")
    public LoginPage singupButton2() {
        driver.findElement(By.id("register-form-btn-318")).click();
        return this;
    }
}
