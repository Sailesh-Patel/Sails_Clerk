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
@Sql(scripts = { "classpath:shop-schema.sql",
		"classpath:shop-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class IncP1Testing {

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
	
	
//	void testCreateBasket() 
//
//		this.driver.get("http://localhost:" + this.port);
//
//		WebElement newBasketName = this.driver.findElement(By.id("#name"));
//		newBasketName.sendKeys("John");
//
//		WebElement newPassword = this.driver
//				.findElement(By.cssSelector("#CreateBasket > div > div > input[type=password]:nth-child(5)"));
//		newPassword.sendKeys("Joe");
//
//		WebElement submit = this.driver.findElement(By.id("#SubmitCreateBasket"));
//		submit.click();
//
//		WebElement selectBasketPage = this.driver
//				.findElement(By.id("#navbarNavAltMarkup > div > ul > li:nth-child(4)"));
//		selectBasketPage.click();
//
//		WebElement checkBasketName = this.driver
//				.findElement(By.cssSelector("/html/body/div/div/div/div/div/div/div/div[2]/h3/text()[2]"));
//		Assertions.assertEquals("Basket Name: Basket 1", checkBasketName.getText());
//	}
}
