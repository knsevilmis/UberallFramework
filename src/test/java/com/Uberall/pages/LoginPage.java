package com.Uberall.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div/a[@id='menubutton71']")
    public WebElement Login;

    @FindBy(xpath = "//form/input[@type='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//form/input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//div/input[@value='LOGIN']")
    public WebElement LoginButton;

    @FindBy(css = ".alert.alert-error.auth-failure-message")
    public WebElement AlertMessage;








}
