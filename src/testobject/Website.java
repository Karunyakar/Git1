package testobject;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.Cartpage;
import pageobject.Checkoutpage;
import pageobject.Confirmationpage;
import pageobject.Loginpage;
import pageobject.Productcatalog;

public class Website {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\r.karunya\\Downloads\\ChromeDriver\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		Loginpage login = new Loginpage(driver);
		login.goTo();
		login.LoginApplication();

		Productcatalog product = new Productcatalog(driver);
		product.addItems();

		Cartpage cart = new Cartpage(driver);
		cart.Cartpage();
		cart.verifyproduct();

		Checkoutpage check = new Checkoutpage(driver);
		check.checkoutpage();

		Confirmationpage confirm = new Confirmationpage(driver);
		confirm.verifyConfirmationMessage();
	} 

}
