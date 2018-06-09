package TestLog4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Log4jPractice {

		static Logger logx = Logger.getLogger(Log4jPractice.class);

		@Test
		public void f() {
			// BasicConfigurator.configure();

			PropertyConfigurator.configure("src/test/resources/log4j.properties");

			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			logx.info("opened browser");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			driver.get("http://opensource.demo.orangehrmlive.com/");
			logx.warn("opened the URL successfully");

			driver.manage().window().maximize();	
			logx.fatal("browser max");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

			driver.findElement(By.id("txtUsername")).sendKeys("Admin");	//20
			logx.debug("user entered userNAme");

			driver.findElement(By.id("txtPassword")).sendKeys("admin");//20		
			logx.info("user entered password");

			try {
				driver.findElement(By.id("btnLog")).click();
				logx.info("clicked on login button");
			} catch (Exception e) {
				logx.error("Failed to click login button");
			}


			driver.quit();
			logx.info("browser closed");

		}

	}


