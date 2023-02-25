package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        WebElement animalText = driver.findElement(By.id("animalText"));
        WebElement adjective = driver.findElement(By.id("adjective"));
        animalText.sendKeys("Selenium");
        adjective.sendKeys("His");

        for(int i =0; i<5; i++){

            WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
            submitButton.click();
        }

        WebElement conclusion = driver.findElement(By.className("conclusionMessage"));
        if(conclusion != null){System.out.println(conclusion.getText());}

        Thread.sleep(5000);
        driver.quit();

    }
}
