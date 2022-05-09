package AnimalCoSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageA {

    WebDriver browser;
    public String url = "https://www.animal.co.uk/";

    public HomePageA(WebDriver driver){
        this.browser = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userToggle")
    WebElement userBtn;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginBtn;

    @FindBy(id="CustomerEmail")
    WebElement emailField;

    @FindBy(id="CustomerPassword")
    WebElement passField;

    @FindBy (xpath = "//div[@id='CustomerLoginForm']/ul/li[3]/input")
    WebElement signInBtn;

    @FindBy(id="email")
    WebElement mainPgEmailField;


    public void userBtnClick(){
        userBtn.click();
    }

    public void loginSteps(String email,String pass){
        loginBtn.click();
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        signInBtn.click();

    }


}
