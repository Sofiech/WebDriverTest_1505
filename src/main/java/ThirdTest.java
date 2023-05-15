import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirdTest extends BaseTest {

    private final String hostname = System.getProperty("base.url");

    @Test
    public void openPageOtus(){
        driver.quit();
        setUp();
        startUp();
    //1.Открыть сайт headless + полного окна
        driver.manage().window().fullscreen();
        driver.get(hostname);
        logger.info("Открыта страница отус");

    //2. Авторизоваться на сайте
        auth();

    //3. Войти в личный кабинет
        enterLK();

    //4. Отразить все кукки
        cookieTest();
    }
                                            //Метод авторизации
    private void auth(){
        String locator = ".header3__button-sign-in";
        By.cssSelector(locator).findElement(driver).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    //логин в виде эл.почты
        String LOGIN = "tistegitra@tozya.com";
        driver.findElement(By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)"))
                .sendKeys(LOGIN);
    //пароль
        String PAS = "Qwerty76_";
        driver.findElement(By.cssSelector(".js-psw-input"))
                .sendKeys(PAS);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
    }

    private void enterLK(){
        driver.get("https://otus.ru/lk/biography/personal/");
        logger.info("Перешел в личный кабинет");
    }

    public void cookieTest(){
        // Отразить все cookies

        driver.manage().addCookie(new Cookie("key", "value"));
        driver.manage().getCookies();
        assertEquals(0,driver.manage().getCookies().size());

    }

}
