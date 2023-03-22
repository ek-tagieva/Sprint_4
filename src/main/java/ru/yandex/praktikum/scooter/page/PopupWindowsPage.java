package ru.yandex.praktikum.scooter.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupWindowsPage {
    private WebDriver driver;
    private final By buttonPopupNo = By.xpath(".//div[2]/button[1][@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    private final By buttonPopupYes = By.xpath(".//div[2]/button[2][@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By textOrderCompleted = By.className("Order_ModalHeader__3FDaJ");

    public PopupWindowsPage(WebDriver driver) {
        this.driver = driver;

    }
    public void clickButtonPopupYes(){
        driver.findElement(buttonPopupYes).click();
    }
    public String getTextOrderCompleted(){
        return driver.findElement(textOrderCompleted).getText();
    }

}
