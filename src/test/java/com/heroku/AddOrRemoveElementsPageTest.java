package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddOrRemoveElementsPageTest extends CrossBrowserTest {

    @Test(priority = 1)
    public void openAddRemoveButtonsTest() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(2) > a")).click();
    }

    @Test(priority = 2)
    public void pageHeaderTest() {
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertEquals(addOrRemoveElementsPage.getPageHeader(),"Add/Remove Elements");
    }

    @Test(priority = 3)
    public void pageFooterTest() {
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertEquals(addOrRemoveElementsPage.getPageFooter(),"Powered by Elemental Selenium");
    }

    @Test(priority = 4)
    public void addElementInAddOrRemoveElementsPageTest() {
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertTrue(addOrRemoveElementsPage.addElementInAddOrRemoveElementsPage());
    }

    @Test(priority = 4)
    public void deleteElementInAddOrRemoveElementsPageTest() {
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertTrue(addOrRemoveElementsPage.deleteElementInAddOrRemoveElementsPage());
    }
}

