import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class HoverTest {
    private WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
    }

    @Test
    public void hoverTest () throws InterruptedException {

        WebElement image1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(image1).perform();

        WebElement image1hoverText = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5"));
        Assert.assertEquals(image1hoverText.getText(),"name: user1");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
