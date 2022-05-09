package WebsiteAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWebSiteAutomationPractice {

    WebDriver browser;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }


    @Test
    public void webPage() {
        AutomPracticeHomePage automPracticeHomePage = new AutomPracticeHomePage(browser);
        browser.get(automPracticeHomePage.url);
        Assert.assertEquals(browser.getTitle(), "My Store");
    }


    @Test
    public void SearchField() {

        AutomPracticeHomePage automPracticeHomePage = new AutomPracticeHomePage(browser);
        browser.get(automPracticeHomePage.url);

        automPracticeHomePage.clickOnSearchField();
        automPracticeHomePage.sendKeysSearchButton("Dress");
        Assert.assertTrue(automPracticeHomePage.searchButton.isDisplayed());

        if (automPracticeHomePage.searchButton.isDisplayed()) {
            System.out.println("Search button is available");
        } else {
            System.out.println("Search button is not available");
        }
    }


    @Test
    public void registerForm() {
        AutomPracticeHomePage automPracticeHomePage = new AutomPracticeHomePage(browser);
        browser.get(automPracticeHomePage.url);

        automPracticeHomePage.clickOnSignBtn();
        Assert.assertTrue(automPracticeHomePage.signInButton.isDisplayed());

        Assert.assertEquals(browser.getTitle(), "Login - My Store");

        automPracticeHomePage.emailFieldActions("xo3rfk35yka@20minutemail.it");

        automPracticeHomePage.clickOnCreateAnAcountBtn();
        Assert.assertTrue(automPracticeHomePage.createAnAccountBtn.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(automPracticeHomePage.radioBtnMr));
        automPracticeHomePage.clickOnRadioBtnMR();

        Assert.assertTrue(automPracticeHomePage.radioBtnMsr.isEnabled());

        wait.until(ExpectedConditions.elementToBeClickable(automPracticeHomePage.firstNameField));
        wait.until(ExpectedConditions.elementToBeClickable(automPracticeHomePage.lastNameField));


        automPracticeHomePage.userInfo("John", "Smith", "lalala");

        Select dropdownDay = new Select(automPracticeHomePage.dropDownDays);
        dropdownDay.selectByValue("1");

        Select dropdownMonths = new Select(automPracticeHomePage.dropDownMonths);
        dropdownMonths.selectByValue("8");

        Select dropDownYears = new Select(automPracticeHomePage.dropDownYears);
        dropDownYears.selectByValue("2000");

        automPracticeHomePage.userAddress("Jo", "Sm", "Texas");

        Select dropdownState = new Select(automPracticeHomePage.dropDownState);
        dropdownState.selectByValue("1");


    }


}
