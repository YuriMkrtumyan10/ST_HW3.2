package DashboardTest;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import constants.dataproviders.LoginData;
import constants.locators.IMDbDashboardConstants;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import pages.common.IMDbDashboardPage;
import pages.common.IMDbLoginPage;

import static constants.locators.IMDbDashboardConstants.Dashboard_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardTests extends BaseTest {

    @Test
    public void testDashboardTitle() {
        IMDbLoginPage loginPage = homePage.clickLogInButton();
        loginPage.login(LoginData.username,LoginData.password);
        String pageTitle = driver.getTitle();
        assertEquals(IMDbDashboardConstants.TITLE, pageTitle);
    }
    @Test
    public void testDashboardURL() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, Dashboard_URL);
    }

    @Test
    public void testDashboardProfileMenu() {
        IMDbDashboardPage dshBoard = new IMDbDashboardPage(driver);
        assertTrue(dshBoard.getProfileMenu().isEnabled()
                && dshBoard.getProfileMenu().isDisplayed());
    }
}
