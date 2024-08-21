package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage  extends BasePage  {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailTextBox = By.id("email");
    private final By passwordTextBox = By.id("passwd");
    private final By signInButton = By.id("SubmitLogin");

    public void setEmail(String email) {
        sendKeys(emailTextBox, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }

}
