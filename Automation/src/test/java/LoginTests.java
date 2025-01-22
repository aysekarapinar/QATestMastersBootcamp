import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
    LoginPage loginPage=new LoginPage();
    MainPage mainPage=new MainPage();

    @Test (description = "Başarılı Giriş Kontrolü")
    public void LoginSuccessfull() throws InterruptedException {
        loginPage.clickLogin()
                .fillEmail(email)
                .fillPassword(password)
                .clickRememberMe().clickLoginButton();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Hesabım");
    }

    @Test (description = "Başarısız Giriş Kontrolü")
    public void LoginUnSuccessfull() throws InterruptedException {
        loginPage.clickLogin()
                .fillEmail(email)
                .fillPassword("karapinar123Anc")
                .clickRememberMe().clickLoginButton();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Giriş");
    }

    @Test (description = "Beni Hatırla Butonu Seçmeme Durumu Kontrolü")
    public void UnRememberMe() throws InterruptedException {
        loginPage.clickLogin()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Hesabım");
        driver.navigate().refresh();
        Assert.assertEquals(mainPage.getAccountValue(), "Giriş");
    }

    @Test (description = "Beni Hatırla Butonu Kontrolü")
    public void RememberMe() throws InterruptedException {
        loginPage.clickLogin()
                .fillEmail(email)
                .fillPassword(password)
                .clickRememberMe().clickLoginButton();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(), "Hesabım");
        driver.navigate().refresh();
        Assert.assertEquals(mainPage.getAccountValue(), "Hesabım");
    }

    @Test (description = "Şifreni Unuttum Kontrolü")
    public void ForgotPassword() throws InterruptedException {
        loginPage.clickLogin();
        sleep(5000);
        loginPage.forgotPasswordButton();
        sleep(5000);
        loginPage.passwordEmail(email);
        loginPage.forgotClick();
    }
}