package Google;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

public class TestSearchAnimalInGoogle {

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
    public void readTest() throws Exception {
        /*Make a test that reads different types of animals from a file and searches for each animal in Google*/

        homePageG = new HomePageG(browser);
        browser.get(homePageG.url);


        ArrayList<String> types = new ArrayList<String>();
        types.add("Lion");
        types.add("Zebra");
        types.add("Eagle");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("animals.txt"));
            for (String anType : types) {
                writer.write("\n" + anType);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("animals.txt"));

            homePageG.clickAcceptBtn();
            homePageG.clickSearchField();

            String line = reader.readLine();
            while ((line != null)) {

                homePageG.waitSearchField();
                homePageG.searchField.sendKeys(line +Keys.ENTER);


                Thread.sleep(4000);
                browser.get(homePageG.url);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

