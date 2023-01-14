package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bags {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		System.out.println(text);
		//String bag = text.getText();
		
		//WebElement text1 = driver.findElement(By.xpath("//span[text()='\"bags for boys"']"));
		//String bag1 = text1.getText();
		//System.out.println(bag+bag1);
		
		String text1 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]")).getText();
		System.out.println("Third Displayed Bag Name is:" +text1);
		
		Thread.sleep(2000);
		WebElement text3 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		driver.executeScript("arguments[0].click();",text3);
		WebElement text4 = driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		driver.executeScript("arguments[0].click();",text4);
		
		String text5 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		System.out.println(text5);
		
		if(text.equals(text5))
		{
			System.out.println("The result is not reduced ");
		}
		else
		{
			System.out.println("The result is reduced");
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		String text6 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
		System.out.println("The First Resulting Bag Name is:" +text6);
		
		String text7 = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText();
		System.out.println("The First Resulting Bag Dicount Price is:" +text7);
		}
	}
}
