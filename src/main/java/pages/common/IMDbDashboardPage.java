package pages.common;


import constants.locators.IMDbDashboardConstants;
import constants.locators.IMDbProfilePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.locators.IMDbLoginPageConstants.loginUserName;

public class IMDbDashboardPage {
    private WebDriver driver;
    public static final By PROFILE_MENU = By.cssSelector(IMDbDashboardConstants.PROFILE_MENU);
    public static final By PROFILE_BUTTON_ = By.xpath(IMDbDashboardConstants.PROFILE_BUTTON);


    public IMDbDashboardPage(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getProfileMenu(){
        return driver.findElement(PROFILE_MENU);
    }
    public IMDbProfilePage clickProfileButton(){

        WebElement profBut = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(PROFILE_BUTTON_));

        profBut.click();

        return new IMDbProfilePage(driver);
    }


}
