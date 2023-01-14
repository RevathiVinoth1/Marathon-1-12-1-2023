package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option1=new ChromeOptions();
		option1.addArguments("---disable notifications");
		ChromeDriver driver=new ChromeDriver(option1);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		Thread.sleep(2000);
		WebElement opt = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		//opt.click();
		driver.executeScript("arguments[0].click();", opt);
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("Salesforce Automation By RevathiVinoth");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("1/13/2023");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		WebElement need = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", need);
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
	}

}
