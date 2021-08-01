package pgrep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchasePg {
    WebDriver driver;

    public PurchasePg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    @FindBy(id = "country")
    WebElement Location;

    By countries= By.xpath("//*[@class = 'suggestions']//li/a");

    @FindBy(css = ".alert-success strong")
    WebElement orderPlaced;

    public WebElement DeliveryLocation() {
        return Location;
    }

    public List<WebElement> Countries() {
        return driver.findElements(countries);
    }

    public WebElement OrderPlaced() {
        return orderPlaced;
    }

}
