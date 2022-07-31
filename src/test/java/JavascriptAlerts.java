import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavascriptAlerts {
    private WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

    @Test
    public void javascriptAlertsTest () throws InterruptedException {
        WebElement clickForJSAlert = driver.findElement(By.xpath(".//button[text()='Click for JS Alert']"));
        driver.switchTo().alert().accept();
        clickForJSAlert.click();
        driver.switchTo().alert().accept();
        WebElement resultText = driver.findElement(By.id("result"));
        Assert.assertEquals(resultText.getText(),"You successfully clicked an alert");

        WebElement clickForJSConfirm = driver.findElement(By.xpath(".//button[text()='Click for JS Confirm']"));
        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(resultText.getText(),"You clicked: Cancel");

        WebElement clickForJSPrompt = driver.findElement(By.xpath(".//button[text()='Click for JS Prompt']"));
        clickForJSPrompt.click();
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();
        Assert.assertEquals(resultText.getText(),"You entered: Test");

        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
