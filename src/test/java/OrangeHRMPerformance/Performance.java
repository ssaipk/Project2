package OrangeHRMPerformance;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Performance {

	public WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(priority = 1)
	public void login() {
		try {
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[text()=' Login ']")).click();
			Thread.sleep(1000);
			Alert a1=driver.switchTo().alert();
			a1.accept();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 2)
	public void performace() {
		try {
			//Click on Performance
			driver.findElement(By.xpath("//span[text()='Performance']")).click();
			Thread.sleep(1000);
			
			//Click on Configure
			driver.findElement(By.xpath("//span[text()='Configure ']")).click();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 3)
	public void configure() {
		try {
			driver.findElement(By.linkText("KPIs")).click();
			
		    //Select jobTitle	=new Select(driver.findElement(By.xpath("//div[text()='-- Select --']")));
		    //Thread.sleep(1000);
		    //jobTitle.selectByVisibleText("Account Assistant");
		   
		    
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 4)
	public void KPIs() {
		try {
			driver.findElement(By.xpath("//button[text()=' Add ']")).click();
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("1");
			Select title=new Select(driver.findElement(By.xpath("//div[text()='-- Select --']")));
			title.selectByVisibleText("Account Assistant");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("0");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]")).sendKeys("99");
			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
