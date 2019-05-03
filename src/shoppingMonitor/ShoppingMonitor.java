package shoppingMonitor;

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
import org.openqa.selenium.interactions.Actions;

public class ShoppingMonitor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// 设置等待时间,如果超过10s后还没有查找到相应的元素则会抛出异常
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 打开淘宝首页
		driver.get("https://www.taobao.com/");
		
		// 点击购物车
		driver.findElement(By.id("mc-menu-hd")).click();
		
		// 此时如果没有登录那么点击快速登录
		driver.findElement(By.xpath("//i[@class='iconfont static']")).click();
		
		// 填写用户名及密码
		Actions actions = new Actions(driver);
		WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'会员名/邮箱/手机号')]"));
		actions.moveToElement(userName);
		actions.click();
		actions.sendKeys("15614631639");
		actions.build().perform();
		
		WebElement password = driver.findElement(By.xpath("//div[@class='field pwd-field']"));
		actions.moveToElement(password);
		actions.click();
		actions.sendKeys("15614631639");
		actions.build().perform();
//		
		// 点击登录
		driver.findElement(By.id("J_SubmitStatic")).click();
		
		// 可能要模拟滑动按钮...
		WebElement slideButton = driver.findElement(By.xpath("//span[@class='nc_iconfont btn_slide']"));
		WebElement slideWay = driver.findElement(By.xpath("//span[contains(text(), '请按住滑块，拖动到最右边')]"));
		actions.moveToElement(slideButton);
//		actions.dragAndDropBy(slideButton, slideWay.getLocation().x + slideWay.getSize().width, slideWay.getLocation().y);
//		actions.dragAndDropBy(slideButton, 258, 0);
//		Thread.sleep(200);
//		actions.clickAndHold(slideButton).moveByOffset(30, 0);
//		Thread.sleep(200);
//		actions.clickAndHold(slideButton).moveByOffset(40, 0);
//		Thread.sleep(150);
//		actions.clickAndHold(slideButton).moveByOffset(50, 0);
//		Thread.sleep(80);
//		actions.clickAndHold(slideButton).moveByOffset(60, 0);
//		Thread.sleep(70);
//		actions.clickAndHold(slideButton).moveByOffset(70, 0);
//		Thread.sleep(90);
//		actions.clickAndHold(slideButton).moveByOffset(8, 0);
//		Thread.sleep(66);
		
		actions.clickAndHold(slideButton).moveByOffset(30, 1).moveByOffset(40, 3).moveByOffset(50, 5).moveByOffset(60, 2).moveByOffset(70, 1).moveByOffset(8, 0);
		
		actions.release();
		
		actions.build().perform();
		
		
		// 开始遍历购物车
		String name;
		String number = null;
		float price;
		String shopName;
		String comment;
		List<Goods> prefers = new ArrayList<Goods>();
		List<WebElement> items = driver.findElements(By.id("//*[@id='J_OrderList']"));
		for (WebElement item:items){
			shopName = driver.findElement(By.xpath("./div/div[1]/div/a")).getText();
			name = driver.findElement(By.xpath("./div/div[2]/div/div/div/div/ul/li[2]")).getText();
			comment = driver.findElement(By.xpath("./div/div[2]/div/div/div/div/ul/li[3]")).getText();
			price = Float.valueOf(driver.findElement(By.xpath("./div/div[2]/div/div/div/div/ul/li[4]")).getText());
			Goods good = new Goods(name, number, price, shopName, comment);
			prefers.add(good);
		}
	}
//		// 切换窗口
//		String winHandle = driver.getWindowHandle();
//		System.out.println("default winhandle: " + winHandle);
//		Set<String> winHandles = driver.getWindowHandles();
//		System.out.println("window handles size: " + winHandles.size());
//		for (String windowHandle : winHandles) {
//			if (windowHandle.equals(winHandle)) {
//				// driver.close();
//				continue;
//			} else {
//				driver.switchTo().window(windowHandle);
//			}
//		}
//
//		List<WebElement> days = driver.findElements(By
//				.xpath("/html/body/p/table/tbody/tr"));
//
//		// 将OT的日期记录到List中
//		String date = null;
//		String dateStr = null;
//		String OTHourStr = null;
//		String OTStr = null;
//		List<String> OTDays = new ArrayList<String>();
//		for (int day = 0; day < days.size() - 1; day++) {
//			int index = day + 2;
//			dateStr = "/html/body/p/table/tbody/tr[" + index + "]/td[1]";
//			date = driver.findElement(By.xpath(dateStr)).getText();
//
//			OTStr = "/html/body/p/table/tbody/tr[" + index + "]/td[6]";
//			OTHourStr = driver.findElement(By.xpath(OTStr)).getText();
//
//			if (OTHourStr == null || OTHourStr.equals("")
//					|| OTHourStr.equals("     "))
//				continue;
//			if (Float.valueOf(OTHourStr) >= 2.0f) {
//				OTDays.add(date);
//			}
//		}
//		for (String dateItem : OTDays) {
//			System.out.println(dateItem);
//		}
//		return OTDays;
//	}

//	public static String getTCSUrl() {
//		// http://cigp3r8cweb01.aia.biz/tcs/clock_detail.asp?sLogonId=BSNPC1G&sDateFrom=04/01/2019&sDateTo=04/26/2019
//		// 得到当月的第一天和最后一天,拼接出查询tcs的url
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
//		String firstDay, lastDay;
//
//		// 获取前月的第一天
//		Calendar cale1 = Calendar.getInstance();
//		cale1.add(Calendar.MONTH, 0);
//		cale1.set(Calendar.DAY_OF_MONTH, 1);
//		firstDay = sdf.format(cale1.getTime());
//
//		// 获取前月的最后一天
//		Calendar cale2 = Calendar.getInstance();
//		cale2.add(Calendar.MONTH, 1);
//		cale2.set(Calendar.DAY_OF_MONTH, 0);
//		lastDay = sdf.format(cale2.getTime());
//
//		String OTDaysUrl = "http://cigp3r8cweb01.aia.biz/tcs/clock_detail.asp?sLogonId=BSNPC1G&sDateFrom="
//				+ firstDay + "&sDateTo=" + lastDay;
//
//		return OTDaysUrl;
//	}
	
	
	@Test
	public void testGetOTDays(){
		System.out.println("success");
	}

}
