package dataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DataReading {
	
	WebDriver driver;
	
	
	@Test(dataProvider="userIdAndPassword")
	public void readData(String userName, String password) throws InterruptedException {
		
		driver= new ChromeDriver();
		driver.get("https://demoqa.com/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='login']")).click();
		
		driver.close();
	}

	//@DataProvider(name="UserId-Password")
	public Object[][] userId() {
		return new Object[][] {{"edgetechnow", "QaBatch@23"}, 
								{"EdgeTechNow", "QaBatch"}};
	}
	
	@DataProvider(name="userIdAndPassword")
	public Iterator<String[]> readDataCSVFile(){
		return readFromCSVFile(filePath).iterator();
	}
	
	String filePath= System.getProperty("user.dir")+ "/src/test/resources/DataSelenium.csv";
	
	@Test
	public void readDataFromCSV() throws IOException, CsvException {
		
		
		List<String[]> data = readFromCSVFile(filePath);
		for (String[] row : data) {
			System.out.println(Arrays.toString(row));
		}
		
	}
	
	private List<String[]> readFromCSVFile(String csvFilePath) {
		try {
			FileReader fs = new FileReader(csvFilePath);
			CSVReader reader = new CSVReader(fs);
			List<String[]> data = reader.readAll();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
