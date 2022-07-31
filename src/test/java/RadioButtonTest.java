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

public class RadioButtonTest {
    private WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void radiobuttonTest () throws InterruptedException {
        WebElement selectMaleRadioButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input"));
        selectMaleRadioButton.click();

        WebElement getCheckedValueButton = driver.findElement(By.id("buttoncheck"));
        getCheckedValueButton.click();

        WebElement checkedValueText = driver.findElement(By.className("radiobutton"));
        Assert.assertEquals(checkedValueText.getText(),"Radio button 'Male' is checked");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
