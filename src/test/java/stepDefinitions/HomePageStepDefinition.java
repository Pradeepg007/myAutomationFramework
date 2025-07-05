package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomePageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @Given("User lands on the MakeMyTrip homepage")
    public void User_lands_on_the_makeMyTrip_homepage() {
        Assert.assertTrue(testContextSetup.genericUtils.getCurrentPageTitle().contains("MakeMyTrip"));
    }

    @When("User closes the sign in pop-up once it's shown on the page")
    public void User_closes_the_sign_in_popup_once_its_shown_on_the_page() {
        testContextSetup.genericUtils.waitForElementToBeVisible(homePage.signInPopup, 10);
        Assert.assertTrue(testContextSetup.genericUtils.isElementDisplayed(homePage.signInPopup));
        testContextSetup.genericUtils.waitForElementToBeClickable(homePage.signInPopupCloseButton, 10);
        //Scroll to element center view - add this in generic Utils
        testContextSetup.genericUtils.clickElement(homePage.signInPopupCloseButton);
        testContextSetup.genericUtils.waitForElementToBeInvisible(homePage.signInPopup, 10);
        Assert.assertFalse(testContextSetup.genericUtils.isElementDisplayed(homePage.signInPopup));

    }

//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.makemytrip.com");
//        driver.manage().window().maximize();
//        String mainTitle = driver.getCurrentUrl();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        Actions actions = new Actions(driver);
//        WebElement signInPopup = driver.findElement(By.xpath("//section[@class='modalMain tcnFooter']"));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(signInPopup));   //To use when we use By Locator
//        wait.until(ExpectedConditions.visibilityOf(signInPopup));
//        Assert.assertTrue(signInPopup.isDisplayed());
//
//        WebElement loginPopupCloseButton = driver.findElement(By.cssSelector("span[data-cy='closeModal']"));
//        wait.until(ExpectedConditions.elementToBeClickable(loginPopupCloseButton));
//        loginPopupCloseButton.click();
//        wait.until(ExpectedConditions.invisibilityOf(signInPopup));
//        WebElement searchWidgetButton = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn ')]"));
//
//        wait.until(ExpectedConditions.visibilityOf(searchWidgetButton));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", searchWidgetButton);
//        searchWidgetButton.click();
//        driver.navigate().back();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cy='tertiaryRowItem_Where2Go']")));
//        WebElement whereToGoLink = driver.findElement(By.cssSelector("[data-cy='tertiaryRowItem_Where2Go']"));
//        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", whereToGoLink);
//
//        actions.moveToElement(whereToGoLink).sendKeys(Keys.CONTROL).click().build().perform();
//
//        Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> windowIterator = windowHandles.iterator();
//        String parentWindow = windowIterator.next();
//        String childWindow = windowIterator.next();
//        driver.switchTo().window(childWindow);
//        driver.close();
//        driver.switchTo().window(parentWindow);
//        Assert.assertEquals(mainTitle, driver.getCurrentUrl());
//        driver.quit();
//    }
}
