package ru.yandex.praktikum.scooter.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormForWhomScooterPage {
    private WebDriver driver;
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    private final By familyNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By subwayDropdownList = By.className("Order_SelectOption__82bhS");
    private final By telephoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderFormForWhomScooterPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterValueInSomeField(String username, String family, String address, String metroStation, String telephone) {
        driver.findElement(nameField).sendKeys(username);
        driver.findElement(familyNameField).sendKeys(family);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(subwayDropdownList).click();
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(nextButton).click();
    }

    public void clickNextButton(){

        driver.findElement(nextButton).click();
    }
    public void fieldAndNext(String username, String family, String address, String metroStation, String telephone){
        enterValueInSomeField(username, family, address, metroStation, telephone);
        clickNextButton();
    }
}








