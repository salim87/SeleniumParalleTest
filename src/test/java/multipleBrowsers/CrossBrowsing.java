package multipleBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsing {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void openInMultipleBrowsers(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver(); 
			
		}
    	driver.get("https://demoqa.com/");
	}
	@Test
	public void runInChrome() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[normalize-space()='Book Store Application']")).click();
	}
	
	@Test
	public void runInFirefox() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[normalize-space()='Book Store Application']")).click();
	}

	@Test
	public void runInEdge() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[normalize-space()='Book Store Application']")).click();
	}
}
