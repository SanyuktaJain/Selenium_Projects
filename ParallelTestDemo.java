package SeleniumPrograms;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

	//import io.github.bonigarcia.wdm.WebDriverManager;
	//import junit.framework.Assert;

	public class ParallelTestDemo {
		WebDriver driver;
		@Test 
		public void verifyTittle() {
			System.setProperty("wbdriver.chrome.driver", "E:\\sanyukta_workspace\\chromedriver-win64\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
			driver.get("https://www.saucedemo.com/v1/");
			
			Assert.assertEquals(driver.getTitle(), "Swag Labs");
			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			driver.quit();
		}}

		@Test 
		public void verifyLogo() {
			System.setProperty("wbdriver.chrome.driver", "E:\\sanyukta_workspace\\chromedriver-win64\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
			driver.get("https://www.saucedemo.com/v1/");
			
			//Assert.assertEquals(driver.getTitle(), "Swag Labs");
			
			WebElement logo=  driver.findElement(By.xpath("//div[@class='login_logo']"));
			
			Assert.assertTrue(logo.isDisplayed());
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.quit();
			
		}

	}



