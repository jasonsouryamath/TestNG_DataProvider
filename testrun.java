package AutomationTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;


public class testrun  {
    WebDriver driver;
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

    @Test  ( threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"name","message"})
    public void testcase1_firstbox(String name, String message) throws InterruptedException, IOException, AWTException {
        Thread.sleep(2000);
        objfillform = new fillformpage(driver);
        objfillform.fillformo(name,message);
        objfillform.screenshot();
    }
    @Test  ( threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"sname","smessage"})
    public void testcase2_secondbox(String sname,String smessage) throws InterruptedException, IOException, AWTException {
        Thread.sleep(2000);
        objfillform.fillsecondbox(sname,smessage);
        objfillform.screenshot();
    }

    @Test  ( threadPoolSize = 0,priority= 1, invocationCount = 1)
    public void testcase3_asserttext() throws InterruptedException, IOException, AWTException {
        //assert the text "Form Filled out successfully" & Success after submitting both message box
        Thread.sleep(2000);
        objfillform.screenshot();
        objfillform.assertetxt();
    }

    @Test  ( threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"newname","newname1", "lastname"})
    public void testcase4_sprint1(String newname, String newname1, String lastname) {
        //go through each sprint iteration and fill forms
        objfillform.webnavigatenew();
        objevoform =  new evolvesovertime (driver);
        objevoform.clickingstuff(newname);
        objevoform =  new evolvesovertime (driver);
        objevoform.newpage(newname1,lastname);
    }
    @AfterTest
    public void teardown() {

        driver.quit();
    }



}

