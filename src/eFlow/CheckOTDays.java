package eFlow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckOTDays {

	public static List<String> getOTDays() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// ���õȴ�ʱ��,�������10s��û�в��ҵ���Ӧ��Ԫ������׳��쳣
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// ��ֹ���������session ����
		driver.get("http://cigp3r8cweb01.aia.biz/tcs/clock_checkrec.asp");
		driver.get(getTCSUrl());

		String winHandle = driver.getWindowHandle();
		System.out.println("default winhandle: " + winHandle);
		Set<String> winHandles = driver.getWindowHandles();
		System.out.println("window handles size: " + winHandles.size());
		for (String windowHandle : winHandles) {
			if (windowHandle.equals(winHandle)) {
				// driver.close();
				continue;
			} else {
				driver.switchTo().window(windowHandle);
			}
		}

		List<WebElement> days = driver.findElements(By
				.xpath("/html/body/p/table/tbody/tr"));

		// ��OT�����ڼ�¼��List��
		String date = null;
		String dateStr = null;
		String OTHourStr = null;
		String OTStr = null;
		List<String> OTDays = new ArrayList<String>();
		for (int day = 0; day < days.size() - 1; day++) {
			int index = day + 2;
			dateStr = "/html/body/p/table/tbody/tr[" + index + "]/td[1]";
			date = driver.findElement(By.xpath(dateStr)).getText();

			OTStr = "/html/body/p/table/tbody/tr[" + index + "]/td[6]";
			OTHourStr = driver.findElement(By.xpath(OTStr)).getText();

			if (OTHourStr == null || OTHourStr.equals("")
					|| OTHourStr.equals("     "))
				continue;
			if (Float.valueOf(OTHourStr) >= 2.0f) {
				OTDays.add(date);
			}
		}
		for (String dateItem : OTDays) {
			System.out.println(dateItem);
		}
		return OTDays;
	}

	public static String getTCSUrl() {
		// http://cigp3r8cweb01.aia.biz/tcs/clock_detail.asp?sLogonId=BSNPC1G&sDateFrom=04/01/2019&sDateTo=04/26/2019
		// �õ����µĵ�һ������һ��,ƴ�ӳ���ѯtcs��url
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String firstDay, lastDay;

		// ��ȡǰ�µĵ�һ��
		Calendar cale1 = Calendar.getInstance();
		cale1.add(Calendar.MONTH, 0);
		cale1.set(Calendar.DAY_OF_MONTH, 1);
		firstDay = sdf.format(cale1.getTime());

		// ��ȡǰ�µ����һ��
		Calendar cale2 = Calendar.getInstance();
		cale2.add(Calendar.MONTH, 1);
		cale2.set(Calendar.DAY_OF_MONTH, 0);
		lastDay = sdf.format(cale2.getTime());

		String OTDaysUrl = "http://cigp3r8cweb01.aia.biz/tcs/clock_detail.asp?sLogonId=BSNPC1G&sDateFrom="
				+ firstDay + "&sDateTo=" + lastDay;

		return OTDaysUrl;
	}
	
	
	@Test
	public void testGetOTDays(){
		System.out.println("success");
	}

}
