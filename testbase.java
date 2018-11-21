package AutomationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract class testbase {
    public static WebDriver driver= null;
    public static WebDriverWait wait;
    public static ExpectedConditions EC;


    String myurl = "https://www.ultimateqa.com/filling-out-forms/";
    fillformpage objfillform;
    evolvesovertime objevoform;

    @BeforeTest
    public final  WebDriver navigatetoweb() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver =new ChromeDriver();
        driver.get(myurl);
        driver.manage().window().maximize();

        if ("https://www.ultimateqa.com/filling-out-forms/".equals(driver.getCurrentUrl()) == false) {
            System.err.println("Wrong URL" + driver.getCurrentUrl() + "’");
        }
        return driver;
    }
        @AfterTest
        public void teardown() {

            driver.quit();
}
}
