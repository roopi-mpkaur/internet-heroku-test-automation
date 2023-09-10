package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends BasePage {

    public DropDownList(WebDriver driver) {
        super(driver);
    }

    public String selectOption1InDropDownList() {
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByIndex(1);
        String option = dropDown.getFirstSelectedOption().getText();
        return option;

    }

    public String selectOption2InDropDownList() {
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByIndex(2);
        String option = dropDown.getFirstSelectedOption().getText();
        return option;
    }
}
