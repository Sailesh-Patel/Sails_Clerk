package com.Inc.Project1.BE.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:shop-schema.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class Login {

	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test
	@Order(1)

	void addItemTest() throws InterruptedException {

		this.driver.get("http://localhost:3000");

		WebElement username = this.driver.findElement(By.cssSelector("#name"));
		username.sendKeys("Alco");

		WebElement password = this.driver
				.findElement(By.cssSelector("#CreateBasket > div > div > input[type=password]:nth-child(5)"));
		password.sendKeys("Holic");

		WebElement submit1 = this.driver.findElement(By.cssSelector("#SubmitCreateBasket"));
		submit1.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // 0.8 seconds
		// Now refresh the page
		driver.navigate().refresh();

		WebElement basketIcon = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(3) > a > svg > path"));
		basketIcon.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // 0.8 seconds
		// Now refresh the page
		driver.navigate().refresh();

		WebElement checkBasketName = this.driver
				.findElement(By.cssSelector("#root > div > div > div > div > div > div > div:nth-child(2) > h3"));
		Assertions.assertEquals("Basket Name: Alco", checkBasketName.getText());
	}
}
