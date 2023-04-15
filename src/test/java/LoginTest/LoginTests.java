package LoginTest;

import base.BaseTest;
import constants.dataproviders.LoginData;
import constants.locators.IMDbDashboardConstants;
import constants.messages.AssertionMessages;
import constants.urls.Urls;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.common.IMDbDashboardPage;
import pages.common.IMDbHomePage;
import pages.common.IMDbLoginPage;
import pages.common.IMDbProfilePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTests extends BaseTest {

    // Here I added setUp2() because when I run both test here one fails, but there are working good when I run them
    // separately. Couldnt find alternative solution, please give feedback
    @Before
    public void setUp2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\IdeaProjects\\ST_HW3.2_Yuri_Mkrtumyan\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Urls.SUT_URL);
        homePage = new IMDbHomePage(driver);

    }
    @Test
    public void testUnSuccessfulLogin() {
        IMDbLoginPage loginPage = homePage.clickLogInButton();
        loginPage.login(LoginData.invalidUsername,LoginData.invalidPassword);
        assertEquals(AssertionMessages.LOGIN_ERROR_MESSAGE, "Invalid login, please try again");
    }

    @Test
    public void testSuccessfulLogin() {
        IMDbLoginPage loginPage = homePage.clickLogInButton();
        loginPage.login(LoginData.username,LoginData.password);
        String pageTitle = driver.getTitle();
        assertEquals(IMDbDashboardConstants.TITLE, pageTitle);
    }

}
