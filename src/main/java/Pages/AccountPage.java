package Pages;

import Base.BaseTest;
import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.AbstractCollection;

public class AccountPage extends BaseTest {

    @Step ("Hesabım butonuna tıklanır")
    public AccountPage showAccount() {
        driver.findElement(By.cssSelector("#header-account > img")).click();
        return this;
    }

    @Step ("Kişisel Bilgilerim butonuna tıklanır")
    public AccountPage personalInformation(){
        driver.findElement(By.id("member-personel-btn-314")).click();
        return this;
    }

    @Step ("Telefon numarası butonuna tıklanır ve farklı bir numara yazılır")
    public AccountPage personalMobilePhone(String text){
        driver.findElement(By.xpath("//form[@id='member-register-form330']/div[8]/div/input")).sendKeys(text);
        return this;
    }

    @Step ("Güncelle butonuna tıklanır")
    public AccountPage updateButton(){
        driver.findElement(By.cssSelector("#register-form-btn-330")).click();
        return this;
    }

    @Step ("Mevcut Şifre alanına mevcut şifre girilir girilir")
    public AccountPage passwordOld(String text){
        driver.findElement(By.cssSelector(".input-group:nth-child(2) > .form-control")).sendKeys(text);
        return this;
    }

    @Step ("Yeni Şifre alanına yeni şifre girilir")
    public AccountPage passwordNew(String text){
        driver.findElement(By.cssSelector(".input-group:nth-child(3) > .form-control")).sendKeys(text);
        return this;
    }

    @Step ("Yeni Şifre Tekrar alanına yeni şifre girilir")
    public AccountPage passwordNewAgain(String text){
        driver.findElement(By.cssSelector(".input-group:nth-child(4) > .form-control")).sendKeys(text);
        return this;
    }

    @Step ("Güncelle butonuna tıklanır")
    public AccountPage updatePassword(){
        driver.findElement(By.cssSelector("#updpass-form-btn-330")).click();
        return this;
    }

    @Step ("Ad alanı boş bırakılır")
    public AccountPage emptyName(){
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='surname']")).clear();
        return this;
    }

    @Step ("Eposta adresi değiştirilir")
    public AccountPage changeEmailBox (String text){
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.clear();
        emailField.sendKeys(text);
        return this;
    }

    @Step ("Hesabım butonuna tıklanır")
    public AccountPage addToFav(){
        driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[3]/a/img")).click();
        return this;

    }
    @Step ("Beğen butonuna tıklanır")
    public AccountPage favButton(){
        driver.findElement(By.cssSelector("#header-favourite-count > img")).click();
        return this;
    }

    @Step ("Ürün seçilir")
    public AccountPage chooseProduct(){
        driver.findElement(By.xpath("//div[@id='page-my-favourites']/div[2]/div/div/div/div/div/div/label/span")).click();
        return this;
    }

    @Step ("Favori ürün silinir")
    public AccountPage deleteFavorite(){
        driver.findElement(By.xpath("//div[@id='page-my-favourites']/div[2]/div/div[2]/a[2]/span")).click();
        return this;
    }

    @Step ("Giriş yapmadan ürün favorilere eklenmez uyarısı")
    public AccountPage addFavorite(){
        driver.findElement(By.xpath("//div[@id='page-my-favourites']/div[2]/div/div[2]/a/span")).click();
        return this;
    }

}
