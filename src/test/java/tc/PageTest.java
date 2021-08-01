package tc;


import BrowserInvoke.browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.*;
import pgrep.homwpageTest;

import java.io.IOException;


public class PageTest extends browser {
    public WebDriver driver;
    private static final Logger log = LogManager.getLogger(PageTest.class.getName());

    @BeforeTest
    public void invoke() throws IOException {
        driver = browserInvoke();
        driver.get(props.getProperty("URL"));
        driver.manage().window().fullscreen();
    }


    @Test(dataProvider = "data")
    public void LoginPage(String name, String password, String emailId, String gender, String dob) throws InterruptedException {

        homwpageTest hp = new homwpageTest(driver);
        log.info("Entering username: " + name);

        hp.getUserName().sendKeys(name);
        log.info("Entering EmailId: " + emailId);

        hp.getEmailId().sendKeys(emailId);
        log.info("Password is : " + password);

        hp.getPassword().sendKeys(password);
        hp.getCeckBox().click();

        select(hp.getGender(),gender);
        log.info("Gender: " + gender);
        hp.getStatus().click();

        log.info("Date of birth: " + dob);
        hp.getDOB().sendKeys(dob);
        hp.getSub().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        String txt = hp.popupmsg().getText();
        Assert.assertEquals(txt, "Success!");

        log.info("Successfully datas are entered");
        driver.navigate().refresh();


    }
    

    @DataProvider
    public Object[][] data() {
        Object text[][] = new Object[3][5];

        text[0][0] = "Sam";
        text[0][1] = "Sam@gmail.com";
        text[0][2] = "password";
        text[0][3] = "Male";
        text[0][4] = "10/05/2022";

        text[1][0] = "Chopper";
        text[1][1] = "Chopper@gmail.com";
        text[1][2] = "qws#$56sc";
        text[1][3] = "Male";
        text[1][4] = "31/12/2000";

        text[2][0] = "Ankitha";
        text[2][1] = "Ankitha@gmail.com";
        text[2][2] = "!@#$%^";
        text[2][3] = "Female";
        text[2][4] = "3/1/1999";


        return text;

    }
    @AfterClass
    public void close() {
        driver.quit();
    }


}


