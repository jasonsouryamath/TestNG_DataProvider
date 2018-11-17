
package AutomationTest;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

        import java.awt.*;
        import java.io.IOException;
        import java.util.HashMap;


public class testrun2 {
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

    @Test  ( threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"name","message"})
    public void testcase1_firstbox(String name, String message) throws InterruptedException, IOException, AWTException {
        Thread.sleep(2000);
        objfillform = new fillformpage(driver);
        objfillform.fillformo(name,message);
        objfillform.screenshot();

    }
    @Test (priority= 2, invocationCount = 1)
    public void testcase2_secondbox() throws InterruptedException {
        Thread.sleep(2000);
        objfillform.fillsecondbox("jason1","msg1");
    }

    @Test (priority = 3, invocationCount = 1)
    public void testcase3_asserttext() throws InterruptedException{
        //assert the text "Form Filled out successfully" & Success after submitting both message box
        Thread.sleep(2000);
        objfillform.assertetxt();
    }

    @Test (priority = 4, invocationCount= 1)
    public void testcase4_sprint1() {
        //go through each sprint iteration and fill forms
        objfillform.webnavigatenew();
        objevoform =  new evolvesovertime (driver);
        //objevoform.clickingstuff();

    }
    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
