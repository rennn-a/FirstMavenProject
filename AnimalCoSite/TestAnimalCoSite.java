package AnimalCoSite;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestAnimalCoSite {

    WebDriver browser;
    HomePageA animalHomePage;

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
        animalHomePage = new HomePageA(browser);
        browser.get(animalHomePage.url);
        Assert.assertEquals(browser.getTitle(), "Sustainable & Organic Clothing - Animal");
    }

    @Test
    public void logIn() {

        animalHomePage = new HomePageA(browser);
        browser.get(animalHomePage.url);

        Assert.assertTrue(animalHomePage.userBtn.isEnabled());
        animalHomePage.userBtnClick();
        Assert.assertTrue(animalHomePage.loginBtn.isEnabled());

        animalHomePage.loginBtn.isDisplayed();
        animalHomePage.loginSteps("ads@20minuteemail.com", "123456");

    }


    @Test
    public void scrollDown() throws InterruptedException {
        animalHomePage = new HomePageA(browser);
        browser.get(animalHomePage.url);

        JavascriptExecutor down = (JavascriptExecutor) browser;
        down.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);

    }

    @Test
    public void scrollUp() throws InterruptedException {
        animalHomePage = new HomePageA(browser);
        browser.get(animalHomePage.url);

        scrollDown();
        JavascriptExecutor up = (JavascriptExecutor) browser;
        up.executeScript("window.scrollBy(0,-4397)");
        Thread.sleep(5000);

    }

    @Test
    public void scrollToElement() throws InterruptedException {
        animalHomePage = new HomePageA(browser);
        browser.get(animalHomePage.url);

        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].scrollIntoView()", animalHomePage.mainPgEmailField);
        js.executeScript("arguments[0].style.background='yellow'", animalHomePage.mainPgEmailField);
        Thread.sleep(4000);

    }




}





