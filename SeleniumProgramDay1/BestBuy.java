package Selenium90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BestBuy {
	
	@Test
	public void TC01() throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("(//img[@alt='United States'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[@class='c-close-icon  c-modal-close-icon']").click();		
		Thread.sleep(2000);
		driver.findElementByXPath("//nav[@class='global-navigation']/ul/li[1]").click();
		driver.findElementByXPath("//button[text()='Cell Phones']").click();
		driver.findElementByXPath("//button[@data-lid='ubr_mob_ip']").click();
		driver.findElementByXPath("//a[@data-lid='ubr_mob_ip_se']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//button[@data-rtb-selected-sku='6389069']//span)[2]").click();
		driver.findElementByXPath("//a[@data-track='LP_Continue_iPhone_XS']").click();
		Thread.sleep(1000);
		
		driver.findElementByXPath("//button[@id='variaton-dropdown-Cell_Phones_Internal_Memory']").click();
		driver.findElementByXPath("//a[@id='variations-dropdown-item-Cell_Phones_Internal_Memory-128GB']").click();
		WebElement AddCart = driver.findElementByXPath("//button[text()='Add to Cart']");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", AddCart);
		AddCart.click();
		driver.findElementByXPath("//button[@data-track='activate-later']").click();
		String price1 = driver.findElementByXPath("(//span[@class='carriers-page__carrier-choice-button-pricing'])[4]").getText();
		System.out.println("Product price is : " +price1);
		driver.findElementByXPath("//span[text()='Add to Cart']").click();
		Thread.sleep(2000);
		String price2 = driver.findElementByXPath("//div[@class='price-block__primary-price']").getText();
		System.out.println("Product price is : " +price2);
		
		if (price1.equals(price2)) {
			
			System.out.println("Product prices are same");
			
		} else {
			
			System.out.println("Product prices are not same");

		}
		
		driver.findElementByXPath("//button[text()='Checkout']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Sign In']").click();
		String actualResult = driver.findElementByXPath("//span[@id='fld-e-text']").getText();
		String expectedResult = "Please enter a valid email address.";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Assert Passed");
		driver.close();
		
	}

}
