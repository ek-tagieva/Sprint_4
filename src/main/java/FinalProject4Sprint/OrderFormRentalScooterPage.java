package FinalProject4Sprint;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class OrderFormRentalScooterPage { // Page Object страницы Про аренду
    private WebDriver driver;

    private final By titleField = By.className("Order_Header__BZXOb");
    private final By deliveryDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By leaseField = By.xpath(".//div[@class = 'Dropdown-control']");
    private final By anyNumberOfDays = By.xpath(".//div[@class = 'Dropdown-menu']");
    private final By colorBlackPearl = By.id("black");
    private final By colorGreyPearl = By.id("grey");
    private final By commentCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By orderRentButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2][@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    public OrderFormRentalScooterPage(WebDriver driver){
        this.driver = driver;
    }


    // Заполняем поля формы
    public void enterValueRentField(String deliveryDate, String comment){
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(deliveryDateField).sendKeys(Keys.ENTER);
        driver.findElement(leaseField).click();
        driver.findElement(anyNumberOfDays).click();
        driver.findElement(colorBlackPearl).click();
        driver.findElement(commentCourier).sendKeys(comment);

    }

    // Нажимаем на кнопку Заказать
      public void clickOrderRentButton(){
    driver.findElement(orderRentButton).click();
    }

    public String getTitleField(){
        return driver.findElement(titleField).getText();
    }




}

