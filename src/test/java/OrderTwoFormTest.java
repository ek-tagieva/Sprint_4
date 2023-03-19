import FinalProject4Sprint.MainScooterPage;
import FinalProject4Sprint.OrderFormForWhomScooterPage;
import FinalProject4Sprint.OrderFormRentalScooterPage;
import FinalProject4Sprint.PopupCheckoutQuestion;
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
public class OrderTwoFormTest {
    private final String deliveryDate;
    private final String comment;
    private final boolean result;

    public OrderTwoFormTest(String deliveryDate, String comment, boolean result) {
        this.deliveryDate = deliveryDate;
        this.comment = comment;
       this.result = result;
    }
    @Parameterized.Parameters
    public static Object[][] FieldPersonalDataTwo() { // Каждая строка с данными — это тестовый набор для одного запуска теста: firstNumber, secondNumber, expected. Например, первый раз тест будет запущен со значениями 1, 9, 10, а второй — со значениями 1, 0, 1. Количество запусков теста равно количеству строк с данными.
        return new Object[][]{
                {"25.03.2023", "Привезите лето", true},
                {"30.03.2023", "обещали солнце", true},
        };
    }

        @Test
        public void personalDateTestTwoChrome(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
            MainScooterPage objMainScooterPage = new MainScooterPage(driver);
            objMainScooterPage.clickTopOrderButton();
            OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            objOrderFormForWhomScooterPage.enterValueInSomeField("Мари", "Кошкина", "Ленина 15", "Преображенская площадь", "88988988998");
            objOrderFormForWhomScooterPage.clickNextButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
            objOrderFormRentalScooterPage.enterValueRentField(deliveryDate, comment);
            objOrderFormRentalScooterPage.clickOrderRentButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
            objPopupCheckoutQuestion.clickButtonPopupYes();
            driver.quit();
        }

        @Test
        public void PersonalDateTestTwoFirefox(){
            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
            MainScooterPage objMainScooterPage = new MainScooterPage(driver);
            objMainScooterPage.clickTopOrderButton();
            OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            objOrderFormForWhomScooterPage.enterValueInSomeField("Мари", "Кошкина", "Ленина 15", "Преображенская площадь", "88988988998");
            objOrderFormForWhomScooterPage.clickNextButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
            objOrderFormRentalScooterPage.enterValueRentField(deliveryDate, comment);
            objOrderFormRentalScooterPage.clickOrderRentButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
            objPopupCheckoutQuestion.clickButtonPopupYes();
            driver.quit();


        }








    }






