package unlockLoginId;

import java.util.Set;

import org.apache.http.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebDriver {
	public static void main(String[] args) throws ParseException,
			InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().
		driver.get("http://mss-portal.aia.biz/smw/");

		driver.findElement(By.id("btnAddNewRequest")).click();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		String winHandle1 = driver.getWindowHandle();
		System.out.println("default winhandle: " + winHandle1);
		Set<String> winHandles = driver.getWindowHandles();
		System.out.println("window handles size: " + winHandles.size());
		for (String windowHandle : winHandles) {
			if (windowHandle.equals(winHandle1)) {
				// driver.close();
				continue;
			} else {
				driver.switchTo().window(windowHandle);
			}
		}

		Thread.sleep(300);
		driver.findElement(
				By.xpath("//*[@id='div_step_one']/div[3]/div[2]/input"))
				.click();

		// check the row of defined user
		Thread.sleep(300);
		WebElement row = driver.findElement(By.xpath("//input[@value='David-YW.Li@aia.com']/../../div[1]"));
		System.out.println(row.getTagName());
		System.out.println(row.getAttribute("type"));
		row.click();
		
		// click on the Add -->
		Thread.sleep(300);
		driver.findElement(
				By.xpath("//*[@id='div_step_two']/div[2]/div[2]/input[2]"))
				.click();
		
		
		// click Next
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//*[@id='div_step_two']/div[3]/input[2]"))
				.click();
		
		// check the item in Service List
		Thread.sleep(1000);
		WebElement seviceRow = driver.findElement(By.xpath("//td[contains(text(), 'Logon ID Reset')]/../td[1]"));
		System.out.println(seviceRow.getTagName());
		System.out.println(seviceRow.getAttribute("type"));
		seviceRow.click();
		
		// check the item in Service Unit List
		Thread.sleep(1000);
		WebElement seviceUnitRow = driver.findElement(By.xpath("//td[contains(text(), 'Logon ID Reset - LAN ID Unlock/Password Reset')]/../td[1]"));
		System.out.println(seviceUnitRow.getTagName());
		System.out.println(seviceUnitRow.getAttribute("type"));
		seviceUnitRow.click();
//
		// click on the Next
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='div_step_three']/div[6]/input[2]"))
				.click();
		
		
		// switch to the new window
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		String winHandle2 = driver.getWindowHandle();
		System.out.println("default winhandle: " + winHandle2);
		winHandles = driver.getWindowHandles();
		System.out.println("window handles size: " + winHandles.size());
		for (String windowHandle : winHandles) {
			if (windowHandle.equals(winHandle1) || windowHandle.equals(winHandle2)) {
				// driver.close();
				continue;
			} else {
				driver.switchTo().window(windowHandle);
			}
		}
		
		
		// check the Request To Unlock
		Thread.sleep(300);
		driver.findElement(By.xpath("//th[contains(text(), 'Request To Unlock')]/../td[2]/div[1]/div[1]/input"))
				.click();
//		
		// check Next >>
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		
		// click submit
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id='main']/form/p/input[8]")).click();
	}

}
