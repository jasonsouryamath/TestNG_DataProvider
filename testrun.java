package AutomationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testrun {
    WebDriver driver;
    String myurl = "https://www.ultimateqa.com/filling-out-forms/";
    fillformpage objfillform;

    @BeforeTest
    public WebDriver navigatetoweb() throws InterruptedException {
        driver =new FirefoxDriver();
        driver.get(myurl);

        if ("https://www.ultimateqa.com/filling-out-forms/".equals(driver.getCurrentUrl()) == false) {
            System.err.println("Wrong URL" + driver.getCurrentUrl() + "’");
        }
        return driver;
    }

    @Test (priority= 1, invocationCount = 1)
    public void testcase1_firstbox() throws InterruptedException {
        Thread.sleep(2000);
        objfillform = new fillformpage(driver);
        objfillform.fillformo("jason","msg");

    }
    @Test (priority= 2, invocationCount = 1)
    public void testcase2_secondbox() throws InterruptedException {
        Thread.sleep(2000);
        objfillform.fillsecondbox("jason1","msg1");
    }

    @Test (priority = 3, invocationCount = 1)
    public void testcase3_asserttext() throws InterruptedException{
        //assert the text "Form Filled out successfully" & Success after submitting both message box
        objfillform.assertetxt();
    }
    @AfterTest
    public void teardown() {
    //driver.quit();
    }
}
