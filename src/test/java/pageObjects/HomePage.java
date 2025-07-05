package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    public By signInPopup = By.xpath("//section[@class='modalMain tcnFooter']");
    public By signInPopupCloseButton = By.cssSelector("span[data-cy='closeModal']");
    public By searchWidgetButton = By.xpath("//a[contains(@class,'widgetSearchBtn ')]");
}
