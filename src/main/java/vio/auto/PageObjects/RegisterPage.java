package vio.auto.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vio.auto.AbstractComponents.AbstractComponent;

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
    @FindBy(id ="id_gender1" )
    WebElement userGender;


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

    public void enterUserAndEmail(Map<String, String> formData){
        userName.sendKeys(formData.get("username"));
        email.sendKeys(formData.get("email"));

    public void registerUser(Map<String, String> formData){



    }


}
