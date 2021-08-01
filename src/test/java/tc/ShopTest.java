package tc;

import org.apache.commons.io.FileUtils;
import BrowserInvoke.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pgrep.AddToCart;
import pgrep.PurchasePg;
import pgrep.ShoppgTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShopTest extends browser {

    public  WebDriver driver;
    private static final Logger log = LogManager.getLogger(ShopTest.class.getName());
    String name;
    String countryName;
    ShoppgTest sp;
    AddToCart cart;
    PurchasePg pg;

    @BeforeTest
    public void invoke() throws IOException {
        driver = browserInvoke();
        driver.get(props.getProperty("URL"));
        driver.manage().window().fullscreen();
    }

    @Test
    public void MobileBrandSelection() throws IOException {

        sp = new ShoppgTest(driver);
        sp.button().click();
        List<WebElement> model = sp.brand();
        name = "Nokia Edge";
        log.info("Selecting mobile model");
        for (int i = 0; i < model.size(); i++) {
            String nam = model.get(i).getText();
            if (nam.contains(name)) {
                sp.add().get(i).click();
                break;
            }
        }
        log.info("Add to cart");
        cart = sp.check();
    }

    @Test
    public void MobileCheckout() {

        String mobName = cart.MobileName().getText();
        log.info("verifying the selected mobile name");
        Assert.assertEquals(name, mobName);
        String price = cart.Price().getText();
        String totalPrice = cart.TotalPrice().getText();
        log.info("verifying the selected mobile price");
        Assert.assertEquals(price, totalPrice);
        pg = cart.Check();
    }

    @Test
    public void MobilePurchase() {
        pg.DeliveryLocation().click();
        pg.DeliveryLocation().sendKeys("s");
        log.info("Delivering location");
        countryName = "Netherlands";
        Wait("//*[@class = 'suggestions']//li/a");
        List<WebElement> country = pg.Countries();
        for (WebElement countries : country) {
            if (countries.getText().equalsIgnoreCase(countryName)) {
                countries.click();
                break;
            }
        }

        pg = cart.Check();
        String txt = pg.OrderPlaced().getText();
        log.info("verifying whether success msg is popping up");
        Assert.assertEquals("Success!", txt);


    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}

