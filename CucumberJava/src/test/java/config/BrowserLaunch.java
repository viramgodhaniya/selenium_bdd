package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserLaunch {

	public static String EXECUTION_SETTINGS_PATH = "src/test/resources/execution.properties";
	public static String CHROME_DRIVER_PATH;
	public static String IE_DRIVER_PATH;
	public static String EXECUTION_BROWSER;
	public static String CODE_VERSION;
	public static String EXECUTION_ENV;
	public static WebDriver driver;

	public BrowserLaunch(){
		Properties prop = new Properties();
		File executionFile = new File(EXECUTION_SETTINGS_PATH);
		FileInputStream executionFileStream = null;
		try {
			executionFileStream = new FileInputStream(executionFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(executionFileStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CHROME_DRIVER_PATH = prop.getProperty("chrome.driver.path");
		EXECUTION_BROWSER = prop.getProperty("default.browser");
		CODE_VERSION = prop.getProperty("code.version");
		IE_DRIVER_PATH = prop.getProperty("ie.driver.path");
		EXECUTION_ENV = prop.getProperty("execution.env");

	}

	public WebDriver launch(){
		
		switch (EXECUTION_BROWSER) {
		case "chrome":
			return launchChromeDriver();	
		
		case "ie":
			return launchIeDriver();

		default:
			return launchChromeDriver();			
		}
		
	}

	public static WebDriver launchChromeDriver(){
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();			
		return driver;
	}
	
	public static WebDriver launchIeDriver(){
		System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
		driver = new InternetExplorerDriver();
		return driver;
	}

	public void quitDriver(){
		driver.quit();
	}
	
}
