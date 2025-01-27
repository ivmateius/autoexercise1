package vio.auto.Tests;

import org.testng.annotations.Test;
import vio.auto.PageObjects.LoginPage;
import vio.auto.TestComponents.BaseTest;

public class LoginCorrectDataTest extends BaseTest {
    @Test
    public void loginUser(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.goToSignupRegisterPage();
    }
}
