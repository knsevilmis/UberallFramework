package com.Uberall.stepDefinitions;

import com.Uberall.pages.DashboardPage;
import com.Uberall.utilities.BrowserUtils;
import com.Uberall.utilities.ConfigurationReader;
import com.Uberall.utilities.Driver;
import com.gargoylesoftware.htmlunit.javascript.configuration.CanSetReadOnly;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPageStepDef {

    DashboardPage dashboardPage = new DashboardPage();


    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(3);
        Shadow shadow = new Shadow(Driver.get());
        WebElement AcceptCookies = shadow.findElement(".sc-gsDKAQ.jHgrWm");
        System.out.println(AcceptCookies.getText());
        AcceptCookies.click();
        BrowserUtils.waitFor(2);
    }

    @When("user clicks {string} {string} module")
    public void user_clicks_module(String module1, String module2) {
        WebElement mainMenu =Driver.get().findElement(By.xpath("//div/header[@class='header']"));
        Actions actions =new Actions(Driver.get());
        actions.moveToElement(mainMenu);
        actions.click(mainMenu).perform();

        BrowserUtils.waitFor(2);
       dashboardPage.navigateToModule(module1);

       dashboardPage.navigateToModule(module2);
       BrowserUtils.waitFor(3);
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String expectedTitle) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(expectedTitle.toUpperCase(),Driver.get().getTitle());

    }


}
