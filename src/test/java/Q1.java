import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		Thread.sleep(3000);
		
		WebElement iframeElement=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframeElement);
		WebElement datebox =driver.findElement(By.id("datepicker"));
		datebox.click();
		driver.findElement(By.xpath("//a[@data-date='22']")).click();
		
		String DateText=datebox.getAttribute("value");		
	//	driver.findElement(By.xpath("//input[@class='hasDatepicker']")).getAttribute("value");
		
		System.out.println(DateText);
		
		driver.close();
		
		


	}

}
