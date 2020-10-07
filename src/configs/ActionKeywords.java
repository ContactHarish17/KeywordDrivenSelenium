package configs;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import static executionEngine.DriverScriptReflectionShiva.pro;

 
public class ActionKeywords {
 
		public static WebDriver driver;
		public static File file;
		private long lngPageLoadTimeOut;
		private long lngElementDetectionTimeOut;
 
	public static void openBrowser(String object){		
		file = new File("D:\\DevTools\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		file = new File("D:\\DevTools\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		}
 
	public static void navigate(String object){	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(constants.URL);
		
		}
	
	
	public ActionKeywords(){
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}
	
	public void setPageLoadTimeOut(long lngPageLoadTimeOut){
		this.lngPageLoadTimeOut = lngPageLoadTimeOut;
	}
	
	public void setElementDetectionTimeOut(long lngElementDetectionTimeOut){
		this.lngElementDetectionTimeOut = lngElementDetectionTimeOut;
	}
 
	public static void click(String object){
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.xpath(pro.getProperty(object))).click();
		}
 
	public static void input_Username(String object) throws InterruptedException{
	//	driver.findElement(By.id("log")).sendKeys(constants.UserName); 
		driver.findElement(By.xpath(pro.getProperty(object))).sendKeys(constants.UserName);
		Thread.sleep(3000);
		System.out.println("Elenementis "+pro.getProperty(object));
		
		}
 
	public static void input_Password(String object) throws InterruptedException
	{	
		driver.findElement(By.xpath(pro.getProperty(object))).sendKeys(constants.Password);
		Thread.sleep(3000);
		System.out.println("Elenement is "+pro.getProperty(object));
	}
	
	public static void input_fname(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_firstname);
		System.out.println("Elenementis "+pro.getProperty(object));
		}
	
	public static void input_lname(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_lastname);
		System.out.println("Elenementis "+pro.getProperty(object));
		}
	
	public static void input_cname(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_companyname);
		}
	
	public static void input_email(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_email);
		}
	
	public static void input_userpassword(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_password);
		}
	
	public static void input_confirmpassword(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_confirmpassword);
		}
	
	public static void input_address1(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_address1);
		}
	
	public static void input_address2(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_address2);
		}
	
	public static void input_cityname(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_cityname);
		}
	
	public static void input_zipcode(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.txt_zipcode);
		}
	
	public static void input_phone(String object){
		//driver.findElement(By.id("pwd")).sendKeys(constants.Password);
		driver.findElement(By.id(pro.getProperty(object))).sendKeys(constants.text_phone);
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
 
	public static void waitFor(String object) throws Exception{
		Thread.sleep(5000);
		}
	
	public static void select(String object) throws Exception
	{
		Select menuselect = driver.findElement(By.xpath(pro.getProperty(object)));
		menuselect.selectByVisibleText(constants.savedcardt);
		
	}
	
	public static String getTitle(String object)
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
	
	
	public static void verify(String object)
	{
		String textvalue = driver.findElement(By.xpath(pro.getProperty(object))).getText();
		if(textvalue.equals(textvalue))
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
