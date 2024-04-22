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

public class AddItemDeleteFE {

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
		WebElement adminButton = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(5) > a"));
		adminButton.click();

		WebElement itemName = this.driver.findElement(By.cssSelector("#name"));
		itemName.sendKeys("Madri");

		WebElement itemPrice = this.driver.findElement(By.cssSelector("#price"));
		itemPrice.sendKeys("18.99");

		WebElement itemImage = this.driver.findElement(By.cssSelector("#image"));
		itemImage.sendKeys(
				"https://www.thebottleclub.com/cdn/shop/files/madri-excepcional-lager-beer-12-x-330-ml-beer-32841797271667.jpg?v=1703680696&width=500");

		WebElement itemImageAlt = this.driver.findElement(By.cssSelector("#imageAlt"));
		itemImageAlt.sendKeys("12 Bottles of Madri Lager");

		WebElement itemQuantity = this.driver.findElement(By.cssSelector("#quantity"));
		itemQuantity.sendKeys("1");

		WebElement itemBulkSize = this.driver.findElement(By.cssSelector("#bulkSize"));
		itemBulkSize.sendKeys("12");

		WebElement submit = this.driver.findElement(By.cssSelector("#SubmitCreateItem"));
		submit.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // Wait for 2 seconds
		// Now refresh the page
		driver.navigate().refresh();

		WebElement adminButton2 = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(5) > a"));
		adminButton2.click();

		Thread.sleep(800); // Wait for 8 milliseconds

		// second Item

		WebElement itemName2 = this.driver.findElement(By.cssSelector("#name"));
		itemName2.sendKeys("Peroni");

		WebElement itemPrice2 = this.driver.findElement(By.cssSelector("#price"));
		itemPrice2.sendKeys("34.99");

		WebElement itemImage2 = this.driver.findElement(By.cssSelector("#image"));
		itemImage2.sendKeys(
				"https://www.thebottleclub.com/cdn/shop/files/peroni-nastro-azzurro-beer-multipack-24-x-330-ml-beer-33235553779827.jpg?v=1703664727&width=720");

		WebElement itemImageAlt2 = this.driver.findElement(By.cssSelector("#imageAlt"));
		itemImageAlt2.sendKeys("12 Bottles of Peroni Lager");

		WebElement itemQuantity2 = this.driver.findElement(By.cssSelector("#quantity"));
		itemQuantity2.sendKeys("1");

		WebElement itemBulkSize2 = this.driver.findElement(By.cssSelector("#bulkSize"));
		itemBulkSize2.sendKeys("24");

		WebElement submit2 = this.driver.findElement(By.cssSelector("#SubmitCreateItem"));
		submit2.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // Wait for 2 seconds
		// Now refresh the page
		driver.navigate().refresh();

		WebElement adminButton3 = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(5) > a"));
		adminButton3.click();

		Thread.sleep(800); // Wait for 2 seconds

		// Delete Item 1

		WebElement delete = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div:nth-child(3) > div > table > tbody > tr > td:nth-child(6) > button"));
		delete.click();

		Thread.sleep(800); // Wait for 2 seconds

		WebElement itemPage = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(2) > a"));
		itemPage.click();

		WebElement checkItemName = this.driver.findElement(By.cssSelector("#itemCard > div > ul > li:nth-child(2)"));
		Assertions.assertEquals("Name: Peroni", checkItemName.getText());

		WebElement checkItemPrice = this.driver.findElement(By.cssSelector("#itemCard > div > ul > li:nth-child(3)"));
		Assertions.assertEquals("Price: £34.99", checkItemPrice.getText());

	}
}
