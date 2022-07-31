import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        String fileDirectory =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",fileDirectory+"/src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement googleTextBox = driver.findElement(By.name("q"));
        googleTextBox.sendKeys("QA Guru");

        Thread.sleep(2000);


        WebElement googleSearchBtn = driver.findElement(By.name("btnK"));
//        WebElement googleSearchBtn = driver.findElement(By.className("gNO89b"));
        googleSearchBtn.click();

        Thread.sleep(2000);
        driver.close();

    }
}
