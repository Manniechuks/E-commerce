package UIautomator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClassUiAutomator {
 public AndroidDriver driver;

	
	@BeforeClass
	public void CreateAccount() throws MalformedURLException {
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Phone");
		options.setApp("C:\\Users\\user\\eclipse-workspace\\E-Commerce\\src\\main\\java\\Resource\\General-Store.apk");
		options.setChromedriverExecutable("C:\\\\Users\\\\user\\\\Downloads\\\\chromedriver83.30\\\\chromedriver.exe");
		//options.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		options.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
		
	public void LongPressAction(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"duration",2000));
	}
	
	public void SwipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement)element).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
	}
	
	public void DragandDropAction(WebElement source) {
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 100,
			    "endY", 100
			));
	}

		public Double getActualAmount(String amount) {
			
			Double price = Double.parseDouble(amount.substring(1));
			return price;
		}
	
	@AfterClass
		public void tearDown()
		{
		
			driver.quit();
			//service.stop();
		}
			
		
		
		
		
		
		
		
	
}
