package listeners;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import base.BaseTest;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

	    if (BaseTest.driver == null) {
	        return;
	    }

	    try {
	        TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File("screenshots/" + result.getName() + ".png");
	        Files.copy(src, dest);
	    } catch (Exception e) {
	        System.out.println("Driver already closed, screenshot skipped");
	    }
	}

}
