package com.Uberall.pages;

import com.Uberall.utilities.BrowserUtils;
import com.Uberall.utilities.Driver;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateToModule(String module) {

        Actions actions = new Actions(Driver.get());

        String moduleLocator = "//nav[@class='nav__mobile']//ul/li/a[normalize-space()='" + module + "']";

       WebElement Module = Driver.get().findElement(By.xpath(moduleLocator));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", Module);

        BrowserUtils.waitFor(2);


    }

    @FindBy(css = "div[class='entry fr-view'] h1")
    public WebElement PageTitle;

}
