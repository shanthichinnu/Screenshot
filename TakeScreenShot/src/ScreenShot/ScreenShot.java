package ScreenShot;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.getcalley.com/");
       driver.manage().window().maximize();
      // String name = driver.getTitle();
       Thread.sleep(5000);
       TakesScreenshot t = (TakesScreenshot)driver;
       File scr = t.getScreenshotAs(OutputType.FILE);
       File dest = new File("./TakeScreenShot/.png");
       FileUtils.copyFile(scr, dest);
       driver.close();
	}
}
