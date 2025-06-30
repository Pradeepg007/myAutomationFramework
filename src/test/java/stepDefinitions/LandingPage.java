package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LandingPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com");
        driver.manage().window().maximize();
        String mainTitle = driver.getCurrentUrl();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        WebElement signInPopup = driver.findElement(By.xpath("//section[@class='modalMain tcnFooter']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(signInPopup));   //To use when we use By Locator
        wait.until(ExpectedConditions.visibilityOf(signInPopup));
        Assert.assertTrue(signInPopup.isDisplayed());

        WebElement loginPopupCloseButton = driver.findElement(By.cssSelector("span[data-cy='closeModal']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPopupCloseButton));
        loginPopupCloseButton.click();
        wait.until(ExpectedConditions.invisibilityOf(signInPopup));
        WebElement searchWidgetButton = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn ')]"));

        wait.until(ExpectedConditions.visibilityOf(searchWidgetButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", searchWidgetButton);
        searchWidgetButton.click();
        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cy='tertiaryRowItem_Where2Go']")));
        WebElement whereToGoLink = driver.findElement(By.cssSelector("[data-cy='tertiaryRowItem_Where2Go']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", whereToGoLink);

        actions.moveToElement(whereToGoLink).sendKeys(Keys.CONTROL).click().build().perform();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        String parentWindow = windowIterator.next();
        String childWindow = windowIterator.next();
        driver.switchTo().window(childWindow);
        driver.close();
        driver.switchTo().window(parentWindow);

        Assert.assertEquals(mainTitle, driver.getCurrentUrl());
        driver.quit();
    }
}
