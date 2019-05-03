package eFlow;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.ParseException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutoHR04 {
	public static void raiseRequest(List<String> OTDays) throws ParseException,
			InterruptedException {

		// open with chrome
		// System.setProperty("webdriver.ie.driver",
		// "D:\\new_chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		// // open with IE
		// System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
		// WebDriver driver = new InternetExplorerDriver();

		// 如果不加下面的这两句的话就需要把IE的security 四项设置设为一致的, 因为现在没有权限改所以用下面的两行代码替代
		// 注意,启动方式也有所不同,不是单纯的打开驱动那种方式了
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		File file = new File("D:\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver(capabilities);

		// 最多等待10s,超过10s后仍找不到对应元素那么就回抛出异常
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://cangzpwwas02.aia.biz/eflow/logonAction.it?method=logOn");

		// click the "可申请表单", 需要先切换到menu frame, 完成以后切换回来
		driver.switchTo().frame("menu");
		// 如果用chrome打开的话是默认英文的,IE是中文的
		// driver.findElement(By.xpath("//font[contains(text(), 'New Form')]"))
		// .click();
		driver.findElement(By.xpath("//font[contains(text(), '可申请表单')]"))
				.click();
		driver.switchTo().defaultContent();

		// click on the HR-04, 需要先切换到main frame, 完成以后切换回来
		// Thread.sleep(1000);
		driver.switchTo().frame("main");
		driver.findElement(By.xpath("//a[contains(text(), 'HR-04')]")).click();
		driver.switchTo().defaultContent();

		// fill out the form
		Actions actions = new Actions(driver);
		String dateStr = null;
		WebElement date = null;
		String reasonStr = null;
		WebElement reason = null;

		driver.switchTo().frame("main");
		for (int day = 2; day < OTDays.size() + 2; day++) {
			// click on the Add, 需要先切换到main frame
			driver.findElement(By.xpath("//input[@name='addRowBtn']")).click();

			// fill in the date
			dateStr = "//*[@id='formTable02']/tbody/tr[" + day + "]/td[2]";
			date = driver.findElement(By.xpath(dateStr));
			actions.moveToElement(date);
			actions.click();
			actions.sendKeys(OTDays.get(day - 2));
			actions.build().perform();

			// fill in the reason
			reasonStr = "//*[@id='formTable02']/tbody/tr[" + day + "]/td[3]";
			reason = driver.findElement(By.xpath(reasonStr));
			actions.moveToElement(reason);
			actions.click();
			actions.sendKeys("OT");
			actions.build().perform();
		}

		// Submit Form
		driver.findElement(
				By.xpath("//*[@id='thedetailtableDIV']/table[2]/tbody/tr/td/input[2]"))
				.click();
	}

	
	@Test
	public void testRaiseRequest(){
		System.out.println("success");
	}
	
}
