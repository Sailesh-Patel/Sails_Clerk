package com.Inc.Project1.BE.selenium;

import java.time.Duration;

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

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
//@Sql(scripts = { "classpath:shop-schema.sql",
//		"classpath:shop-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class CheckoutTesting {

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

		// Need Login test and basket made

		WebElement username = this.driver.findElement(By.cssSelector("#name"));
		username.sendKeys("Alco");

		WebElement password = this.driver
				.findElement(By.cssSelector("#CreateBasket > div > div > input[type=password]:nth-child(5)"));
		password.sendKeys("Holic");

		WebElement submit = this.driver.findElement(By.cssSelector("#SubmitCreateBasket"));
		submit.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // 0.8 seconds

		driver.navigate().refresh();

		// Need Admin page new item created

		WebElement adminIcon = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(6) > a"));
		adminIcon.click();

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

		WebElement submitItem = this.driver.findElement(By.cssSelector("#SubmitCreateItem"));
		submitItem.click();
		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // Wait for 0.8 seconds
		// Now refresh the page
		driver.navigate().refresh();

		// Need to add item to basket

		WebElement addToBasket = this.driver.findElement(By.cssSelector("#itemCard > div > button"));
		addToBasket.click();

		driver.navigate().refresh();

		WebElement goToBasket = this.driver
				.findElement(By.cssSelector("#navbarNavAltMarkup > div > ul > li:nth-child(4) > a"));
		goToBasket.click();

		// Add a short wait if necessary to ensure the click has been processed
		Thread.sleep(800); // Wait for 0.8 seconds
		// Now refresh the page
		driver.navigate().refresh();

		WebElement checkout = this.driver
				.findElement(By.cssSelector("#root > div > div > div > div > div > div > div:nth-child(3) > button"));
		checkout.click();

		WebElement newPhoneNumber = this.driver.findElement(By.cssSelector("#phone\\ number"));
		newPhoneNumber.sendKeys("07814569785");

		WebElement newEmail = this.driver.findElement(By.cssSelector("#email"));
		newEmail.sendKeys("Alco-Holic@AA.com");

		WebElement checkoutSubmit = this.driver.findElement(By.cssSelector("#SubmitCreateBasket"));
		checkoutSubmit.click();
	}
}