package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuPageTest extends CrossBrowserTest {

    @Test (priority = 1)
    public void openContextMenu() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(7) > a")).click();
    }

    @Test (priority = 2)
    public void rightClickOnBoxTest() {
        ContextMenuPage contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);
        Assert.assertEquals(contextMenuPage.rightClickOnBox(), "You selected a context menu");
        contextMenuPage.openContextMenu();
    }
}
