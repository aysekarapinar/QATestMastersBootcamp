package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {

    @Step ("Sayfada 10 saniye beklenir")
    public HomePage waitingTime(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        return this;
    }

    @Step ("Kategori butonuna basılır")
    public HomePage Category(){
        driver.findElement(By.cssSelector("li:nth-child(6) > .d-flex")).click();
        return this;
    }

    @Step ("Edebiyat butonuna basılır")
    public HomePage Literature() {
        driver.findElement(By.cssSelector(".col-6:nth-child(13) .block-title")).click();
        return this;
    }

    @Step ("Sayfanın yüklenmesi kontrol edilir")
    public HomePage scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(10000);
        return this;
    }

    @Step ("Yeniden Eskiye filtresi seçilir")
    public HomePage alignment() {
        WebElement dropdown = driver.findElement(By.id("sort"));
        dropdown.findElement(By.xpath("//option[. = 'Yeniden Eskiye']")).click();
        return this;
    }

    @Step ("Yayınevi seçilir")
    public HomePage productChoose(){
        driver.findElement(By.cssSelector("#label-brand15068 > .input-checkbox")).click();
        return this;
    }
    @Step ("Stoktakiler butonu seçilir")
    public HomePage inStock(){
        driver.findElement(By.cssSelector(".input-radio")).click();
        return this;
    }

    public HomePage onSale(){
        driver.findElement(By.xpath("//label[@id='label-filter-discounted']/span")).click();
        return this;
    }

    @Step ("Seçimi Filteler botununa tıklanır")
    public HomePage filterButton(){
        driver.findElement(By.cssSelector(".py-1 > .w-100"));
        return this;
    }

    @Step ("Arama kutusuna istenilen ürünle ilgili bir şey yazılır")
    public HomePage search(String text){
        driver.findElement(By.id("live-search")).sendKeys(text);
        driver.findElement(By.id("live-search")).sendKeys(Keys.ENTER);
        return this;
    }

    @Step ("Fiyat Artan filtresi seçilir")
    public HomePage price(){
        WebElement dropdown = driver.findElement(By.id("sort"));
        dropdown.findElement(By.xpath("//option[. = 'Fiyat Artan']")).click();
        return this;
    }

    @Step ("İstenilen ürün seçilir")
    public HomePage choosingProduct(){
        driver.findElement(By.cssSelector(".col-6:nth-child(5) .image-wrapper img")).click();
        return this;
    }

    @Step ("Sepete Ekle butonuna tıklanır")
    public HomePage addToProduct(){
        driver.findElement(By.cssSelector("#addToCartBtn > img")).click();
        return this;
    }

    @Step ("Uyarı ekranının gitmesi için çarpıya basılır")
    public HomePage close(){
        driver.findElement(By.cssSelector("#t-modal-close-1 > .ti-close")).click();
        return this;
    }

    @Step ("Sepetim butonuna basılır")
    public HomePage myCart(){
        driver.findElement(By.cssSelector("#header-cart-count > img")).click();
        return this;
    }

    @Step ("Sepete Git butonuna basılır")
    public HomePage goToCart(){
        driver.findElement(By.cssSelector("#cart-popup-go-cart")).click();
        return this;
    }

    @Step ("Satın Al butonuna basılır")
    public HomePage buyButton(){
        driver.findElement(By.cssSelector("#cart-popup-continue-shopping")).click();
        return this;
    }

    @Step ("Spette bulunan ürünlerin adedini artırmak için artı butonlarına tıklanır")
    public HomePage cartButton(){
        driver.findElement(By.xpath("//*[@id=\"qty-plus7577592\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"qty-minus7386363\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"qty-minus6709240\"]")).click();
        return this;
    }

    @Step ("Sepetteki Satın Al butonuna tıklanır")
    public HomePage buyButtoninCart(){
        driver.findElement(By.cssSelector("#go-cart-btn")).click();
        return this;
    }

    @Step ("Sepetteki ürün silinir")
    public HomePage deleteButton(){
        driver.findElement(By.id("clear-cart-btn-586")).click();
        return this;
    }

    @Step ("Ödeme Adımına Geç butonuna tıklanır")
    public HomePage orderButton(){
        driver.findElement(By.xpath("//div[@id='order-steps']/div[2]/div/div[4]/div/div[2]/button/span")).click();
        return this;
    }

    @Step ("Kart isim alanına bir ad yazılır")
    public HomePage cartName(String text){
        driver.findElement(By.id("cardHolder")).sendKeys(text);
        return this;
    }

    @Step ("Kart soyad alanına bir soyad yazılır")
    public HomePage cartNumber(String text){
        driver.findElement(By.id("cardNumber")).sendKeys(text);
        return this;
    }

    @Step ("Kart tarih alanından bir ay seçilir")
    public HomePage cartMonth(){
        WebElement dropdown = driver.findElement(By.id("expireMonth"));
        dropdown.findElement(By.xpath("//option[. = '01']")).click();
        return this;
    }

    @Step ("Kart tarih alanından bir yıl seçilir")
    public HomePage cartYear(){
        WebElement dropdown = driver.findElement(By.id("expireYear"));
        dropdown.findElement(By.xpath("//option[. = '2025']")).click();
        return this;
    }

    @Step ("Kart CVC alanına bir CVC yazılır")
    public HomePage cartCVC(){
        driver.findElement(By.id("cvc")).click();
        driver.findElement(By.id("cvc")).sendKeys("111");
        driver.findElement(By.cssSelector(".m-0 > .input-checkbox")).click();
        return this;
    }

    @Step ("Sözleşme butonu seçilir")
    public HomePage checkbox(){
        driver.findElement(By.xpath("//div[@id='order-agreements']/div/label/span")).click();
        return this;
    }

    @Step ("Siparişi Tamamla butonuna tıklanır")
    public HomePage orderButton2(){
        driver.findElement(By.xpath("//div[@id='order-steps']/div[2]/div/div[5]/div/div[2]/button")).click();
        return this;
    }

    @Step ("Düzenle butonuna basılır")
    public HomePage editAddress(){
        driver.findElement(By.cssSelector(".btn-light:nth-child(1)")).click();
        return this;
    }

    @Step ("Telefon alanına bir numara yazılır")
    public HomePage mobilePhone(String text){
        driver.findElement(By.xpath("//input[@id='mobile_phone']")).sendKeys(text);
        return this;
    }

    @Step ("Güncelle butonuna basılır")
    public HomePage editAddressButton(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return this;
    }
}
