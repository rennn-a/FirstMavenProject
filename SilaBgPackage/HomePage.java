package SilaBgPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver browser;

    public String url = "https://silabg.com";

    @FindBy(id = "search_what")
    WebElement searchField;


    @FindBy(id ="drop_promo_link")
    WebElement text;

    @FindBy(xpath ="//*[@id='left_panel']/div[3]/div[2]/div[16]/div/a/div[1]")
    WebElement flavourEl;

    @FindBy (id="newsletter_mail")
    WebElement emailField;



    public HomePage(WebDriver driver) {
        this.browser = driver;
        PageFactory.initElements(driver, this);
    }


}
