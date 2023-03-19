package FinalProject4Sprint;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class MainScooterPage { // Page Object Главной страницы
    private WebDriver driver;
    // Верхняя кнопка Заказать
    private final By upperOrderButton = By.xpath(".//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1][@class = 'Button_Button__ra12g']");
    // Нижняя кнопка Заказать
    private final By lowerOrderButton = By.xpath(".//div[5]/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    // Стрелочка Вопросы о важном
    private final By arrowButton = By.xpath(".//*[@id=\"accordion__heading-0\"]");
    // Текст после нажатия стрелочки
    private final By infoText = By.id("accordion__panel-0");
    public MainScooterPage(WebDriver driver){
        this.driver = driver;

    }

    // Клик по верхней кнопке Заказать
    public void clickTopOrderButton() {

        driver.findElement(upperOrderButton).click();
    }
    // Клик по нижней кнопке Заказать
    public void clickLowOrderButton() {

        driver.findElement(lowerOrderButton).click();
    }
    // Клик по стрелочке в разделе Вопросы о важном
    public void clickArrowButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(arrowButton));
        driver.findElement(arrowButton).click();
    }

    // Получение элемента после клика
    public String getArrowButton() {

        return driver.findElement(infoText).getText();

    }

}

