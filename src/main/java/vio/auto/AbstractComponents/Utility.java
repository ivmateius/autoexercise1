package vio.auto.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Utility extends AbstractComponent{
    WebDriver driver;
    public Utility(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Letters and numbers for the username
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            email.append(characters.charAt(randomIndex));
        }

        email.append("@");
        email.append("vio.vio");

        return email.toString();
    }
    public String generateRandomUserName() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Letters and numbers for the username
        StringBuilder userName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            userName.append(characters.charAt(randomIndex));
        }
        return userName.toString();
    }
}
