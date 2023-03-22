import org.hamcrest.MatcherAssert;
import org.junit.After;
import ru.yandex.praktikum.scooter.page.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.CoreMatchers.startsWith;


public class CheckOrderScooter {
    private WebDriver driver;

    @Test
    public void checkingTopOrderButtonChrome() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent("20.03.2023", "Привезите лето");
        PopupWindowsPage objPopupCheckoutQuestion = new PopupWindowsPage(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupCheckoutQuestion.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));

    }

    @Test
    public void checkingLowOrderButtonChrome() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickLowOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent("20.03.2023", "Привезите лето");
        PopupWindowsPage objPopupCheckoutQuestion = new PopupWindowsPage(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupCheckoutQuestion.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));
    }

    @Test
    public void checkingTopOrderButtonFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent("20.03.2023", "Привезите лето");
        PopupWindowsPage objPopupCheckoutQuestion = new PopupWindowsPage(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupCheckoutQuestion.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));

    }

    @Test
    public void checkingLowOrderButtonFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.generalAction();
        objMainScooterPage.clickLowOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        objOrderFormForWhomScooterPage.fieldAndNext("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.fieldAndRent("20.03.2023", "Привезите лето");
        PopupWindowsPage objPopupCheckoutQuestion = new PopupWindowsPage(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        String expectedOrderIsProcessed = "Заказ оформлен";
        String actualOrderIsProcessed  = objPopupCheckoutQuestion.getTextOrderCompleted();
        MatcherAssert.assertThat(actualOrderIsProcessed, startsWith(expectedOrderIsProcessed));

    }

    @After
    public void teardown() {
        driver.quit();
    }

}























