package FinalProject4Sprint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupCheckoutQuestion { // Page Object всплывающего окна "Хотите оформить заказ?"
    private WebDriver driver;
    private final By buttonPopupNo = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1][@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    private final By buttonPopupYes = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2][@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    public PopupCheckoutQuestion(WebDriver driver) {
        this.driver = driver;

    }
    public void clickButtonPopupNo(){
        driver.findElement(buttonPopupNo).click();
    }

    public void clickButtonPopupYes(){
        driver.findElement(buttonPopupYes).click();
    }

}
