import org.hamcrest.MatcherAssert;
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
import ru.yandex.praktikum.scooter.page.PopupWindowsPage;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class MakeAnOrder {
    private WebDriver driver;
    private final String username;
    private final String family;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String deliveryDate;
    private final String comment;
    private final boolean result;

    public MakeAnOrder(String username, String family, String address, String metroStation, String telephone, String deliveryDate, String comment, boolean result) {
        this.username = username;
        this.family = family;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] FillingFieldPersonalData() {
        return new Object[][]{
                {"Кати", "Иванова", "Камова 7", "Преображенская площадь", "88988988998", "25.03.2023", "Привезите лето", true},
                {"Мари", "Петрова", "Ленина 15", "Бульвар Рокосовского", "89895677656", "30.03.2023", "обещали солнце", true},
        };
    }

    @Test
    public void fillingPersonalDateChrome() {
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
        objOrderFormRentalScooterPage.fieldAndRent(deliveryDate, comment);
        PopupWindowsPage objPopupWindowsPage = new PopupWindowsPage(driver);
        objPopupWindowsPage.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupWindowsPage.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));

    }

    @Test
    public void fillingPersonalDateFirefox() {
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
        objOrderFormRentalScooterPage.fieldAndRent(deliveryDate, comment);
        PopupWindowsPage objPopupWindowsPage = new PopupWindowsPage(driver);
        objPopupWindowsPage.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupWindowsPage.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));

    }

    @After
    public void teardown() {
        driver.quit();
    }

}

