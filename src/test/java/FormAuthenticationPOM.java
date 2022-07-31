import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;


public class FormAuthenticationPOM {
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
    public void testFormAuthenticationPOM() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        LoginPage loginPage = homePage.clickFormLink();
        loginPage.setUsernameTextBox("tomsmith");
        loginPage.setPasswordTextBox("SuperSecretPassword!");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getTitle(),"The Internet");
        Thread.sleep(2000);



//        WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
//        formAuthenticationLink.click();
//
//        WebElement usernameTextBox = driver.findElement(By.id("username"));
//        usernameTextBox.sendKeys("tomsmith");
//
//        WebElement passwordTextBox = driver.findElement(By.id("password"));
//        passwordTextBox.sendKeys("SuperSecretPassword!");
//
//        WebElement loginButton = driver.findElement(By.className("radius"));
//        loginButton.click();
//
//        Assert.assertEquals(driver.getTitle(),"The Internet");
//
//        WebElement logoutButton = driver.findElement(By.className("secondary"));
//        Assert.assertTrue(logoutButton.isDisplayed());


    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
