package com.udacity.c1.review.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="messageText")
    private WebElement messageText;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(id="message")
    private WebElement message;

    public void sendMessage(String message){
        this.messageText.sendKeys(message);
        this.submitButton.click();
    }
    public String getMessageText(){
        return this.message.getText();
    }

}
