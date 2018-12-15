package ui.screens.mailTutBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class startPage {
    private WebDriver driver;
    private By buttonEnty = By.cssSelector("a.enter");
    private By logindInput = By.name("login");
    private By passwordInput = By.name("password");
    private By submitButton = By.cssSelector("input[type='submit']");
    private By mailButton = By.cssSelector("a[title='Почта']");

    public startPage(WebDriver driver) {
        this.driver = driver;
    }

    public startPage open() {
        driver.get("https://www.tut.by");
        return this;
    }

    public startPage clickEntry() {
        driver.findElement(buttonEnty).click();
        return this;
    }

    public startPage typeLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logindInput));
        driver.findElement(logindInput).sendKeys(login);
        return this;
    }

    public startPage typePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public startPage clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
        return this;
    }

    public yandexPassport goToMail() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailButton));
        driver.findElement(mailButton).click();
        return new yandexPassport(driver);
    }
}

