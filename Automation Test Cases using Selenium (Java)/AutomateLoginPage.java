import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        // Assuming the basic auth is prompted by the browser
        driver.switchTo().alert().sendKeys("admin:admin");
        driver.switchTo().alert().accept();
        // Validate login success
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assert bodyText.contains("Congratulations! You must have the proper credentials.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
