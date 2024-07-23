import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.guvi.in/");
		
		System.out.println("Validate Landed on correct page");
		
		String expTitle= "GUVI | Learn to code";
		
		String atulTitle =driver.getTitle();
		
		if (atulTitle.contains(expTitle)) {
			System.out.println("Landed on Correct page");
			
			driver.findElement(By.xpath("//a[text()='Sign up']")).click();
			System.out.println("Validate signup page");
			String SupExpTitle = "Sign Up";
			String SupAtulTitle = driver.getTitle();
			if (SupAtulTitle.contains(SupExpTitle)) {
				System.out.println("User is on SignUP Page");
				Thread.sleep(3000);
				driver.findElement(By.id("name")).sendKeys("Gokul");
				driver.findElement(By.id("email")).sendKeys("Gokul@gmail.com");
				Thread.sleep(3000);
				driver.findElement(By.id("password")).sendKeys("Passw0rd");
				driver.findElement(By.id("mobileNumber")).sendKeys("9750008345");
				Thread.sleep(3000);
				driver.findElement(By.id("signup-btn")).click();
				
				System.out.println("Validate Login Page");
				driver.findElement(By.xpath("//a[text()='Login']")).click();
				String logExpTitle ="login";
				String logAtulTitle = driver.getTitle();
				
				if (logAtulTitle.contains(logExpTitle)) {
					System.out.println("User is Login Page");
					
					System.out.println("Validate Login Page");
					driver.findElement(By.id("email")).sendKeys("Gokul@gmail.com");
					Thread.sleep(3000);
					driver.findElement(By.id("password")).sendKeys("Passw0rd");
					
					driver.findElement(By.id("login-btn")).click();
					
					System.out.println("Since Dummy values are given so not logged in");
				}else {
					System.out.println("User is not on Login Page");
				}
				
			}else {
				System.out.println("User is not on Signup Page");
			}
			
		}else {
			System.out.println("please enter correct URL");
		}
		

	}

}
