package pgrep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
    public static WebDriver driver;

    public AddToCart(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class = 'media-body']/h4/a")
    WebElement mobileName;

    @FindBy(xpath = "//*[@class = 'table table-hover']//td[4]/strong")
    WebElement price;

    @FindBy(css = ".text-right h3 strong")
    WebElement totalPrice;

    @FindBy(css = ".btn.btn-success")
    WebElement out;


    public WebElement MobileName() {
        return mobileName;
    }

    public WebElement Price() {
        return price;
    }

    public WebElement TotalPrice() {
        return totalPrice;
    }

    public PurchasePg Check() {
         out.click();
        PurchasePg pg = new PurchasePg(driver);
        return pg;
    }

}
