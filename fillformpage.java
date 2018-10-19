package AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.regex.Pattern;

public class fillformpage {
    WebDriver driver;
    WebDriverWait wait;
    public String myassert = "Form filled out successfully";

    By nameinput = By.xpath("//input[@id='et_pb_contact_name_1']");
    By MsgInput = By.xpath("//textarea[@id='et_pb_contact_message_1']");
    By submit = By.xpath("//div[@class='et_contact_bottom_container']//button[@class='et_pb_contact_submit et_pb_button']");
    By numpar = By.xpath("//span[@class='et_pb_contact_captcha_question']");
    By captcha = By.xpath("//input[@class='input et_pb_contact_captcha']");
    By text1 = By.xpath("//div[@class='et-pb-contact-message']//p");
    //By text = By.xpath("//")

    public fillformpage(WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver,10);

    }

    //Set user name in textbox
    public void setusername(String strNameInput) {

        WebElement usrnme = wait.until(ExpectedConditions.elementToBeClickable(nameinput));
        usrnme.sendKeys(strNameInput);
    }
    //Set password in password textbox

    public void setMsgInput(String strThisis) {

        WebElement msgput = wait.until(ExpectedConditions.elementToBeClickable(MsgInput));
        msgput.sendKeys(strThisis);
    }
    //Click on submit button
    public void clicksubmit() {
        WebElement submt = wait.until(ExpectedConditions.elementToBeClickable(submit));
        submt.click();
    }

    public void secondbox(String strname1, String strmsg1) {
        WebElement name1 = wait.until(ExpectedConditions.elementToBeClickable(nameinput));
        name1.sendKeys(strname1);

        WebElement msg1 = wait.until(ExpectedConditions.elementToBeClickable(MsgInput));
        msg1.sendKeys(strmsg1);

        WebElement getthis = driver.findElement(numpar);
        String thisid = getthis.getText();
        //var + var (STRING)
        System.out.println(thisid);

        String stringsplt = thisid.trim().replaceAll("\\s+","");
        System.out.println(stringsplt);

        String[] parts = stringsplt.split(Pattern.quote("+"));
        String a = parts[0];
        String b = parts[1];
        System.out.println(a + b);

        int results = Integer.parseInt(a)+Integer.parseInt(b);
        System.out.println(results);
        String strcapo = Integer.toString(results);

        WebElement capc = wait.until(ExpectedConditions.elementToBeClickable(captcha));
        capc.sendKeys(strcapo);

        WebElement submt1 = wait.until(ExpectedConditions.elementToBeClickable(submit));
        submt1.click();
    }
    public void asserttext(){
       WebElement assertthis = driver.findElement(text1);
       String wordup = assertthis.getText();

        Assert.assertEquals(myassert,wordup);
        System.out.println(myassert);
    }


    public void fillformo(String strNameInput ,String strThisis)  {

        //Fill user name
        this.setusername(strNameInput);
        //Fill password
        this.setMsgInput(strThisis);
        //Click Login button
        this.clicksubmit();
    }
    public void fillsecondbox(String strname1, String strmsg1){
        this.secondbox(strname1, strmsg1);
    }
    public void assertetxt(){
        this.asserttext();
}
}
