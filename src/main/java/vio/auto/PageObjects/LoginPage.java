package vio.auto.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vio.auto.AbstractComponents.AbstractComponent;

import java.util.Map;

public class LoginPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = "a[href='/login'")
    WebElement loginRegister;
    @FindBy(css = "input[data-qa='signup-name']")
    WebElement userName;
    @FindBy(css = "input[data-qa='signup-email']")
    WebElement email;
    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signupButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToSignupRegisterPage(){
        closeConsentPopUp();
        waitForWebElementToAppear(loginRegister);
        loginRegister.click();
    }

    public void getLoginInfo(Map<String, String> formData){
        RegisterPage registerPage=new RegisterPage(driver);
        String user=registerPage.enterRandomUserAndEmail();
        String pass=formData.get("password");
    }


}
