package Google;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.List;


public class TestBirdsFile {

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
    public void file() throws Exception {

            /*Make a test that searches for "types of birds" in Google,
        opens a search result with 40 different types of birds,
         and then stores all the presented types of birds and saves them into a file
         */

        homePageG = new HomePageG(browser);
        browser.get(homePageG.url);

        homePageG.clickAcceptBtn();

        homePageG.clickSearchField();
        homePageG.enterTextInSearchField("types of birds");
        homePageG.sendText();
        homePageG.clickOnLink();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(homePageG.frame));
        wait.until(ExpectedConditions.elementToBeClickable(homePageG.denyAllCookie));

        homePageG.clickOnDenyAllBtn();
        Thread.sleep(2000);
        homePageG.clickOnRejectBtn();
        browser.switchTo().defaultContent(); // след приема на бисквитки


        List<WebElement> birdsList = homePageG.birdsList;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));  //create constructor

            for (int i = 0; i < birdsList.size(); i++) {
                String kind = birdsList.get(i).getText();
                writer.write("\n" + kind);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




