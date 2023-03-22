import org.junit.After;
import ru.yandex.praktikum.scooter.page.MainScooterPage;
import ru.yandex.praktikum.scooter.page.OrderFormForWhomScooterPage;
import ru.yandex.praktikum.scooter.page.OrderFormRentalScooterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class OrderOneFormTest {
    private WebDriver driver;
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

    @Parameterized.Parameters
    public static Object[][] FieldPersonalData() {
        return new Object[][]{
                {"Кати", "Иванова", "Камова 7", "Преображенская площадь", "88988988998", true},
                {"Мари", "Петрова", "Ленина 15", "Бульвар Рокосовского", "89895677656", true},
        };
    }

    @Test
    public void personalDateOneFormChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext(username, family, address, metroStation, telephone);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.getTitleField();
        String expected = "Про аренду";
        String actual = objOrderFormRentalScooterPage.getTitleField();
        assertEquals(result, actual.equals(expected));

    }

    @Test
    public void personalDateOneFormFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext(username, family, address, metroStation, telephone);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.getTitleField();
        String expected = "Про аренду";
        String actual = objOrderFormRentalScooterPage.getTitleField();
        assertEquals(result, actual.equals(expected));

    }

    @After
    public void teardown() {
        driver.quit();
    }

}








