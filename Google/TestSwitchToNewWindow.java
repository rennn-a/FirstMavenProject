package Google;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class TestSwitchToNewWindow {

    WebDriver browser;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.google.com");

    }

    @AfterMethod
    public void close() {
        browser.quit();
    }

    @Test

    public void switchToWindow() throws InterruptedException {

        browser.switchTo().newWindow(WindowType.WINDOW);


        Set<String> handles = browser.getWindowHandles();
        List<String> ls = new ArrayList<String>(handles);

        String parentWindow = ls.get(0);
        System.out.println(parentWindow);

        String ChildWindowId = ls.get(1);
        System.out.println(ChildWindowId);

     //   browser.get("http://silabg.com");
        Thread.sleep(5000);
        browser.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(4000);


        browser.switchTo().window(parentWindow);


    }

    @Test
    public void copyPaste() {

        browser.switchTo().newWindow(WindowType.WINDOW);

        browser.get("https://demoqa.com/text-box");
        Actions actions = new Actions(browser);

        WebElement fullName = browser.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        WebElement email=browser.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        WebElement currentAddress=browser.findElement(By.id("currentAddress"));

        currentAddress.sendKeys("43 School Lane London EC71 9GO");



        WebElement permanentAddress=browser.findElement(By.id("permanentAddress"));
        assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));



    }

}

