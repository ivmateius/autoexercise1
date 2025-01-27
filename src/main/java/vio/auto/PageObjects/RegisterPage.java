package vio.auto.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import vio.auto.AbstractComponents.AbstractComponent;
import vio.auto.AbstractComponents.Utility;

import java.util.Map;

public class RegisterPage extends AbstractComponent {
    WebDriver driver;


    @FindBy(css = "a[href='/login'")
    WebElement loginRegister;
    @FindBy(css = "input[data-qa='signup-name']")
    WebElement userName;
    @FindBy(css = "input[data-qa='signup-email']")
    WebElement email;
    @FindBy(css = "div.signup-form>h2")
    WebElement getSignUpText;
    @FindBy(css = "div.login-form>h2")
    WebElement getAccInfoText;
    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signupButton;
    @FindBy(id ="id_gender1" )
    WebElement userGender;
    @FindBy(id ="name" )
    WebElement inputName;
    @FindBy(id ="email" )
    WebElement inputEmail;
    @FindBy(id ="password" )
    WebElement inputPassword;
    @FindBy(id ="days" )
    WebElement birthDay;
    @FindBy(id ="months" )
    WebElement birthMonth;
    @FindBy(id ="years" )
    WebElement birthYear;
    @FindBy(id ="newsletter" )
    WebElement newsletter;
    @FindBy(id ="optin" )
    WebElement specialOffersCheckBox;
    @FindBy(id ="first_name" )
    WebElement inputFirstName;
    @FindBy(id ="last_name" )
    WebElement inputLastName;
    @FindBy(id ="company" )
    WebElement inputCompany;
    @FindBy(id ="address1" )
    WebElement inputAddress1;
    @FindBy(id ="address2" )
    WebElement inputAddress2;
    @FindBy(id ="country" )
    WebElement inputCountry;
    @FindBy(id ="state" )
    WebElement inputState;
    @FindBy(id ="city" )
    WebElement inputCity;
    @FindBy(id ="zipcode" )
    WebElement inputZipcode;
    @FindBy(id ="mobile_number")
    WebElement inputMobileNumber;
    @FindBy(css = "button[data-qa='create-account']")
    WebElement buttonCreateAccount;
    @FindBy(css = "h2[data-qa='account-created']")
    WebElement textAccountCreated;
    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueButton;
    @FindBy(css = "i.fa.fa-user+b")
    WebElement getDisplayedUserName;
    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccountButton;
    @FindBy(css = "h2[data-qa='account-deleted']")
    WebElement accountDeletedMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSignupRegisterPage(){
        closeConsentPopUp();
        waitForWebElementToAppear(loginRegister);
        loginRegister.click();
    }

    public String getSignupText(){
        return getSignUpText.getText();
    }

    public void enterUserAndEmail(Map<String, String> formData) {
        userName.sendKeys(formData.get("username"));
        email.sendKeys(formData.get("email"));
        signupButton.click();
    }

    public String enterRandomUserAndEmail(){
        Utility utility =new Utility(WebDriver driver);
        String randomUser= utility.generateRandomUserName();
        String randomEmail= utility.generateRandomEmail();
        userName.sendKeys(randomUser);
        email.sendKeys(randomEmail);
        signupButton.click();
        return randomEmail;
    }

    public String getAccInfoText(){
        return getAccInfoText.getText();
    }

    public void enterAccountInfo(Map<String, String> formData) {
        userGender.click();
        inputName.clear();
        inputName.sendKeys(formData.get("username"));
        inputPassword.sendKeys(formData.get("password"));
        Select day = new Select(birthDay);
        day.selectByValue(formData.get("birthDay"));
        Select month = new Select(birthMonth);
        month.selectByValue(formData.get("birthMonth"));
        Select year = new Select(birthYear);
        year.selectByValue(formData.get("birthYear"));
    }

    public void checkBoxNewsletter() {
        newsletter.click();
    }

    public void checkBoxSpecialOffers() {
        specialOffersCheckBox.click();
    }
    public void enterAddressInfo(Map<String, String> formData) {
        inputFirstName.sendKeys(formData.get("firstName"));
        inputLastName.sendKeys(formData.get("lastName"));
        inputCompany.sendKeys(formData.get("company"));
        inputAddress1.sendKeys(formData.get("address1"));
        inputAddress2.sendKeys(formData.get("address2"));
        Select country = new Select(inputCountry);
        country.selectByValue(formData.get("country"));
        inputState.sendKeys(formData.get("state"));
        inputCity.sendKeys(formData.get("city"));
        inputZipcode.sendKeys(formData.get("zipCode"));
        inputMobileNumber.sendKeys(formData.get("phoneNumber"));
    }
    public void clickCreateAccount(){
        buttonCreateAccount.click();
    }
    public Boolean isVisibleTextAccountCreated(){
        return textAccountCreated.isDisplayed();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public Boolean isVisibleUserName(){
        return getDisplayedUserName.isDisplayed();
    }

    public void deleteAccount(){
        deleteAccountButton.click();
    }

    public Boolean isVisibleAccountDeletedMsg(){
        return accountDeletedMessage.isDisplayed();
    }
}
