import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultiSelectTest {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void multiselectTest () throws InterruptedException {
        Select multiselectBox = new Select(driver.findElement(By.id("multi-select")));
        multiselectBox.selectByVisibleText("California");
        multiselectBox.selectByValue("Florida");

        WebElement firstSelectButton = driver.findElement(By.id("printMe"));
        firstSelectButton.click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement selectionConfirmation = driver.findElement(By.className("getall-selected"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(selectionConfirmation,"First selected option is : Florida"));

        FluentWait fluentWait = new FluentWait(driver)
                         .withTimeout(Duration.ofSeconds(20))
                         .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.textToBePresentInElement(selectionConfirmation,"First selected option is : Florida"))  ;



        Assert.assertEquals(selectionConfirmation.getText(),"First selected option is : Florida");

        Thread.sleep(2000);



    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
