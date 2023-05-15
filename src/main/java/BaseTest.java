import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    public final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startUp() {
        //1. Открыть сайт в режиме "headless"
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=");
        options.addArguments("headless");
        logger.info("Драйвер поднят");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void firstTest() {
    }

    @Test
    public void secondTest() {
    }

    @Test
    public void thirdTest() {
    }
}
