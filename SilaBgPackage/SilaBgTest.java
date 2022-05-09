package SilaBgPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SilaBgTest {

    WebDriver browser;
    HomePage silaBgHomePage;

    @BeforeMethod

    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }

    @Test
    public void webPage() {
        silaBgHomePage = new HomePage(browser);
        browser.get(silaBgHomePage.url);
        Assert.assertEquals(browser.getTitle(), "Хранителни добавки - онлайн магазин SilaBG.com");
    }


    @Test
    public void scrollToElement() throws InterruptedException {
        silaBgHomePage = new HomePage(browser);
        browser.get(silaBgHomePage.url);


        JavascriptExecutor js = (JavascriptExecutor) browser;
        silaBgHomePage.flavourEl.isEnabled();
        js.executeScript("arguments[0].scrollIntoView()", silaBgHomePage.flavourEl);
        Thread.sleep(6000);

        silaBgHomePage.emailField.isDisplayed();
        js.executeScript("arguments[0].scrollIntoView()", silaBgHomePage.emailField);
        js.executeScript("arguments[0].style.background='yellow' ", silaBgHomePage.emailField); //Highlight

//        String javascript = "arguments[0].click()";                                    //Click
//        js.executeScript(javascript,emailField);
//        Thread.sleep(4000);

        js.executeScript("arguments[0].value='ads@20minuteemail.com'", silaBgHomePage.emailField); //Set the text
        String text = (String) js.executeScript("return arguments[0].value", silaBgHomePage.emailField); //Get the text
        Thread.sleep(5000);
        System.out.println(text);


    }


    @Test
    public void elementSize()  {

        silaBgHomePage = new HomePage(browser);
        browser.get(silaBgHomePage.url);

        Dimension size = silaBgHomePage.searchField.getSize();
        System.out.println("Width: " + size.width);
        System.out.println("Height: " + size.height);

    }


    @Test
    public void fontFamilyOfText() {

        silaBgHomePage = new HomePage(browser);
        browser.get(silaBgHomePage.url);
        String fontFamily = silaBgHomePage.text.getCssValue("font-family");
        System.out.println("Font family: " + fontFamily);

        String fontSize = silaBgHomePage.text.getCssValue("font-size");
        System.out.println("Font size: " + fontSize);

        String fontColor = silaBgHomePage.text.getCssValue("color");
        System.out.println("Font color: " + fontColor);

        String textAlign = silaBgHomePage.text.getCssValue("text-align");
        System.out.println("Text align: " + textAlign);

    }


}



