package vio.auto.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import vio.auto.PageObjects.RegisterPage;
import vio.auto.TestComponents.BaseTest;
import vio.auto.data.DataReader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUser() throws IOException {
//       String filePath ="src/test/java/vio/auto/data/UserData.json";
//
//        // Initialize the DataReader to fetch data from JSON
//        DataReader dataReader = new DataReader();
//        Map<String, String> formData = dataReader.getFormData(filePath);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToSignupRegisterPage();
        Assert.assertEquals(registerPage.getSignupText(), "New User Signup!", "Text not ok");
        registerPage.enterUserAndEmail(getData());


    }
}
