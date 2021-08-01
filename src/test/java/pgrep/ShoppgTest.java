package pgrep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppgTest {

    WebDriver driver;

    public ShoppgTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    @FindBy(linkText = "Shop")
    WebElement shop;

    By mob = By.xpath("//*[@class='card h-100']//h4/a");

    By cart = By.cssSelector(".btn.btn-info");


    @FindBy(css = ".nav-link.btn-primary")
    WebElement checkOut;


    public WebElement button(){
        return shop;
    }

    public List<WebElement> brand (){
        return driver.findElements(mob);
    }

    public List<WebElement> add (){
        return driver.findElements(cart);
    }


    public AddToCart check () {
         checkOut.click();
         AddToCart cart = new AddToCart(driver);
         return cart;
    }
}
