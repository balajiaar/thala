package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Admin
 * @Date 06/12/2022
 *@see Mention the Reuseable methods in Base Class
 *
 */
public class BaseClass {
	public static WebDriver driver;
	
	/**
	 * 
	 * @return Current Project Path
	 * @date 06/12/2022
	 * @see To maintain the Current project path
	 */
	public static String getProjectPath() {
String path = System.getProperty("user.dir");
return path;
	}
	/**
	 * 
	 * @return byte[]
	 * @Date 06/12/2022
	 * @see To Take screenshot and attach to Scenario
	 */
	public byte[] screenshotInBytes() {
TakesScreenshot screenshot= (TakesScreenshot)driver;
byte[] bytes = screenshot.getScreenshotAs(OutputType.BYTES);
return bytes;
	}
	
	/**
	 * 
	 * @param Input the key from property file
	 * @return Get the value from property file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see To perform getPropertyFileValue
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
Properties properties = new Properties();
properties.load(new FileInputStream(getProjectPath()+"\\Config\\Config.properties"));
Object object = properties.get(key);
String value = (String)object;
return value;

	}
	/**
	 * 
	 * @param browser
	 * @Date 06/12/2022
	 * @See To Launch the particular WebDriver (Browser)
	 */
	
	public static void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

		default:
			break;
		}
	}
	/**
	 * 
	 * @param name (Locator by using Name)
	 * @return WebElement
	 * @Date 06/12/2022
	 * @see  To find the element by using name 
	 */
	public WebElement findElementByName(String name) {
WebElement element = driver.findElement(By.name(name));
return element;
	}
	public WebElement findElementByClaseName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
			}

	public static void appUrl(String name) {
driver.get(name);
	}
	public WebElement findElementByXpath(String xpathValue) {
		WebElement element = driver.findElement(By.xpath(xpathValue));
		return element;
			}
	public String getCurrentUrl() {
String element = driver.getCurrentUrl();
		return element;
			}
	public String getAttributeValue(WebElement element) {
String text = element.getAttribute("value");
		return text;	
			}
	public String getAttributeValue(WebElement element,String value) {
		String text = element.getAttribute(value);
				return text;
	}
	public void closeCurrentWindow() {
		driver.close();
	}
	public static void closeAllWindow() {
		driver.quit();
	}
	public String getText(WebElement element) {
		String text = element.getText();
				return text;	
					}
	
	public static void getChromeDriver() {
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
	}
	public static void getFireFoxDriver() {
WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();
	}
	public static void getEdgeDriver() {
WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();
	}
	public static void maximize() {
driver.manage().window().maximize();
	}
	public void sendKeys(WebElement element,String name) {
element.sendKeys(name);
	}
	public void sendKeysJs(WebElement element, String data) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
	}
	public void clickTheBtnJs(WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", element);
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void sendKeysWithEnter(WebElement element,String name) {
		element.sendKeys(name,Keys.ENTER);

	}
	public WebElement findElementById(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
			}
	public void selectOptionByText(WebElement element, String name) {
		Select s = new Select(element);
		s.selectByVisibleText(name);
	}
	public void selectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);		
	}
	public void getAllOptions(WebElement element) {///////// dought
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			options.get(i);
			
		}
		
	}
	public void alertOk() {
Alert a = driver.switchTo().alert();
a.accept();
	}
	public void alertCancel() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	public String getTextFromWebpage(WebElement element) {
String text = element.getText();
return text;
	}
	public void deSelectByValue (WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	public void deSelectByIndex (WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	public void deSelectByText (WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	public void deSelectAll (WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	public boolean isMultiple (WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public boolean verifyIsDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean verifyIsEnable(WebElement element) {
		boolean displayed = element.isEnabled();
		return displayed;
	}
	public boolean verifyIsSelected(WebElement element) {
		boolean displayed = element.isSelected();
		return displayed;
	}
	
	public void mouseOverAction(WebElement element,String name) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.xpath(name)).click();
	}
	public void dragAndDrop(WebElement value,WebElement value2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(value, value2).perform();
	}
	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();//35
	}
	
	public void screenshot(String path) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}
	public void frameid(String id) {
		driver.switchTo().frame(id);
	}
	public void frameelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void frameindex(int index) {
		driver.switchTo().frame(index);
	}
	public void parentframe() {
		driver.switchTo().parentFrame(); 													
	}
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
	public void childWindow() {
		String parent = driver.getWindowHandle();
		Set<String>both = driver.getWindowHandles();
		for (String x : both) {
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
			}
			}
		}
	public void backToParentWindow() {
		String parent = driver.getWindowHandle();
		Set<String>both = driver.getWindowHandles();
		for (String x : both) {
			if(parent.equals(x)) {
				driver.switchTo().window(x);
			}
			}
		}
	
	public void jsscrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(true)",element);
	}
	public void jsscrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(false)",element);
	}
	public void implicitywait(int no) {
		driver.manage().timeouts().implicitlyWait(no,TimeUnit.SECONDS);
	}
	public void pressKey(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);

	}
	public void releaseKey(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);

	}
	public String readDatafromCell(String sheetName, int rownum, int cellno) throws IOException {
		File file = new File("C:\\Users\\Admin\\framework\\Framework11Am\\Excel\\Excel.xlsx");
		File file1 = new File("C:\\Users\\Admin\\framework\\Framework11Am\\Excel\\excel 2.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellno);
		CellType cellType = cell.getCellType();
		 String res = "";
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyy");
				res = dataFormat.format(dateCellValue);
				
			}else {
				
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round==numericCellValue) {
					res = String.valueOf(round);
				} else {
		res = String.valueOf(numericCellValue);
				}		
			}
		default:
			break;
		}
		return res;
		}
	public void writeCellData(String sheetName, int rowNum,int cellNum, String data) 
			throws IOException {
File file = new File("C:\\Users\\Admin\\framework\\Framework11Am\\Excel\\Excel.xlsx");
File file1 = new File("C:\\Users\\Admin\\framework\\Framework11Am\\Excel\\excel 2.xlsx");
FileInputStream fileInputStream = new FileInputStream(file);
Workbook workbook1 = new XSSFWorkbook(fileInputStream);
Sheet sheet = workbook1.getSheet(sheetName);
Row row = sheet.getRow(rowNum);
Cell cell = row.createCell(cellNum);
cell.setCellValue(data);
FileOutputStream fileOutputStream= new FileOutputStream(file);
workbook1.write(fileOutputStream);
	}
	
	public void rightClick1(WebElement element) {
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
	}
	
}
