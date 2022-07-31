package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    @FindBy (id="username")
    private WebElement usernameTextBox;

    @FindBy (id="password")
    private WebElement passwordTextBox;

    @FindBy (className = "radius")
    private WebElement loginButton;


    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameTextBox(String usernameText){
        usernameTextBox.sendKeys(usernameText);
    }

    public void setPasswordTextBox(String passwordText) {
        passwordTextBox.sendKeys(passwordText);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
