package pageobject;

  import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver; 
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.FindBy;
  import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstractcomponent;

  
  public class Confirmationpage extends Abstractcomponent { 	 	 
	  WebDriver driver; 
	  public Confirmationpage(WebDriver driver) 
	  { 	
		  //intialization 	
		  super(driver); 	
		  this.driver=driver; 
		  PageFactory.initElements(driver,this); 	
		  } 	 
	 
	  @FindBy(css=".btnn.action__submit.ng-star-inserted")

	  WebElement ConfirmationMesage; 	
	  
	  
	  public String verifyConfirmationMessage() 
	  { 	
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(-100,document.body.scrollDown)");
		  return ConfirmationMesage.getText(); 
		  } 	
    
  }




