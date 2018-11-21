package AutomationTest;

import org.testng.annotations.*;
import java.awt.*;
import java.io.IOException;

public class testrun extends testbase {

    @Test  (threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"name","message"})
    public void testcase1_firstbox(String firstname, String lastname) throws InterruptedException, IOException, AWTException {
        Thread.sleep(2000);
        objfillform = new fillformpage(driver);
        objfillform.fillformo(firstname,lastname);
        objfillform.screenshot();

    }
    @Test  (threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"sname","smessage"})
    public void testcase2_secondbox(String sname,String smessage) throws InterruptedException, IOException, AWTException {
        Thread.sleep(2000);
        objfillform.fillsecondbox(sname,smessage);
        objfillform.screenshot();
    }

    @Test  (enabled = true, threadPoolSize = 0,priority= 1, invocationCount = 1)
    public void testcase3_asserttext() throws InterruptedException, IOException, AWTException {
        //assert the text "Form Filled out successfully" & Success after submitting both message box
        Thread.sleep(2000);
        objfillform.screenshot();
        objfillform.assertetxt();
    }

    @Test  (enabled = true, threadPoolSize = 0,priority= 1, invocationCount = 1)
    @Parameters({"newname","newname1", "lastname"})
    public void testcase4_sprint1(String newname, String newname1, String lastname) throws IOException, AWTException {
        //go through each sprint iteration and fill forms
        objfillform.webnavigatenew();
        objevoform =  new evolvesovertime (driver);
        objevoform.clickingstuff(newname);
        objevoform =  new evolvesovertime (driver);
        objevoform.newpage(newname1,lastname);
        objfillform.screenshot();
    }
    }





