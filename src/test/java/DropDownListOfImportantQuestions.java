import ru.yandex.praktikum.scooter.page.MainScooterPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertEquals;
import org.junit.After;


public class DropDownListOfImportantQuestions {
    private WebDriver driver;

    @Test
    public void clickArrowOpenTextChrome(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickArrowButton();
        objMainScooterPage.getArrowButton();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual =  objMainScooterPage.getArrowButton();
        assertEquals(expected, actual);

    }

    @Test
    public void clickArrowOpenTextFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickArrowButton();
        objMainScooterPage.getArrowButton();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual =  objMainScooterPage.getArrowButton();
        assertEquals(expected, actual);

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
