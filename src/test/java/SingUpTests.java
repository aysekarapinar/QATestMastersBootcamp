import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class SingUpTests extends BaseTest {
    LoginPage loginPage=new LoginPage();
    MainPage mainPage=new MainPage();


    @Test (description = "Başarılı kayıt olma")
    public void SingUpSuccessfull() throws InterruptedException {
        loginPage.clickLogin(); sleep(5000);
        loginPage.sigUpButton();sleep(5000);
        loginPage.singUpName(name);sleep(5000);
        loginPage.singUpSurname(surname).singUpEmail("covcov1111@gmail.com");sleep(5000);
        loginPage.cityClick();sleep(5000);
        loginPage.townClick();sleep(5000);
        loginPage.singupPassword(singupPassword).singupPasswordAgain(passwordAgain); sleep(5000);
        //loginPage.confirmation().acceptance();sleep(5000);
        loginPage.singupButton2();sleep(5000);
    }

    @Test (description = "Başarısız kayıt olma")
    public void SingupUnSuccessfull() throws InterruptedException {
        loginPage.clickLogin(); sleep(5000);
        loginPage.sigUpButton();sleep(5000);
        loginPage.singUpEmail(email);sleep(5000);
        loginPage.cityClick();sleep(5000);
        loginPage.townClick();sleep(5000);
        loginPage.singupPassword(singupPassword).singupPasswordAgain(passwordAgain); sleep(5000);
        //loginPage.confirmation().acceptance();sleep(5000);
        loginPage.singupButton2();sleep(5000);
    }

    @Test (description = "Yanlış e-mail ile kayıt olma")
    public void WrongSingup() throws InterruptedException {
        loginPage.clickLogin()
                .sigUpButton(); sleep(5000);
        loginPage.singUpName(name).singUpSurname(surname).singUpEmail("example.com");
        sleep(5000);
        loginPage.cityClick(); sleep(5000);
        loginPage.townClick(); sleep(5000);
        loginPage.singupPassword(password).singupPasswordAgain(passwordAgain); sleep(5000);
        //loginPage.confirmation().acceptance(); sleep(5000);
        loginPage.singupButton2(); sleep(5000);
    }

    @Test (description = "Geçersiz şifre ile kayıt olma")
    public void InvalidPassword() throws InterruptedException {
        loginPage.clickLogin().sigUpButton(); sleep(5000);
        loginPage.singUpName(name).singUpSurname(surname).singUpEmail("sampi1221@gmail.com");sleep(5000);
        loginPage.cityClick(); sleep(5000);
        loginPage.townClick(); sleep(5000);
        loginPage.singupPassword("123456").singupPasswordAgain("123456"); sleep(5000);
        //loginPage.confirmation().acceptance(); sleep(5000);
        loginPage.singupButton2();sleep(5000);
    }

    @Test (description = "Kayıtlı adresle kayıt olma")
    public void RegisteredEmail() throws InterruptedException {
        loginPage.clickLogin().sigUpButton(); sleep(5000);
        loginPage.singUpName(name).singUpSurname(surname).singUpEmail(email);
        sleep(5000);
        loginPage.cityClick(); sleep(5000);
        loginPage.townClick(); sleep(5000);
        loginPage.singupPassword(singupPassword).singupPasswordAgain(singupPassword); sleep(5000);
        //loginPage.confirmation().acceptance(); sleep(5000);
        loginPage.singupButton2();
        sleep(5000);
    }

    @Test (description = "Ticari Anlaşmalarını kabul etmeden kayıt olma")
    public void NotChoosingAcceptance() throws InterruptedException {
        loginPage.clickLogin().sigUpButton(); sleep(5000);
        loginPage.singUpName(name).singUpSurname(surname).singUpEmail("ozlemmaysee28@gmail.com");
        sleep(5000);
        loginPage.cityClick(); sleep(5000);
        loginPage.townClick(); sleep(5000);
        loginPage.singupPassword(singupPassword).singupPasswordAgain(singupPassword); sleep(5000);
        //loginPage.confirmation(); sleep(5000);
        loginPage.singupButton2();
    }

    @Test (description = "Üyleik Sözleşmesini kabul etmeden kayıt olma")
    public void NotChoosingAgreement() throws InterruptedException {
        loginPage.clickLogin().sigUpButton(); sleep(5000);
        loginPage.singUpName(name).singUpSurname(surname).singUpEmail("cannettkarapinarr28@gmail.com");sleep(5000);
        loginPage.cityClick(); sleep(5000);
        loginPage.townClick(); sleep(5000);
        loginPage.singupPassword(singupPassword).singupPasswordAgain(singupPassword); sleep(5000);
        loginPage.singupButton2(); sleep(5000);
    }
}
