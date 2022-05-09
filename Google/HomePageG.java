package Google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageG extends BaseClass {
    WebDriver browser;
    WebDriverWait wait;

    public String url = "https://google.com";

    public HomePageG(WebDriver driver) {
        this.browser = driver;
        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div[1]/div/a/h3")
    WebElement link;

    @FindBy(id="denyAll")
    WebElement denyAllCookie;

    @FindBy (xpath = "//*[@id='mat-dialog-0']/ng-component/app-theme/div/div/div[2]/button[2]/span[1]")
    WebElement reject;

    @FindBy (css="#gdpr-consent-tool-wrapper>iframe")
    WebElement frame;

    @FindBy(xpath = "//ul[@class='smile_icon_list left circle with_bg']//h3")
    List<WebElement> birdsList;

    @FindBy(xpath = "//*[@id='main']/div[1]/div[1]/div/div/h1")
    WebElement titleOfElement;




    public void clickOnLink(){
        link.click();
    }

    public void clickOnDenyAllBtn(){
        denyAllCookie.click();
    }

    public void clickOnRejectBtn(){
        reject.click();
    }


    public void waitDenyAllCookies(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("denyAll")));
    }

    public void waitSearchField(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gLFyf.gsfi")));
    }



    }


