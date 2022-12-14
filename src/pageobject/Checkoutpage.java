package pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponent.Abstractcomponent;

public class Checkoutpage extends Abstractcomponent {
	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement searchcountry;

	@FindBy(xpath = "//div[@class='payment__shipping']//button[2]")
	WebElement country;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeorder;

	public void checkoutpage() throws InterruptedException, IOException {

		Properties pro = new Properties();
		FileInputStream files = new FileInputStream("C:\\Users\\r.karunya\\eclipse-workspace\\Demo2\\ProperityFile");
		pro.load(files);
		String Place = pro.getProperty("place");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(-100,document.body.scrollDown)");

		searchcountry.click();
		searchcountry.sendKeys(Place);
		Thread.sleep(4000);
		country.click();
		Thread.sleep(8000);
		placeorder.click();

	}
}
