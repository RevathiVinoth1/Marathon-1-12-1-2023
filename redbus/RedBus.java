package redbus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch=new ChromeOptions();
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='122']")).click();
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		driver.findElement(By.xpath("//table//tr//td[@class='current day']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		//Thread.sleep(2000);
		WebElement bus = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']"));
		String bus1 = bus.getText();
		//driver.executeScript("arguments[0].click();",bus);
		System.out.println(bus1);
		Thread.sleep(500);
		WebElement sleeper = driver.findElement(By.xpath("//label[@title='SLEEPER']"));
		driver.executeScript("arguments[0].click();", sleeper);
		//sleeper.click();
		WebElement bus2 = driver.findElement(By.xpath("//div[contains(@class,'travels lh-24')]"));
		String bus3 = bus2.getText();
		System.out.println(bus3);
		WebElement view = driver.findElement(By.xpath("(//div[text()='View Seats'])[2]"));
		driver.executeScript("arguments[0].click();", view);
		WebElement seat = driver.findElement(By.xpath("(//div[@class='seat-left m-top-30'])[1]"));
		String seat1 = seat.getText();
		System.out.println(seat1);
	}

}
