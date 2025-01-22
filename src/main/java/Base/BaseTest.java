package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {


    @BeforeMethod(description = "Web sayfası açılır")
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }

    @AfterMethod (description = "Tarayıcı kapanıtılır")
    public void CloseBrowser() {
        driver.quit();
    }

}
