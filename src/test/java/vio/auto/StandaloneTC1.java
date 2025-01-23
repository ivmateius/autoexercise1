package vio.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class StandaloneTC1 {
    @Test
    public void RegisterUser() throws InterruptedException {
        String userName = "VioTest";
        String emailRegister = "vi7o@vio.vio";

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

        WebElement userTitle = driver.findElement(By.id("id_gender1"));
        userTitle.click();

        WebElement inputName = driver.findElement(By.id("name"));
        inputName.clear();
        inputName.sendKeys(userName);

        WebElement inputEmail = driver.findElement(By.id("email"));
        if (inputEmail.isEnabled()) {
            inputEmail.sendKeys("viorel@vio.vio");
        }

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("123abc");

        WebElement dayOfBirth = driver.findElement(By.id("days"));
        Select birthDay = new Select(dayOfBirth);
        birthDay.selectByIndex(1);

        WebElement monthOfBirth = driver.findElement(By.id("months"));
        Select birthMonth = new Select(monthOfBirth);
        birthMonth.selectByIndex(1);

        WebElement yearOfBirth = driver.findElement(By.id("years"));
        Select birthYear = new Select(yearOfBirth);
        birthYear.selectByValue("1986");

        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();

        WebElement specialOffersCheckBox = driver.findElement(By.id("optin"));
        specialOffersCheckBox.click();

        WebElement inputFirstName = driver.findElement(By.id("first_name"));
        inputFirstName.sendKeys("Vio");

        WebElement inputLasttName = driver.findElement(By.id("last_name"));
        inputLasttName.sendKeys("Ionut");

        WebElement inputCompany = driver.findElement(By.id("company"));
        inputCompany.sendKeys("vio srl");

        WebElement inputAddress1 = driver.findElement(By.id("address1"));
        inputAddress1.sendKeys("some street 34");

        WebElement inputAddress2 = driver.findElement(By.id("address2"));
        inputAddress2.sendKeys("other street 78");

        WebElement country = driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(1);

        WebElement inputState = driver.findElement(By.id("state"));
        inputState.sendKeys("Romania");

        WebElement inputCity = driver.findElement(By.id("city"));
        inputCity.sendKeys("Bucharest");

        WebElement inputZipCode = driver.findElement(By.id("zipcode"));
        inputZipCode.sendKeys("123456");

        WebElement inputMobileNumber = driver.findElement(By.id("mobile_number"));
        inputMobileNumber.sendKeys("123456789");

        WebElement buttonCreateAccount = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        buttonCreateAccount.click();

        WebElement textAccountCreated = driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
        Assert.assertTrue(textAccountCreated.isDisplayed());

        WebElement continueButton = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        continueButton.click();

        WebElement getUserName = driver.findElement(By.cssSelector("i.fa.fa-user+b"));
        if (getUserName.isDisplayed()){
            Assert.assertEquals(getUserName.getText(),userName );
        }else {
            throw new AssertionError("Username not displayed");
        }

        WebElement deleteAccountButton = driver.findElement(By.cssSelector("a[href='/delete_account']"));
        deleteAccountButton.click();

        WebElement accountDeletedMessage = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
        Assert.assertTrue(accountDeletedMessage.isDisplayed());


        driver.quit();


    }
}
