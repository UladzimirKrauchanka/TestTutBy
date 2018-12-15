package ui.screens.mailTutBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class yandexPassport {
    private WebDriver driver;
    private By logindInput = By.name("login");
    private By passwordInput = By.name("passwd");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By userButton = By.cssSelector("a[data-lego]");


    public yandexPassport(WebDriver driver) {
        this.driver = driver;
    }

    public yandexPassport open() {
        driver.get("https://passport.yandex.ru/auth");
        return this;
    }

    public yandexPassport typeLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logindInput));
        driver.findElement(logindInput).sendKeys(login);
        return this;
    }

    public yandexPassport typePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public yandexPassport clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
        return this;
    }

    public mailInside openMailYandex() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
        driver.get("https://mail.yandex.ru");
        return new mailInside(driver);
    }

}

