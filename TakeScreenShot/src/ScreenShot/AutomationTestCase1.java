package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationTestCase1 {

	public static void main(String[] args) {
		 // Define browsers and resolutions
        HashMap<String, WebDriver> browsers = new HashMap<>();
        browsers.put("Chrome", new ChromeDriver());
        browsers.put("Firefox", new FirefoxDriver());

        int[][] resolutions = {
            {1920, 1080},
            {1366, 768},
            {1280, 864}
        };

        // Define the URL to test
        String url = "https://www.getcalley.com/";

        for (Map.Entry<String, WebDriver> entry : browsers.entrySet()) {
            String browserName = entry.getKey();
            WebDriver driver = entry.getValue();

            for (int[] resolution : resolutions) {
                int width = resolution[0];
                int height = resolution[1];

                // Set the browser window size
                driver.manage().window().setSize(new Dimension(width, height));

                // Open the URL
                driver.get(url);

                // Take screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File scr = ts.getScreenshotAs(OutputType.FILE);

                // Define file path
                String filePath = String.format("./screenshot/%s/%dx%d.png", browserName, width, height);

                // Save the screenshot
                try {
                    File dest = new File(filePath);
                    FileUtils.copyFile(scr, dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Quit the driver
            driver.quit();
        }
    }


	}


