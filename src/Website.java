

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

public class Website {

	public static void main(String[] args) throws InterruptedException {

		String[] itemsNeeded = { "ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO" };

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\r.karunya\\Downloads\\ChromeDriver\\Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("rmpjkj@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("K@runya22");
		driver.findElement(By.id("login")).click();
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		WebElement ele=driver.findElement(By.xpath("//button[text()='Checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		   Boolean bool=  driver.findElement(By.xpath("//button[text()='Checkout']")).isEnabled();
	        if(bool==true) {
	            driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	        }
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='payment__shipping']//button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
	}

	public static void addItems(ChromeDriver driver, String[] itemsNeeded) {
		int j = 0;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeedlist = Arrays.asList(itemsNeeded);
			if (itemsNeedlist.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				wait.until(ExpectedConditions
						.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
				if (j == itemsNeeded.length) {
					System.out.println(" ZARA COAT 3 IS ADDED SUCESSFULLY");
					System.out.println(" ADIDAS ORIGINAL IS ADDED SUCESSFULLY");
					System.out.println(" IPHONE 13 PRO IS ADDED SUCESSFULLY");
					break;
				}
			}

		}

	}

}
