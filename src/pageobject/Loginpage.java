package pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractcomponent.Abstractcomponent;

public class Loginpage extends Abstractcomponent {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	public void LoginApplication() throws IOException {
		Properties pro=new Properties();
        FileInputStream files=new FileInputStream("C:\\Users\\r.karunya\\eclipse-workspace\\Demo2\\ProperityFile");
        pro.load(files);
        String email= pro.getProperty("Email");
        String password=pro.getProperty("Password");
      
        userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		System.out.println("Login successfully");

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}