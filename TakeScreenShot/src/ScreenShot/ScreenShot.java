package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ScreenShot {

	public static void main(String[] args) throws IOException {
		//Opening ChromeBrowser
		WebDriver driver  = new ChromeDriver();
		//Entering URL
		driver.get("https://demo.dealsdray.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement usernameField = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		//Entering UserName
		usernameField.sendKeys("prexo.mis@dealsdray.com");
		 //Entering Password
		passwordField.sendKeys("prexo.mis@dealsdray.com");
		//Click on Login Button
		loginButton.click();
        //Click on Order Drop down
		driver.findElement(By.xpath("//span[text()=\"Order\"]")).click();
        //click on Orders
		driver.findElement(By.xpath("//span[text()=\"Orders\"]")).click();
        //click on Add Bulk Order
		driver.findElement(By.xpath("//button[@align=\"right\"]")).click();
        //Uploading a File
		driver.findElement(By.id("mui-7")).sendKeys("C:\\Users\\Admin\\Downloads\\demo-data (1).xlsx");
	    //Click on Import Button
		driver.findElement(By.xpath("//button[text()=\"Import\"]")).click();
		//Click on validate button
		driver.findElement(By.xpath("//button[text()=\"Validate Data\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
	   //Taking Screenshot And Storing in Screenshot Folder
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\screenshot\\"+"HomePage.png";
		FileUtils.copyFile(scr, new File(dest));
		
	}
}
