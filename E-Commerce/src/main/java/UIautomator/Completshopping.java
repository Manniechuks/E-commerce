package UIautomator;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Completshopping extends BaseClassUiAutomator{

	@Test
	public void AddToCart() throws InterruptedException {
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("King Mannie");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		//OR
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART']) [1]")).click();
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART']) [1]")).click();

			 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			 Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
	//List <WebElement> Productprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	//int Count = Productprices.size();
	//double totalSum=0;
	//for (int i=0; i<Count; i++)
	//{
		//String amountString = Productprices.get(i).getText();
		//Double price = Double.parseDouble(amountString.substring(1)); //can use this or
		//Double price = getActualAmount(amountString);					//this
		//totalSum = totalSum + price; //160.97 + 120 =280.97
	//}
	
	//String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	//Double displayActualSum = getActualAmount(displaySum);
	//Assert.assertEquals(totalSum, displayActualSum);
	
	//WebElement element= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	//LongPressAction(element);
	//driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(6000);
	
	//Hybrid --> when app takes you to a web page but still on the app
	
	Set <String> contexts =driver.getContextHandles();
	for(String contextName :contexts)
	{
		System.out.println(contextName);
	}
	
	Thread.sleep(10000);
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.context("WEBVIEW_chrome");
	driver.findElement(By.id("input")).sendKeys("paystack");
	driver.findElement(By.id("input")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	
	
	
	}
	
}
