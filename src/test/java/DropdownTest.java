import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DropdownTest {

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
    public void dropdownTest () throws InterruptedException {
        WebElement dropdownLink = driver.findElement(By.xpath("//a[text()='Dropdown']"));
        dropdownLink.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropdownLink2 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Dropdown']"))));

        Select dropdownList = new Select(driver.findElement(By.id("dropdown")));
        dropdownList.selectByVisibleText("Option 1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Thread.sleep(2000);
//        dropdownList.selectByValue("2");
//        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
