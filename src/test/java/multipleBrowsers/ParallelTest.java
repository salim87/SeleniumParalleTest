package multipleBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver;
	
	@Test
	public void fireFoxTest() {
		System.out.println("Firefox" +Thread.currentThread().getId());
		driver= new FirefoxDriver();
		driver.get("https://demoqa.com/");
	}
	
	@Test(invocationCount = 4, enabled=false)
	public void chromeTest() {
		System.out.println("Chrome" +Thread.currentThread().getId());
		driver= new ChromeDriver();
		driver.get("https://demoqa.com/");
	}
}
