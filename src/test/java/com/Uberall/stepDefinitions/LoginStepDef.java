package com.Uberall.stepDefinitions;

import com.Uberall.pages.DashboardPage;
import com.Uberall.pages.LoginPage;
import com.Uberall.utilities.BrowserUtils;
import com.Uberall.utilities.ConfigurationReader;
import com.Uberall.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String Url =ConfigurationReader.get("url");
        Driver.get().get(Url);

        BrowserUtils.waitFor(3);

        //Cookies button is shadow-root DOM element.
        Shadow shadow = new Shadow(Driver.get());
        WebElement AcceptCookies = shadow.findElement(".sc-gsDKAQ.jHgrWm");
        System.out.println(AcceptCookies.getText());

        AcceptCookies.click();

       loginPage.Login.click();

       String expectedUrl = "https://uberall.com/en/app/uberall/login";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        BrowserUtils.waitFor(3);
    }

    @When("user enters {string} on email box, {string} on password box")
    public void user_enters_on_email_box_on_password_box(String email, String password) {

        loginPage.emailBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);

    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.LoginButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


    }


    @Then("user should see {string} as warning message")
    public void user_should_see_as_warning_message(String expectedMessage) {

     String actualMessage =  loginPage.AlertMessage.getText();

     Assert.assertEquals(expectedMessage,actualMessage);

    }


}
