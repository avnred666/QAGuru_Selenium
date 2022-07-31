import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxTest {
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
    public void checkBoxTest () throws InterruptedException {
        WebElement checkboxLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxLink.click();

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        checkbox2.click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
