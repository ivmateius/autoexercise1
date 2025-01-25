package vio.auto.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import vio.auto.data.DataReader;

import java.io.IOException;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");


    }

    public Map<String, String> getData() throws IOException {
        String filePath ="src/test/java/vio/auto/data/UserData.json";

        // Initialize the DataReader to fetch data from JSON
        DataReader dataReader = new DataReader();
        Map<String, String> formData = dataReader.getFormData(filePath);
        return formData;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
