package com.udacity.c1.review.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="firstname")
    private WebElement firstname;

    @FindBy(id="lastname")
    private WebElement lastname;

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="submit")
    private WebElement submit;

    public void signup(String firstname, String lastname, String username, String password){
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();
    }
}
