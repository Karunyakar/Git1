package pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import abstractcomponent.Abstractcomponent;

public class Productcatalog extends Abstractcomponent {

	WebDriver driver;

	public Productcatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	public void addItems() throws IOException, InterruptedException {

		Properties pro = new Properties();
		FileInputStream files = new FileInputStream(
				"C:\\Users\\r.karunya\\eclipse-workspace\\Demo2\\ProperityFile");
		pro.load(files);
		Thread.sleep(3000);
		String[] itemsNeeded = pro.getProperty("Products").toString().split("#");
		String formattedname = itemsNeeded[0].trim();
		if (formattedname.length() == 0) {
			System.out.println(" total no .of products in the property file " + formattedname.length());

			System.out.println("No products in the property file");

			System.exit(0);
		}

		else if (formattedname.length() > 0) {

			int j = 0;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
			
			
			List<WebElement> products = driver
					.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));

			for (int i = 0; i < products.size(); i++) {
				String[] name = products.get(i).getText().split("-");
				String formattedName = name[0].trim();
				List itemsNeedlist = Arrays.asList(itemsNeeded);
				if (itemsNeedlist.contains(formattedName)) {
					System.out.println(formattedName +"products is added successfully");

					j++;

					driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
					wait.until(ExpectedConditions
							.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));

					if (j == itemsNeeded.length) {
					break;
					}

				}

			}
		}
		
	}
}
