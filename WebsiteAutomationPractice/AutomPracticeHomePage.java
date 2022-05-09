package WebsiteAutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.WeakReference;
import java.util.Locale;

public class AutomPracticeHomePage {
    WebDriver browser;
    WebDriverWait wait;


    protected String url = "http://automationpractice.com";

    AutomPracticeHomePage(WebDriver driver) {
        this.browser = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    WebElement search;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(linkText = "Sign in")
    WebElement signInButton;

    @FindBy(id = "id_gender1")
    WebElement radioBtnMr;

    @FindBy(id="email_create")
    WebElement emailField;

    @FindBy(id="SubmitCreate")
    WebElement createAnAccountBtn;

    @FindBy(id="id_gender2")
    WebElement radioBtnMsr;

    @FindBy(id="customer_firstname")
    WebElement firstNameField;

    @FindBy(id="customer_lastname")
    WebElement lastNameField;

    @FindBy(id="passwd")
    WebElement passField;

    @FindBy(id="days")
    WebElement dropDownDays;

    @FindBy(id="months")
    WebElement dropDownMonths;

    @FindBy(id="years")
    WebElement dropDownYears;

    @FindBy(id="firstname")
    WebElement addressFirName;

    @FindBy(id="lastname")
    WebElement addressLastName;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="id_state")
    WebElement dropDownState;




    protected void clickOnSearchField() {
        search.click();
    }

    protected void sendKeysSearchButton(String text) {
        searchButton.sendKeys(text);
    }

    protected void clickOnSignBtn() {
        signInButton.click();
    }
    protected void emailFieldActions(String email){
        emailField.sendKeys(email);
    }
    protected void clickOnCreateAnAcountBtn(){
        createAnAccountBtn.click();
    }
    protected void clickOnRadioBtnMR() {
        radioBtnMr.click();
    }

    protected void userInfo(String text, String lName, String pass){
        firstNameField.sendKeys(text);
        lastNameField.sendKeys(lName);
        passField.sendKeys(pass);
    }
    protected void userAddress(String name, String lName, String cityW){
        addressFirName.sendKeys(name);
        addressLastName.sendKeys(lName);
        city.sendKeys(cityW);
    }
}

