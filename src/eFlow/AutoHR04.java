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

		// ������������������Ļ�����Ҫ��IE��security ����������Ϊһ�µ�, ��Ϊ����û��Ȩ�޸���������������д������
		// ע��,������ʽҲ������ͬ,���ǵ����Ĵ��������ַ�ʽ��
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		File file = new File("D:\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver(capabilities);

		// ���ȴ�10s,����10s�����Ҳ�����ӦԪ����ô�ͻ��׳��쳣
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://cangzpwwas02.aia.biz/eflow/logonAction.it?method=logOn");

		// click the "�������", ��Ҫ���л���menu frame, ����Ժ��л�����
		driver.switchTo().frame("menu");
		// �����chrome�򿪵Ļ���Ĭ��Ӣ�ĵ�,IE�����ĵ�
		// driver.findElement(By.xpath("//font[contains(text(), 'New Form')]"))
		// .click();
		driver.findElement(By.xpath("//font[contains(text(), '�������')]"))
				.click();
		driver.switchTo().defaultContent();

		// click on the HR-04, ��Ҫ���л���main frame, ����Ժ��л�����
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
			// click on the Add, ��Ҫ���л���main frame
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
