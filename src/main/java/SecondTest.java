import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SecondTest extends BaseTest{

    @Test
    public void setWindow() {

        final String URL = " https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";

        //1. Окно в стиле киоск
        driver.quit();
        setUp();
        startUp();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        logger.info("Сайт на нужной странице открыт");

        //2.Определяемся с локатором нужной картинки и переходим к ней,
        WebElement gallery = driver.findElement(By.cssSelector("body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(3)"));
        gallery.sendKeys("Keys.PAGE_DOWN");
        WebElement picture = driver.findElement(By.cssSelector("body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(3) > span > a > img"));
        picture.click();
        logger.info("Модальное окно отражено");
    }

}
