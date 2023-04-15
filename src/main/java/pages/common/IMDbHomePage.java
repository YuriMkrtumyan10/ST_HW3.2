package pages.common;

import constants.locators.IMDbHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IMDbHomePage {

    private WebDriver driver;
    private By login_button = By.cssSelector(IMDbHomePageConstants.LOGIN_BUTTON);

    public IMDbHomePage(WebDriver driver){
        this.driver = driver;
    }

    public IMDbLoginPage clickLogInButton(){
        WebElement spanElement = driver.findElement(By.className("login"));
        WebElement aElement = spanElement.findElement(By.xpath(".//a"));
        aElement.click();

        return new IMDbLoginPage(driver);
    }

}
