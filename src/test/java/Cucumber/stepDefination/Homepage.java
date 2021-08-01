package Cucumber.stepDefination;

import BrowserInvoke.browser;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pgrep.AddToCart;
import pgrep.PurchasePg;
import pgrep.ShoppgTest;
import pgrep.homwpageTest;
import tc.ShopTest;

import java.util.List;

public class Homepage extends browser {
    private static final Logger log = LogManager.getLogger(ShopTest.class.getName());
    homwpageTest hp;
    String MobileName;
    String countryName;
    ShoppgTest sp;
    AddToCart cart;
    PurchasePg pg;

    @Given("^Invoking the browser with chrome$")
    public void invoking_the_browser_with_chrome() throws Throwable {
        log.info("Launching the browser");
        driver = browserInvoke();
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String url) throws Throwable {
        log.info("Landing on an angularPractice site");
        driver.get(url);
    }

    @When("^user should enter Name (.+) EmailId (.+) and password (.+)$")
    public void user_should_enter_name_emailid_and_password(String name, String email, String pass) throws Throwable {
        hp = new homwpageTest(driver);
        log.info("Entering username: " + name);
        hp.getUserName().sendKeys(name);
        log.info("Entering emailId: " + email);
        hp.getEmailId().sendKeys(email);
        log.info("Entering password: " + pass);
        hp.getPassword().sendKeys(pass);

    }

    @And("^Click the checkbox$")
    public void click_the_checkbox() throws Throwable {
        hp.getCeckBox().click();
    }

    @And("^Enter Gender(.+) DOB(.+) and click on Employment Status$")
    public void enter_gender_dob_and_click_on_employment_status(String gender, String dob) throws Throwable {
        log.info("Gender: " + gender);
        select(hp.getGender(), gender);
        hp.getStatus().click();
        log.info("Date of birth: " + dob);
        hp.getDOB().sendKeys(dob);

    }

    @Then("^Click submit$")
    public void click_submit() throws Throwable {
        hp.getSub().click();
    }

    @And("^Verify login successfully$")
    public void verify_login_successfully() throws Throwable {
        String txt = hp.popupmsg().getText();
        log.info("Successfully data are entered");
        Assert.assertEquals(txt, "Success!");
    }


    @Given("^Click Shop button$")
    public void click_shop_button() throws Throwable {
        sp = new ShoppgTest(driver);
        log.info("Clicking on shop key");
        sp.button().click();
    }

    @When("^User should select mobile brand (.+) and add to cart$")
    public void user_should_select_mobile_brand_and_add_to_cart(String mobile) throws Throwable {
        List<WebElement> model = sp.brand();
        log.info("Selecting mobile brand: " + mobile);
        MobileName = mobile;
        for (int i = 0; i < model.size(); i++) {
            String nam = model.get(i).getText();
            if (nam.contains(MobileName)) {
                sp.add().get(i).click();
                break;
            }
        }
    }

    @Then("^Click Checkout$")
    public void click_checkout() throws Throwable {
        cart = sp.check();
    }

    @When("^Now check whether selected mobile is present in checkout page$")
    public void now_check_whether_selected_mobile_is_present_in_checkout_page() throws Throwable {
        String mobName = cart.MobileName().getText();
        log.info("verifying whether selected mobile is present in checkout page");
        Assert.assertEquals(MobileName, mobName);
        String price = cart.Price().getText();
        String totalPrice = cart.TotalPrice().getText();
        log.info("verifying whether selected mobile's price is same in checkout page");
        Assert.assertEquals(price, totalPrice);
    }

    @Then("^Click checkbox button$")
    public void click_checkbox_button() throws Throwable {
        pg = cart.Check();
    }


    @When("^User should enter delivery location (.+)$")
    public void user_should_enter_delivery_location(String city) throws Throwable {
        pg.DeliveryLocation().click();
        pg.DeliveryLocation().sendKeys("s");
        log.info("Entering delivery location: " + city);
        countryName = city;
        Wait("//*[@class = 'suggestions']//li/a");
        List<WebElement> country = pg.Countries();
        for (WebElement countries : country) {
            if (countries.getText().equalsIgnoreCase(countryName)) {
                countries.click();
                break;
            }
        }
    }

    @And("^Click purchase button$")
    public void click_purchase_button() throws Throwable {
        pg = cart.Check();
    }

    @Then("^Verify order is placed or not$")
    public void verify_order_is_placed_or_not() throws Throwable {
        String txt = pg.OrderPlaced().getText();
        log.info("verifying that order is placed successfully or not");
        Assert.assertEquals("Success!", txt);
    }

    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
        driver.quit();
    }
}
