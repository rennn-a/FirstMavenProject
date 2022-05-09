package GlobalSQA;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.time.Duration;
import java.util.List;

public class WebSiteGlobalsQa {
    WebDriver browser;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.globalsqa.com/demo-site/sliders/");
        wait = new WebDriverWait(browser, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }

    @Test
    public void webPage() {
        Assert.assertEquals(browser.getTitle(), "Slider Online Testing Dummy Site | Demo Site- GlobalSQA");
    }

    @Test
    public void sliders() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='post-2673']/div[2]/div/div/div[1]/p/iframe")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("red")));
        Actions action = new Actions(browser);

        WebElement redColPicker = browser.findElement(By.id("red"));
        Assert.assertTrue(redColPicker.isEnabled());
        WebElement redSlider = browser.findElement(By.xpath("//div[@id='red']/div"));
        action.click(redSlider).moveByOffset(-60,0).build().perform();

        WebElement greenColPicker = browser.findElement(By.id("green"));
        Assert.assertTrue(greenColPicker.isEnabled());
        WebElement greenSlider = browser.findElement(By.xpath("//div[@id='green']/div"));
        action.clickAndHold(greenSlider).moveByOffset(-50,0).build().perform();


        WebElement blueColPicker = browser.findElement(By.id("blue"));
        Assert.assertTrue(blueColPicker.isEnabled());
        WebElement blueSlider = browser.findElement(By.xpath("//div[@id='blue']/div"));
        action.clickAndHold(blueSlider).moveByOffset(120,0).build().perform();
    }

    @Test
    public void dropdown() {
        browser.findElement(By.linkText("DropDown Menu")).click();
        Select dropdown = new Select(browser.findElement(By.xpath("//div/p/select")));
        dropdown.selectByValue("AND");

    }

    @Test
    public void date() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor)browser;


        WebElement datePickerField = browser.findElement(By.id("datepicker"));
        js.executeScript("arguments[0].scrollIntoView()", datePickerField);
        Thread.sleep(3000);
        datePickerField.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));

        for (int i = 0; i <= 5; i++) {
            WebElement rightArrow = browser.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[2]"));
            rightArrow.click();
        }
        WebElement dateBox = browser.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]"));
        dateBox.click();


    }


    @Test
    public void spinner() {
        browser.get("https://www.globalsqa.com/demo-site/spinner/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='post-2677']/div[2]/div/div/div[1]/p/iframe")));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("spinner"))));
        WebElement spinnerInput = browser.findElement(By.id("spinner"));
        spinnerInput.click();

        for (int i = 1; i < 6; i++) {
            WebElement upArrow = browser.findElement(By.xpath("//p/span/a"));
            upArrow.click();
        }

        Select currency = new Select(browser.findElement(By.id("currency")));

        List<WebElement> allAvailableOptions = currency.getOptions();
        System.out.println(allAvailableOptions.size());


    }




    @Test
    public void screenShot() throws Throwable{
        File scrFile=((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./Screenshots/screenshot.png"));
    }

}

   @Test
   public void moveSliders() {
       WebElement iframe = browser.findElement(By.cssSelector("iframe.demo-frame.lazyloaded"));
       browser.switchTo().frame(iframe);
       List<WebElement> sliders = browser.findElements(By.cssSelector("span.ui-slider-handle"));
       Actions moveSlider = new Actions(browser);
       for (int i = 0; i < sliders.size(); i++) {
           if (browser.findElement(By.cssSelector("div.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content>span"))
                   .getAttribute("style").equalsIgnoreCase("left: 100%;")) {
               moveSlider.clickAndHold(sliders.get(i)).moveByOffset(-100, 0).build().perform();
           } else {
               moveSlider.clickAndHold(sliders.get(i)).moveByOffset(100, 0).build().perform();
           }
       }
   }


   @Test
   public void moveRedSlider() {
       WebElement iframe = browser.findElement(By.cssSelector("iframe.demo-frame.lazyloaded"));
       browser.switchTo().frame(iframe);
       List<WebElement> sliders = browser.findElements(By.cssSelector("span.ui-slider-handle"));
       Actions moveSlider = new Actions(browser);
       String sliderPosition = browser.findElement(By.cssSelector("div.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content>span"))
               .getAttribute("style");
       double sliderStartPositionValue = Double.parseDouble(sliderPosition.replaceAll("[left: %;]", ""));
       for (int i = 0; i < sliders.size(); i++) {
           if (browser.findElement(By.cssSelector("div.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content"))
                   .getAttribute("id").equalsIgnoreCase("red")) {
               moveSlider.clickAndHold(sliders.get(i)).moveByOffset(-100, 0).build().perform();
               break;
           }
       }
       sliderPosition = browser.findElement(By.cssSelector("div.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content>span"))
               .getAttribute("style");
       double sliderEndPositionValue = Double.parseDouble(sliderPosition.replaceAll("[left: %;]", ""));
       Assert.assertTrue(sliderEndPositionValue < sliderStartPositionValue);
   }


// Return a WebElement referencing the first selection option found by walking down the DOM
//  WebElement firstSelectedOption = currency.getFirstSelectedOption();

//Return a List<WebElement> of options that have been selected
// List<WebElement> allSelectedOptions = currency.getAllSelectedOptions();

// Return a List<WebElement> of options that the <select> element contains
//List<WebElement> allAvailableOptions = currency.getOptions();
