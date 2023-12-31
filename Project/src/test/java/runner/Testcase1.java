package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import pages.homepage;
import utils.base64;
import utils.Screenshot;
import utils.Base;
import utils.EventHandler;
import utils.Reporter;
// import utils.Screenshot;
public class Testcase1 extends Base {

    java.util.logging.Logger log =  LoggerHandler.getLogger();
    base64 screenshotHandler = new base64();
    ExtentReports reporter = Reporter.generateExtentReport();
    homepage Homepage = new homepage();
    
    @Test(priority = 1)


    public void TC_001() throws IOException {

        try {

         

            ExtentTest test = reporter.createTest("TC_001", "Execution for Login Function");

            driver.get(prop.getProperty("url"));
       
      

            test.log(Status.PASS, "login Test");

 

        }

    catch (Exception ex) {

        ex.printStackTrace();

        

        ExtentTest test = reporter.createTest("Login Test");

        String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver);

        test.log(Status.FAIL, "Unable to Perform Login Test", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

       

    }
    }
    

@BeforeMethod
public void beforeMethod() throws MalformedURLException {
    openBrowser();

}

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        reporter.flush();
        log.info("Browser closed");
        LoggerHandler.closeHandler();
    }
}

