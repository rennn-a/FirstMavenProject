package Google;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class TestSwitchToTab {

    WebDriver browser;
    WebDriverWait wait;
    HomePageG homePageG;


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
    public void switchToWindow() throws InterruptedException {
        homePageG = new HomePageG(browser);
        browser.get(homePageG.url);



        String parentWindow = browser.getWindowHandle();
        homePageG.clickAcceptBtn();

        browser.switchTo().newWindow(WindowType.TAB);
        browser.get("https://www.animal.co.uk/collections/all-womens/");

        homePageG.titleOfElement.isEnabled();
        String titleEl = homePageG.titleOfElement.getText();

        browser.switchTo().window(parentWindow);
        homePageG.clickSearchField();
        homePageG.enterTextInSearchField(titleEl);
        Thread.sleep(2000);

    }

}
