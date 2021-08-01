package pgrep;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homwpageTest {


    WebDriver driver;
    public homwpageTest(WebDriver driver){
        this.driver = driver;
    }


    private By userName = By.xpath("//*[contains(@class,'ng-pristine')]/div[1]/input");
    By emailId = By.xpath("//*[@name='email']");
    By password = By.xpath("//*[@type='password']");
    By checkbox = By.xpath("//*[@id='exampleCheck1']");
    By gender = By.xpath("//*[@id='exampleFormControlSelect1']");
    By employmentStatus = By.xpath("//*[@id='inlineRadio2']");
    By DOB = By.xpath("//*[@name='bday']");
    By submit = By.xpath("//*[@type='submit']");
    By popup = By.xpath("//div[2]/div/strong");

    //By shop = By.linkText("Shop");


    public WebElement getUserName() {
        return driver.findElement(userName);
    }

    public WebElement getEmailId() {
        return driver.findElement(emailId);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getCeckBox() {
        return driver.findElement(checkbox);
    }

    public WebElement getGender() {
        return driver.findElement(gender);
    }

    public WebElement getStatus() {
        return driver.findElement(employmentStatus);
    }

    public WebElement getDOB() {
        return driver.findElement(DOB);
    }

    public WebElement getSub() {
        return driver.findElement(submit);
    }
    public WebElement popupmsg() {
        return driver.findElement(popup);
    }

//    public WebElement button() {
//         driver.findElement(shop).click();
//         ShoppgTest st = new ShoppgTest(driver);
//         return (WebElement) st;
//    }


}



