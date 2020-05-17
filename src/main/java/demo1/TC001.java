package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC001 {
	
	@Test
	public void runTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://game.testleaf.com/");
		
		new Select(driver.findElementById("selectGameSize")).selectByVisibleText("2 Matches");
		Thread.sleep(2000);
		
		List<WebElement> allBoard = driver.findElementsByXPath("(//div[@id='game-board'])/div/div");
		
		allBoard.get(0).click();
		Thread.sleep(2000);
		String value = allBoard.get(0).getAttribute("class");
		
		for (int i = 1; i <= allBoard.size(); i++) {
			allBoard.get(i).click();
			Thread.sleep(2000);
			String value1 = allBoard.get(i).getAttribute("class");
			if(value.equals(value1)) {
				System.out.println("card number "+i+" matched");
				break;
			}
		}
		
	
		
		//driver.close();
		
		
	}

}
