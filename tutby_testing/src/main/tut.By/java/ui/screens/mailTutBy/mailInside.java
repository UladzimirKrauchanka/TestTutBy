package ui.screens.mailTutBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class mailInside {
    private WebDriver driver;

    public mailInside(WebDriver driver) {
        this.driver = driver;
    }

    private By countMessage= By.cssSelector("span[title='krauchanka.test@tut.by']");

    public int checkCountMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(countMessage));
        return driver.findElements(countMessage).size();
    }










}
