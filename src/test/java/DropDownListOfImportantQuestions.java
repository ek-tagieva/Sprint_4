import FinalProject4Sprint.MainScooterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertEquals;


public class DropDownListOfImportantQuestions { // Проверка выпадающего списка раздела "Вопросы о важном"
        private WebDriver driver;

    @Test
    public void clickArrowOpenTextChrome(){ // Когда нажимаешь на стрелочку, открывается соответствующий текст в Chrome
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickArrowButton();
        objMainScooterPage.getArrowButton();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual =  objMainScooterPage.getArrowButton();
        assertEquals(expected, actual);
        driver.quit();


    }

    @Test
    public void clickArrowOpenTextFirefox(){ // Когда нажимаешь на стрелочку, открывается соответствующий текст в Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickArrowButton();
        objMainScooterPage.getArrowButton();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual =  objMainScooterPage.getArrowButton();
        assertEquals(expected, actual);
        driver.quit();
    }



}
