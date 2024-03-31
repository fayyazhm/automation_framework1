package fayyaz.testcomponenets;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fayyaz.pageobjects.LandingPage;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.*;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.*;

public class BaseTest {
	
	public WebDriver driver;
	Properties prop;
	FileInputStream fis;
	public LandingPage landingpage;
	
	public 	WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\fayyaz\\resources\\globaldata.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
//			ChromeOptions options =new ChromeOptions();
//			options.addArguments("headless");	
			driver=new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1440,900));
		
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		landingpage=new LandingPage(driver);
		String url1=prop.getProperty("url");
		landingpage.go(url1);
		System.out.println("inside baseTest");
		return landingpage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void clos() {
		driver.close();
	}
	
	public List<HashMap<String,String>> getJsonToHashMap(String path) throws IOException {
		
		String jsoncontent = FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
		FileUtils.copyFile(source, dest);
		return dest.getPath();
	}

	
}
