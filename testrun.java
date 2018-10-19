package AutomationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testrun {
    WebDriver driver;
    String myurl = "https://www.ultimateqa.com/filling-out-forms/";
    fillformpage objfillform;
    evolvesovertime objevoform;

    @BeforeTest
    public WebDriver navigatetoweb() throws InterruptedException {
        driver =new FirefoxDriver();
        //driver =new ChromeDriver();
        driver.get(myurl);

        if ("https://www.ultimateqa.com/filling-out-forms/".equals(driver.getCurrentUrl()) == false) {
            System.err.println("Wrong URL" + driver.getCurrentUrl() + "’");
        }
        return driver;
    }

    @Test (threadPoolSize = 0,priority= 1, invocationCount = 1)
    public void testcase1_firstbox() throws InterruptedException {
        Thread.sleep(2000);
        objfillform = new fillformpage(driver);
        objfillform.fillformo("jason","msg");

    }
    @Test (threadPoolSize = 0,priority= 2, invocationCount = 1)
    public void testcase2_secondbox() throws InterruptedException {
        Thread.sleep(2000);
        objfillform.fillsecondbox("jason1","msg1");
    }

    @Test (threadPoolSize = 0,priority = 3, invocationCount = 1)
    public void testcase3_asserttext() throws InterruptedException{
        //assert the text "Form Filled out successfully" & Success after submitting both message box
        Thread.sleep(2000);
        objfillform.assertetxt();
    }

    @Test (threadPoolSize = 0, priority = 4, invocationCount= 1)
    public void testcase4_sprint1() {
        //go through each sprint iteration and fill forms
        objfillform.webnavigatenew();
        objevoform =  new evolvesovertime (driver);
        objevoform.clickingstuff();

    }
    @AfterTest
    public void teardown() {
    driver.quit();
    }
}
