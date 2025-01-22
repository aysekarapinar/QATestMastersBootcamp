import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
      HomePage homePage=new HomePage();
      MainPage mainPage=new MainPage();
      LoginPage loginPage=new LoginPage();


    @Test (description = "Anasayfa Kontrolü")
    public void HomePageAndCategoryControl() throws InterruptedException {
        Assert.assertEquals(mainPage.getLogoValue(), "Favorilerim");
        homePage.waitingTime();
        homePage.Category().Literature();
        homePage.waitingTime();
        homePage.scroll();
    }

    @Test (description = "Filtre Kontrolü")
    public void ProductFiltering() throws InterruptedException {
        homePage.Category().Literature().alignment(); sleep(5000);
        homePage.productChoose(); sleep(5000);
        homePage.inStock().filterButton();
    }

    @Test (description = "Arama Kontrolü")
    public void SearchBox() throws InterruptedException {
        homePage.search("Roman");sleep(5000);
        homePage.price().search("asdfghjk"); sleep(5000);
        Assert.assertEquals(mainPage.getErrorMessage(), "Arama kriterlerinize uygun ürün bulunamadı. Yukarıda yer alan aramanıza benzer tahminlere göz atabilir veya kategori menüsünden ilginizi çekenleri inceleyebilirsiniz.");

    }

    @Test (description = "Sepet Kontrolü")
    public void AddToCart() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        homePage.addToProduct().sleep(5000);
        homePage.close(); sleep(5000);
        homePage.myCart(); sleep(5000);
    }

    @Test (description = "Sepete Git butonu kontrolü")
    public void GoToTheCart() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        homePage.addToProduct(); sleep(5000);
        homePage.goToCart(); sleep(5000);
    }

    @Test (description = "Satın Al butonu kontrolü")
    public void BuyButton() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        homePage.addToProduct(); sleep(5000);
        homePage.buyButton(); sleep(5000);
    }

    @Test (description = "Sepeti Görüntüleme ve Güncelleme")
    public void CartControl() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.myCart();sleep(5000);
        homePage.buyButtoninCart();sleep(5000);
        homePage.cartButton(); sleep(5000);
    }

    @Test (description = "Sepetten ürün silme")
    public void Delete() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.myCart();sleep(5000);
        homePage.buyButtoninCart();sleep(5000);
        homePage.deleteButton(); sleep(5000);
    }

    @Test (description = "Geçersiz kart bilgileri ile ödeme denemesi")
    public void InvalidCartInformation() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        homePage.addToProduct(); sleep(5000);
        homePage.buyButton(); sleep(5000);
        homePage.orderButton(); sleep(5000);
        homePage.cartName(cartNameInput).cartNumber(cartNumberInput).cartMonth().cartYear().cartCVC(); sleep(5000);
        homePage.checkbox().orderButton2(); sleep(5000);
    }

    @Test (description = "Fatura ve Teslimat bilgilerini güncelleme")
    public void Address() throws InterruptedException {
        loginPage.clickLogin().fillEmail(email).fillPassword(password).clickRememberMe().clickLoginButton();
        sleep(5000);
        homePage.search("Martin Eden"); sleep(5000);
        homePage.choosingProduct(); sleep(5000);
        homePage.addToProduct(); sleep(5000);
        homePage.buyButton(); sleep(5000);
        homePage.editAddress();sleep(5000);
        homePage.mobilePhone(mobilePhoneInput);sleep(5000);
        homePage.editAddressButton(); sleep(5000);
        screenshot();
    }
}
