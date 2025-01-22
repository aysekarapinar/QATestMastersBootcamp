package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step ("Kullanıcı bilgisi alınır")
    public String getAccountValue() {
        screenshot();
        return driver.findElement(By.xpath("//a[@id='header-account']/span")).getText();
    }

    public String getLogoValue() {
        screenshot();
        return driver.findElement(By.cssSelector("#header-favourite-count > .d-none")).getText();
    }

    public String getErrorMessage(){
        screenshot();
        return driver.findElement(By.cssSelector(".pagination-info-bar")).getText();
    }

    public String buyButton(){
        screenshot();
        return driver.findElement(By.xpath("//div[@id='header-cart-panel-596']/div")).getText();
    }

    public String AccountMessage(){
        screenshot();
        return driver.findElement(By.xpath("//div[@id='tsoft-notify-top-right']/div/div")).getText();
    }

    public String FavErrorMessage(){
        screenshot();
        return driver.findElement(By.xpath("(//a[contains(text(),'Üye Girişi')])[2]")).getText();
    }
}
