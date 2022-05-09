package Google;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseClass {

    @FindBy(id = "L2AGLb")
    WebElement acceptBtn;

    @FindBy(css = "input.gLFyf.gsfi")
    WebElement searchField;


    public void clickAcceptBtn() {
        acceptBtn.click();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void enterTextInSearchField(String textToSearch) {
        searchField.sendKeys(textToSearch);
    }

    public void sendText(){
        searchField.sendKeys(Keys.ENTER);
    }

}
