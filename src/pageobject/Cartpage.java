package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstractcomponent;

public class Cartpage extends Abstractcomponent {
	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkout;

	public void Cartpage() {
		cart.click();

	}

	public void verifyproduct() throws InterruptedException {

		WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkOut);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

	}
}
