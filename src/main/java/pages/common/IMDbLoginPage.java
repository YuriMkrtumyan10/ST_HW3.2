package pages.common;

import constants.locators.IMDbLoginPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.locators.IMDbLoginPageConstants.*;
public class IMDbLoginPage {
    private WebDriver driver;

    public static final By USERNAME_FIELD = By.id(loginUserName);
    public static final By PASSWORD_FIELD = By.id(loginPassword);
    public static final By LOGIN_BUTTON = By.id(loginButton);
    public IMDbLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String email){
        driver.findElement(USERNAME_FIELD).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void login(String username, String password) {
        setUserName(username);
        setPassword(password);
        driver.findElement(LOGIN_BUTTON).click();
    }


}
