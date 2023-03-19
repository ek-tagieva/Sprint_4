
import FinalProject4Sprint.MainScooterPage;
import FinalProject4Sprint.OrderFormForWhomScooterPage;
import FinalProject4Sprint.OrderFormRentalScooterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;



@RunWith(Parameterized.class)
public class OrderOneFormTest {
    private final String username;
    private final String family;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final boolean result;

    public OrderOneFormTest(String username, String family, String address, String metroStation, String telephone, boolean result) {
        this.username = username;
        this.family = family;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.result = result;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] FieldPersonalData() { // Каждая строка с данными — это тестовый набор для одного запуска теста: firstNumber, secondNumber, expected. Например, первый раз тест будет запущен со значениями 1, 9, 10, а второй — со значениями 1, 0, 1. Количество запусков теста равно количеству строк с данными.
        return new Object[][]{
                {"Кати", "Иванова", "Камова 7", "Преображенская площадь", "88988988998", true},
                {"Мари", "Петрова", "Ленина 15", "Бульвар Рокосовского", "89895677656", true},
        };
    }
    @Test
    public void PersonalDateTestOneChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.enterValueInSomeField(username, family, address, metroStation, telephone);
        objOrderFormForWhomScooterPage.clickNextButton();
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.getTitleField();
        String expected = "Про аренду";
        String actual = objOrderFormRentalScooterPage.getTitleField();
        assertEquals(result, actual.equals(expected));
        driver.quit();

    }

    @Test
    public void PersonalDateTestOneFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.enterValueInSomeField(username, family, address, metroStation, telephone);
        objOrderFormForWhomScooterPage.clickNextButton();
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.getTitleField();
        String expected = "Про аренду";
        String actual = objOrderFormRentalScooterPage.getTitleField();
        assertEquals(result, actual.equals(expected));
        driver.quit();

    }
}








