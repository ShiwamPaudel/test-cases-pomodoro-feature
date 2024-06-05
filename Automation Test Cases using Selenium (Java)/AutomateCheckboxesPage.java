import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // Check the first checkbox
        driver.findElement(By.xpath("//input[1]")).click();
        assert driver.findElement(By.xpath("//input[1]")).isSelected();
        // Uncheck the second checkbox
        driver.findElement(By.xpath("//input[2]")).click();
        assert !driver.findElement(By.xpath("//input[2]")).isSelected();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
