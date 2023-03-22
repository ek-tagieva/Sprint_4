import org.hamcrest.MatcherAssert;
import org.junit.After;
import ru.yandex.praktikum.scooter.page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class  OrderTwoFormTest {
    private WebDriver driver;
    private final String deliveryDate;
    private final String comment;
    private final boolean result;

    public OrderTwoFormTest(String deliveryDate, String comment, boolean result) {
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.result = result;
    }
    @Parameterized.Parameters
    public static Object[][] FieldPersonalDataTwo() {
        return new Object[][]{
                {"25.03.2023", "Привезите лето", true},
                {"30.03.2023", "обещали солнце", true},
        };
    }

    @Test
    public void personalDateTwoFormChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent(deliveryDate, comment);
        PopupWindowsPage objPopupWindowsPage = new PopupWindowsPage(driver);
        objPopupWindowsPage.clickButtonPopupYes();
        objPopupWindowsPage.getTextOrderCompleted();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String result  = objPopupWindowsPage.getTextOrderCompleted();
        MatcherAssert.assertThat(result, startsWith(expectedOrderIsProcessed));

    }

    @Test
    public void personalDateTwoFormFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent(deliveryDate, comment);
        PopupWindowsPage objPopupWindowsPage = new PopupWindowsPage(driver);
        objPopupWindowsPage.clickButtonPopupYes();
        objPopupWindowsPage.getTextOrderCompleted();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String result  = objPopupWindowsPage.getTextOrderCompleted();
        MatcherAssert.assertThat(result, startsWith(expectedOrderIsProcessed));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}









