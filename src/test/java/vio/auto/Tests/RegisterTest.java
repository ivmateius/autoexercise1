package vio.auto.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import vio.auto.PageObjects.RegisterPage;
import vio.auto.TestComponents.BaseTest;

import java.io.IOException;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUser() throws IOException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToSignupRegisterPage();
        Assert.assertEquals(registerPage.getSignupText(), "New User Signup!", "Text not ok");
        registerPage.enterUserAndEmail(getData());
        Assert.assertEquals(registerPage.getAccInfoText(), "ENTER ACCOUNT INFORMATION", "Text not ok");
        registerPage.enterAccountInfo(getData());
        registerPage.checkBoxNewsletter();
        registerPage.checkBoxSpecialOffers();
        registerPage.enterAddressInfo(getData());
        registerPage.clickCreateAccount();
        Assert.assertTrue(registerPage.isVisibleTextAccountCreated());
        registerPage.clickContinueButton();
        Assert.assertTrue(registerPage.isVisibleUserName());
        registerPage.deleteAccount();
        Assert.assertTrue(registerPage.isVisibleAccountDeletedMsg());
        registerPage.clickContinueButton();
    }
}
