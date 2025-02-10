package SeleniumPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG8 {
	WebDriver driver;
	
	@BeforeClass
	public void setEnv() {
		// setting the propertie of chrome browser and passing  chrom driver path
		System.setProperty("wbdriver.chrome.driver", "E:\\sanyukta_workspace\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();// launching browser instance
		
		//maximize window
		driver.manage().window().maximize();
		
		//use implicit wait and open URl
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait syntax
		driver.get("https://www.facebook.com/");//open URL
	}
		
		//get current  time and date 
		public String getDateAndTime(){
			DateTimeFormatter currentDateAndTime=DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
			LocalDateTime now=LocalDateTime.now();
			return currentDateAndTime.format(now);
			
		}
		@DataProvider
		public Object[][]dataset() throws IOException{
			
			// specify of the location of properties file 
			File src =new File("E:\\sanyukta_workspace\\Online_Java_Training_10_March_2024\\Repository\\Object_Repo.properties");
			
			//create filestream class object to load the file 
			FileInputStream fis= new FileInputStream(src);
			
			//create properties class object to read properties files
			Properties pro= new Properties();
			pro.load(fis);
			
			Object arr[][]=new Object[3][2];
			
			TestNG8 tg8=new TestNG8();
			
			arr[0][0]=pro.getProperty("EmailTestData") + " " +getDateAndTime();
			arr[0][0]=pro.getProperty("PasswordTestData") ;
			
			arr[1][0]= "Email_1";
			arr[1][1]="Password_1";
			
			arr[2][0]= "Email_2";
			arr[2][1]="Password_2";
			
			return arr;
		}
		@Test (dataProvider="dataset")
			public void enterData(String Username, String password ) throws Exception{
				Thread.sleep(2000);
				driver.findElement(By.id("email")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("pass")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys(Username);
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.xpath("login")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				
				
			
		}
	}


