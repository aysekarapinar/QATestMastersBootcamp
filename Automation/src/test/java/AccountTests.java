import Base.BaseTest;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AccountTests extends BaseTest {
    AccountPage accountPage=new AccountPage();
    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();

    @Test (description = "Kişisel Bilgilerim Kontrolü")
    public void AccountInformation() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation();
    }

    @Test (description = "Kullanıcı Bilgileri Güncelleme")
    public void UpdatePersonalInformation() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.personalMobilePhone(mobilePhoneInput);sleep(5000);
        accountPage.updateButton();
    }

    @Test (description = "Geçersiz Telefon Numarası Kontrolü")
    public void InvalidMobilePhone() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.personalMobilePhone("555 555 55");sleep(5000);
        accountPage.updateButton(); sleep(5000);
        Assert.assertEquals(mainPage.AccountMessage(), "İşlem Gerçekleştirilemedi!");
    }

    @Test (description = "Şifre Değiştirme")
    public void ChangePassword() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.passwordOld(password).passwordNew(newPassword).passwordNewAgain(newPassword); sleep(5000);
        accountPage.updatePassword(); sleep(5000);
    }

    @Test
    public void IncorrectPassword() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.passwordOld("karapinara123Anc").passwordNew(newPassword).passwordNewAgain(newPassword); sleep(5000);
        accountPage.updatePassword(); sleep(5000);
    }

    @Test (description = "Geçersiz Şifre ile güncelleme denemesi")
    public void IncorrectNewPassword() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.passwordOld(password).passwordNew(wrongNewPassword).passwordNewAgain(wrongNewPassword); sleep(5000);
        accountPage.updatePassword(); sleep(5000);
    }

    @Test(description = "Yeni Şifre ile Şifre Tekrarının uyuşmaması")
    public void DiffrentPassword() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.passwordOld(password).passwordNew(wrongNewPassword).passwordNewAgain("pasword123"); sleep(5000);
        accountPage.updatePassword(); sleep(5000);
    }

    @Test (description = "Ad ve Soyad kısmının boş bırakılması")
    public void EmptyNameSurname() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.emptyName(); sleep(5000);
        accountPage.updateButton(); sleep(5000);
    }

    @Test (description = "Eposta adresi değiştirme")
    public void ChangeEmail() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.changeEmailBox(email);
        accountPage.updateButton(); sleep(5000);
    }

    @Test (description = "Geçersiz eposta formatıyla eposta değiştirme")
    public void ErrorEmail() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.showAccount().personalInformation(); sleep(5000);
        accountPage.changeEmailBox("example.com");
        accountPage.updateButton(); sleep(5000);
    }

    @Test (description = "Ürünleri Favorilerim listesine ekleme")
    public void FavoriteControl() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        accountPage.addToFav(); sleep(5000);
        accountPage.favButton(); sleep(5000);
    }

    @Test (description = "Favorilerden ürün silme")
    public void DeleteFav() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.favButton(); sleep(5000);
        accountPage.chooseProduct().deleteFavorite(); sleep(5000);
    }

    @Test (description = "Favorileri sepete ekleme")
    public void AddCartInFav() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        accountPage.favButton(); sleep(5000);
        accountPage.chooseProduct().addFavorite();sleep(5000);
    }

    @Test (description = "Giriş yapmadan ürün favorilere eklenemez uyarısı")
    public void MessageFav() throws InterruptedException {
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        accountPage.addToFav(); sleep(5000);
        Assert.assertEquals(mainPage.FavErrorMessage(), "ÜYE GIRIŞI");
    }

}