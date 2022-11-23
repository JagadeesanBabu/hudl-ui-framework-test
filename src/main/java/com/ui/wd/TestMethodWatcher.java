package com.utils.ui.wd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestMethodWatcher extends TestWatcher {


	private static final Logger LOGGER = Logger.getLogger(TestMethodWatcher.class);
	
	
	@Override
	protected void starting(Description description){
		
		LOGGER.info(String.format("Started test: %s", description.getMethodName()));
			
	}
	
	@Override
	protected void finished(Description description) {
		LOGGER.info(String.format("Finished test: %s", description.getMethodName()));
	}
	
	@Override
	protected void failed(Throwable e, Description description) {
		try {
			captureScreenShot(description.getClassName() + "." + description.getMethodName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void captureScreenShot(String fileName) throws IOException {
		WebDriver driver = TestWebDriverManager.getDriver();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileN  = fileName + "_" + new SimpleDateFormat("_yyyy-MM-dd_HH:mm:ss").format(new Date());
        File targetFile = new File("./screenshots/" + fileN + ".png");
        FileUtils.copyFile(scrFile, targetFile);
    }
}
