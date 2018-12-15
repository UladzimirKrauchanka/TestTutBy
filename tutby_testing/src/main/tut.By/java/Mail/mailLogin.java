package Mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.screens.mailTutBy.mailInside;
import ui.screens.mailTutBy.startPage;
import ui.screens.mailTutBy.yandexPassport;

import java.util.concurrent.TimeUnit;

public class mailLogin {
    private WebDriver driver;
    private String login="Krauchanka.test@tut.by";
    private String password="Uladzimir123";

    @BeforeClass(description = "primary Settings", alwaysRun = true)
    public void primarySettings() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\tut.By\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    }

    @Test(description = "Successful authorization")
    public void sucessLogin() throws InterruptedException {
        startPage startPage = new startPage(driver);
        yandexPassport yandexPassport = new yandexPassport(driver);
        mailInside mailInside = new mailInside(driver);
        startPage
                .open()
                .clickEntry()
                .typeLogin(login)
                .typePassword(password)
                .clickSubmit();
        startPage.goToMail();
        yandexPassport.open()
                .typeLogin(login)
                .clickSubmit()
                .typePassword(password)
                .clickSubmit();
        yandexPassport.openMailYandex();
        Assert.assertEquals(mailInside.checkCountMessage(),3,"You don't have n message");



    }

    @AfterClass(description = "kill Chrome")
    public void finallySettings() {
        driver.quit();
   }

}
