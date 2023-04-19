package TestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;


public class BaseTest {

	public WebDriver driver;
	public HomePage homePage;
	Properties prop = new Properties();
	
	public WebDriver initializeDriver() throws IOException

	{
		// properties class
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
				
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
	
		//prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
	 				+ "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
	     	
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
	 				+"\\src\\main\\java\\resources\\geckodriver.exe");
			//DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.setCapability("webdriver.gecko.driver", true);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new FirefoxDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
	 				+"//src//main//java//resources//msedgedriver.exe");
			driver = new EdgeDriver();
			//driver.get(url);
		}
		
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();	
		 return driver;

	}
	
	@BeforeMethod
	public HomePage launchApplication() throws IOException
	{
		
		 driver = initializeDriver();
		 homePage = new HomePage(driver);
		 FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")
					+ "//src//main//java//resources//GlobalData.properties");
			prop.load(fis1);
		 String url = System.getProperty("url")!=null ? System.getProperty("url") :prop.getProperty("url");
		 homePage.goTo(url);
		 return homePage;
	
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		driver.close();
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	public static String generateRandomEmail() {	   
	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
	    String email = "";
	    String temp = RandomStringUtils.random(19, allowedChars);
	    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
	    return email;
	}
	
	public static String generateRandomUsername() {	   
	    String allowedChars = "abcdefghijklmnopqrstuvwxyz";
	    String username = "";
	    String temp = RandomStringUtils.random(19, allowedChars);
	    username = temp.substring(0, temp.length() - 9);
	    return username;
	}
}
