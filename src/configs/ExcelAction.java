package configs;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static executionEngine.DriverscriptEngine.pro;

 
public class ExcelAction {
 
		public static WebDriver driver;
		public static File file;
		private static long lngPageLoadTimeOut;
		private static long lngElementDetectionTimeOut;
		public static WebDriverWait wait;
		
		public static void open_Browser(String object, String value){
			try{
				
				switch (getBrowserTypeIndexed(value)) {
				case 1:
					file = new File("D:\\DevTools\\geckodriver\\geckodriver.exe");
					System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
					driver = new FirefoxDriver();
					break;
				case 2:
					
					System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
				//	driver = new InternetExplorerFilter();
					break;
					
				case 3:
					file = new File("D:\\DevTools\\geckodriver\\geckodriver.exe");
					System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
					
					file = new File("D:\\DevTools\\chromedriver\\chromedriver.exe");
					System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
					driver = new ChromeDriver();
					break;
				default:
					throw new Exception("Unknow Browser Type = "+ value);
					
				}
							
				if(value.isEmpty()){
				
					value = "about:blank";
					}
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(lngPageLoadTimeOut, TimeUnit.SECONDS);
				
				driver.manage().timeouts().implicitlyWait(lngElementDetectionTimeOut, TimeUnit.SECONDS);
				
				
				Thread.sleep(2000);
				
				
			} catch (Throwable t){
				t.printStackTrace();
			}
		}
				
		
		private static int getBrowserTypeIndexed(String sBrowserType){
			sBrowserType = sBrowserType.toLowerCase().trim();
			
			if(sBrowserType.isEmpty()){
				return -1;
			}
			
			if(sBrowserType.equals("ff") || sBrowserType.equals("firefox")  || sBrowserType.equals("mozilla") || sBrowserType.equals("mozilla firefox")){
				return 1;
			}
			
			if(sBrowserType.equals("ie") || sBrowserType.equals("explorer")  || sBrowserType.equals("internet explorer")){
				return 2;
			}
			
			if(sBrowserType.equals("chrome") || sBrowserType.equals("google")  || sBrowserType.equals("google chrome")){
				return 3;
			}
			
			return -1;
		}
		
	
		
 
	public static void openBrowser(String object, String value){		
		file = new File("D:\\DevTools\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		file = new File("D:\\DevTools\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		}
 
	public static void navigate(String object, String value){	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
		driver.navigate().to(value);
		
		}
	
	
	public ExcelAction(){
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}
	
	public static void setPageLoadTimeOut(String object, String value){
		System.out.println("when its string "+ value);
		ExcelAction.lngPageLoadTimeOut = Long.parseLong(value);
		System.out.println("After conversation "+value);
	}
	
	public static void setElementDetectionTimeOut(String object, String value){
		ExcelAction.lngElementDetectionTimeOut = Long.parseLong(value);
		System.out.println(value);
	}
 
	public static void click(String object, String value){
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.xpath(pro.getProperty(object))).click();
		}
	
	public static void input_text(String object, String value)
	{
		driver.findElement(By.xpath(pro.getProperty(object))).sendKeys(value);
	}
 
		public static void setText(By eby, String sText){
		try{

			driver.findElement(eby).sendKeys(sText);
		
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	
	
 
	/*public static void click_Login(String object){
		driver.findElement(By.id("login")).click();
		}*/
 
	public static void waitFor(String object, String value) throws Exception{
		//Thread.sleep(5000);
	
		wait = new WebDriverWait(driver, Long.parseLong(value));
		}
	
	public static void select(String object, String value) throws Exception
	{
		Select menuselect = driver.findElement(By.xpath(pro.getProperty(object)));
		menuselect.selectByVisibleText(constants.savedcardt);
		
	}
	
	public static String getTitle(String object, String value)
	{
		return driver.getTitle();
	}
	
	public static void verifyTitle(String object)
	{
	//	String pagetitle = getTitle(object);
		if(driver.getTitle().equals(constants.savedcardt))
			//	pagetitle.equalsIgnoreCase(constants.savedcardt))
		{
			System.out.println("Title matched");
		}else
		{
			System.out.println("Title Didn't matched");

		}
		
	}
	
	
	public static void verify(String object, String value)
	{
		String textvalue = driver.findElement(By.xpath(pro.getProperty(object))).getText();
		if(value.equals(textvalue))
		{
			System.out.println("Text matched");
			System.out.println(textvalue);
		}else
		{
			System.out.println("Text Didn't matched");
		}
	}
	
	public void waitTillElementIsVisible(String object, long timeoutSeconds){
		try {
			
			org.openqa.selenium.support.ui.WebDriverWait oWait = new org.openqa.selenium.support.ui.WebDriverWait(driver, timeoutSeconds);
			
			oWait.until(ExpectedConditions.visibilityOfElementLocated((By) pro.get(object)));
			
		} catch (Throwable t) {
			t.printStackTrace();		}
	}
 
	public static <E> void selectItem(String object){
		try{

			Select oListBox;
			
			oListBox = new Select(driver.findElement(By.id(pro.getProperty(object))));
			
			List<WebElement> state_options = oListBox.getOptions();
			for(WebElement options: state_options)
			{
				System.out.println("**********************************************");
				System.out.println(options.getText());
				System.out.println("**********************************************");
			}
			
			
			Iterator<WebElement> itr = state_options.iterator();
					while(itr.hasNext())
							{
						        System.out.println(itr.next().getText());
							}
			
			
			oListBox.selectByVisibleText(constants.select_state);
			
		} catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	
	public static void isDisplayed(String object, By eby)
	{
		if(driver.findElement(eby).isDisplayed())
				{
					System.out.println("Element is displayed");
				} else
				{
					System.out.println("Element not displayed");
				}
	}
	
	
	
	/*public static void click_Logout(){
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
		}*/
 
	public static void closeBrowser(String object){
			driver.quit();
		}
 
	}
