package pages.common;

import constants.locators.IMDbProfilePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IMDbProfilePage {
    private WebDriver driver;

    public static final By FULL_NAME_FIELD = By.id(IMDbProfilePageConstants.fullName);
    public static final By QR_IMAGE = By.xpath(IMDbProfilePageConstants.QRImage);
    public static final By VIEW_QR_BUTTON = By.linkText(IMDbProfilePageConstants.QRButton);

    public IMDbProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement fullName(){
       return driver.findElement(FULL_NAME_FIELD);
    }

    public WebElement getQRViewButton(){
      return driver.findElement(VIEW_QR_BUTTON);
    }

    public String getQRImageSrc(){
        WebElement image = driver.findElement(QR_IMAGE);
        return image.getAttribute("src");
    }



}
