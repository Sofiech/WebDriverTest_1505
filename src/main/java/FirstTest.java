import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FirstTest extends BaseTest {

    @Test
    public void shouldBeTitleVisible (){
        setUp();
        startUp();
        //1. Открыть в режиме полного окна
        driver.manage().window().maximize();
        //2. Зайти на сайт -> https://duckduckgo.com/
        driver.get("https://duckduckgo.com/");
        logger.info("Главная страница поискового сайта открыта");

        //3. Найти поисковую строку и ввести "ОТУС":
        WebElement findEl = driver.findElement(By.cssSelector("#content_homepage > div > div.search-wrap--home"));
        logger.info("Поисковая строка найдена");
        findEl.sendKeys("Отус", Keys.ENTER);
        logger.info("В поисковую строку введено слово ОТУС и ENTER -> переход");
        // 4. Проверить результат "Онлайн-курсы....
            // A_ВАРИАНТ извлечения элемента из DOM с помощью cssSelector ->
        String locator = driver.findElement(By.cssSelector("head > meta:nth-child(31)")).getText();
        assertEquals(locator,"Авторские онлайн-курсы для профессионалов");

            //B_ВАРИАНТ извлечения элемента с помощью xpath ->
        String title = driver.findElement(By.xpath("/html/head/title/meta[7]")).getText();
        assertSame(title, "Авторские онлайн-курсы для профессионалов");
    }
}
