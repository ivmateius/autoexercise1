package vio.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class StandaloneTC1 {
    @Test
    public void RegisterUser() throws InterruptedException {
        String userName = "VioTest";
        String emailRegister = "vio@vio.vio";

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement consentPopUp = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentPopUp.click();

        WebElement goToSignupRegister = driver.findElement(By.cssSelector("a[href='/login'"));
        goToSignupRegister.click();

        WebElement signUpName = driver.findElement(By.cssSelector("input[data-qa='signup-name']\n"));
        signUpName.sendKeys(userName);

        WebElement signUpEmail = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        signUpEmail.sendKeys(emailRegister);

        WebElement getTextSignUp = driver.findElement(By.cssSelector("div.signup-form>h2"));
        if (getTextSignUp.isDisplayed()){
            Assert.assertEquals(getTextSignUp.getText(), "New User Signup!", "Text not ok");
        }else {
            throw new AssertionError("Text now displayed");
        }

        WebElement signUpButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signUpButton.click();

        WebElement enterAccInfoText = driver.findElement(By.cssSelector("div.login-form>h2"));
        if (enterAccInfoText.isDisplayed()){
            Assert.assertEquals(enterAccInfoText.getText(),"ENTER ACCOUNT INFORMATION", "Failed");

        }else {
            throw new AssertionError("Text not displayed");
        }





        driver.quit();


    }
}
