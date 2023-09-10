package com.heroku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    protected WebElement menuBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public String rightClickOnBox() {
        Actions action = new Actions(driver);
        action.contextClick(menuBox).perform();
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert();
        return alert.getText();
    }

    public void openContextMenu() {
        driver.switchTo().alert().accept();
    }
}
