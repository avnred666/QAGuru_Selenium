import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormAuthenticationTest {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testFormAuthentication() throws InterruptedException {
        WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();

        WebElement usernameTextBox = driver.findElement(By.id("username"));
        usernameTextBox.sendKeys("tomsmith");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(),"The Internet");

        WebElement logoutButton = driver.findElement(By.className("secondary"));
        Assert.assertTrue(logoutButton.isDisplayed());

        Thread.sleep(1000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
