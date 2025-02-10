	package SeleniumPrograms;

		import java.io.File;
		import java.io.FileInputStream;
		import java.io.IOException;
		import java.time.Duration;
		import java.util.Properties;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;

		public class ObjectRepository {

			public static void main(String[] args) throws IOException, InterruptedException {
				// TODO Auto-generated method stub
		// specify of the location of properties file 
				File src =new File("E:\\sanyukta_workspace\\Online_Java_Training_10_March_2024\\Repository\\Object_Repo.properties");
				
				//create filestream class object to load the file 
				FileInputStream fis= new FileInputStream(src);
				
				//create properties class object to read properties files
				Properties pro= new Properties();
				pro.load(fis);
				
				
				// setting the propertie of chrome browser and passing  chrom driver path
				System.setProperty("wbdriver.chrome.driver", "E:\\sanyukta_workspace\\chromedriver-win64\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();// launching browser instance
				
				//maximize window
				driver.manage().window().maximize();
				
				//use implicit wait and open URl
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait syntax
				driver.get(pro.getProperty("URL"));//open URL
				
				//getproperty method accept key and it returns value for the  same key
				driver.findElement(By.xpath(pro.getProperty("Email"))).sendKeys(pro.getProperty("EmailTestData"));
				driver.findElement(By.xpath(pro.getProperty("Password"))).sendKeys(pro.getProperty("PasswordTestData"));
				Thread.sleep(2000);
				driver.quit();
				
				
				
				
				
			}

		

	}

}
