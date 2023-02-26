package com.udacity.c1.review;

import com.udacity.c1.review.pageobjects.ChatPage;
import com.udacity.c1.review.pageobjects.LoginPage;
import com.udacity.c1.review.pageobjects.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private ChatPage chatPage;
	private LoginPage loginPage;
	private SignUpPage signUpPage;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
	}

	@Test
	void contextLoads() {
		String username = "username";
		String password = "password";
		String lastname = "lastname";
		String firstname = "firstname";
		driver.get("http://localhost:"+port+"/signup");
		signUpPage = new SignUpPage(driver);
		signUpPage.signup(firstname,lastname, username, password);

		driver.get("http://localhost:"+port+"/login");
		loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.get("http://localhost:"+port+"/chat");
		chatPage = new ChatPage(driver);
		chatPage.sendMessage("Hello");
//		WebElement webElement = wait.until(webdriver->webdriver.findElement(By.id("message")));
		assertEquals("Hello", chatPage.getMessageText());
	}

}
