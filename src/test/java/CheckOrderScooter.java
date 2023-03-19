

import FinalProject4Sprint.MainScooterPage;
import FinalProject4Sprint.OrderFormForWhomScooterPage;
import FinalProject4Sprint.OrderFormRentalScooterPage;
import FinalProject4Sprint.PopupCheckoutQuestion;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;




public class CheckOrderScooter {// Проверка заказа самоката
    //каждой странице приложения соответствует класс. Веб-элементы становятся полями этого класса, а действия с ними — методами.
    private WebDriver driver;


    @Test
    public void checkingTopOrderButtonChrome() { // Заказ через верхнюю кнопку в Chrome

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objOrderFormForWhomScooterPage.enterValueInSomeField("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        objOrderFormForWhomScooterPage.clickNextButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.enterValueRentField("20.03.2023", "Привезите лето");
        objOrderFormRentalScooterPage.clickOrderRentButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        driver.quit();
    }

    @Test
    public void checkingIowOrderButtonChrome(){ // Заказ через нижнюю кнопку в Chrome
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickLowOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objOrderFormForWhomScooterPage.enterValueInSomeField("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        objOrderFormForWhomScooterPage.clickNextButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.enterValueRentField("20.03.2023", "Привезите лето");
        objOrderFormRentalScooterPage.clickOrderRentButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        driver.quit();


    }
    @Test
    public void checkingTopOrderButtonFirefox(){ // Заказ через верхнюю кнопку в Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objOrderFormForWhomScooterPage.enterValueInSomeField("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        objOrderFormForWhomScooterPage.clickNextButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.enterValueRentField("20.03.2023", "Привезите лето");
        objOrderFormRentalScooterPage.clickOrderRentButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        driver.quit();
    }
    @Test
    public void checkingIowOrderButtonFirefox(){ // Заказ через нижнюю кнопку в Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Делаем на весь экран
        driver.manage().window().maximize();
        // Ждем когда прогрузится страница
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
        MainScooterPage objMainScooterPage = new MainScooterPage(driver);
        objMainScooterPage.clickTopOrderButton();
        OrderFormForWhomScooterPage objOrderFormForWhomScooterPage = new OrderFormForWhomScooterPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objOrderFormForWhomScooterPage.enterValueInSomeField("Екатерина", "Тагиева", "Ленина 15", "Преображенская площадь", "88988988998");
        objOrderFormForWhomScooterPage.clickNextButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderFormRentalScooterPage objOrderFormRentalScooterPage = new  OrderFormRentalScooterPage(driver);
        objOrderFormRentalScooterPage.enterValueRentField("20.03.2023", "Привезите лето");
        objOrderFormRentalScooterPage.clickOrderRentButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PopupCheckoutQuestion objPopupCheckoutQuestion = new  PopupCheckoutQuestion(driver);
        objPopupCheckoutQuestion.clickButtonPopupYes();
        driver.quit();
    }


}














//
////        // Кликаем на кнопку куки
////        driver.findElement(By.xpath(".//button[@class='App_CookieButton__3cvqF']")).click();
////         Кликаем на кнопку Заказать
//        driver.findElement(By.className("Button_Button__ra12g")).click();
////        // Ждем когда прогрузится страница
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        // Заполняем поле Имя
//        driver.findElement(By.xpath(".//input[@placeholder = '* Имя']")).sendKeys("Екатерина");
////         // Заполняем поле Фамилия
//        driver.findElement(By.xpath(".//input[@placeholder = '* Фамилия']")).sendKeys("Тагиева");
////         // Заполняем поле адрес
//        driver.findElement(By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']")).sendKeys("Ленина 15");
////        // Заполняем поле станции метро
//        driver.findElement(By.xpath(".//input[@placeholder = '* Станция метро']")).sendKeys("Бульвар Рокосовского");
////       // Кликаем на название выпадающего метро
//        driver.findElement(By.className("Order_SelectOption__82bhS")).click();
////        // Заполняем поле телефон
//        driver.findElement(By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']")).sendKeys("89899899889");
////        // Клик на кнопку Далее
//        driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        // Заполняем поле Когда привезти самокат
//        driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")).sendKeys("24.03.2023");
////        // Кликаем по дате доставки
//        driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")).sendKeys(Keys.ENTER);
////        driver.findElement(By.xpath(".//div[@aria-label = 'Choose пятница, 24-е марта 2023 г.']")).click();
////        // Кликаем на поле Срок аренды
////        driver.findElement(By.xpath(".//div[@class = 'Dropdown-control']")).click();
////       // Кликаем на поле меню для выбора любого количества суток
//        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']")).click();
////        // Кликнуть по чекбоксу выбора черного цвета
//        driver.findElement(By.id("black")).click();
////        // Кликнуть по чекбоксу выбора серого цвета
////        //driver.findElement(By.id("grey")).click();
////        // Заполнить поле комментарий
////        driver.findElement(By.xpath(".//input[@placeholder = 'Комментарий для курьера']")).sendKeys("Привезите лето");
////        // Нажать на кнопку Заказать
////        driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        // Хотите оформить заказ нажать Да
////        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driver.findElement(By.xpath(".//div[2]/button[2][@class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
////        // Хотите оформить заказ нажать Нет
////       //driver.findElement(By.xpath(".//div[2]/button[1][@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']")).click();
//
//        Закрой страницу
//        driver.quit();









