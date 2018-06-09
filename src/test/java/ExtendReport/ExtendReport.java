package ExtendReport;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtendReport {


		WebDriver	driver;
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent ;
		ExtentTest test;
		@BeforeTest
		public void f()
		{
			
			htmlReporter = new ExtentHtmlReporter("SeleniumExtent.html");//html blank file
			
			extent= new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			test = extent.createTest("MyFirstTest");
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver= new ChromeDriver();
			test.pass("Started the browser");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			driver.get("http://opensource.demo.orangehrmlive.com/");
			test.fail("Opened the URL");
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		}
		
		@Test
		public void t()
		{

			driver.findElement(By.id("txtUsername")).sendKeys("Admin");	//20
			test.error("Entered the UserName");
			
			driver.findElement(By.id("txtPassword")).sendKeys("admin");//20		
			test.warning("Entered the Password");
			
			try {
				driver.findElement(By.id("btnLog")).click();
				test.pass("Succssfully Clicked login Button");
			} catch (Exception e) {
				test.error("login Button has some problem");
			}
			
		}
		@AfterTest
		public void aft()
		{
			extent.flush();
			driver.quit();
		}

	}


