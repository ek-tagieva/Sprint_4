package ru.yandex.praktikum.scooter.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class MainScooterPage {
    private WebDriver driver;
    private final By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    private final By upperOrderButton = By.cssSelector(".Button_Button__ra12g");
    private final By lowerOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By arrowButton = By.id("accordion__heading-0");
    private final By infoText = By.id("accordion__panel-0");

    public MainScooterPage(WebDriver driver){
        this.driver = driver;

    }

    public void clickCookieButton(){

        driver.findElement(cookieButton).click();
    }
    public void clickTopOrderButton() {

        driver.findElement(upperOrderButton).click();
    }
    public void clickLowOrderButton() {

        driver.findElement(lowerOrderButton).click();
    }
    public void clickArrowButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(arrowButton));
        driver.findElement(arrowButton).click();
    }
    public String getArrowButton() {

        return driver.findElement(infoText).getText();
    }
    public void generalAction(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickCookieButton();
    }
}

