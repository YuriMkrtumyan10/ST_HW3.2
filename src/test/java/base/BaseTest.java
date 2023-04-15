package base;

import constants.urls.Urls;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.common.IMDbHomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class BaseTest {

    public static WebDriver driver;
    public static IMDbHomePage homePage;


    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\IdeaProjects\\ST_HW3.2_Yuri_Mkrtumyan\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Urls.SUT_URL);
        homePage = new IMDbHomePage(driver);

    }




    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot.toPath(), new File("src/screenshots" +  result.getName() + ".png").toPath());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


//    @AfterClass
//    public static void tearDown() {
//        //driver.quit();
//    }

}
