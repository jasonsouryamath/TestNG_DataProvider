package AutomationTest;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class evolvesovertime  {
    WebDriver driver;
    WebDriverWait wait;

    By evo = By.xpath("//a[contains(text(),'Learn how to automate an application that evolves over time')]");
    By firstname = By.xpath("//input[contains(@name,'firstname')]");
    By lastname =  By.xpath("//input[contains(@name,'lastname')]");
    By nxtsprt = By.xpath("//a[contains(text(),'Go to the next sprint')]");

    public evolvesovertime(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickevolves (String first) {
        WebElement evolve = driver.findElement(evo);
        evolve.click();
        WebElement fn = wait.until(ExpectedConditions.elementToBeClickable(firstname));
        fn.sendKeys(first);
        WebElement nextup = wait.until(ExpectedConditions.elementToBeClickable(nxtsprt));
        nextup.click();
    }

     public void nextmeth(String mid, String last)    {
         WebElement fn1 = wait.until(ExpectedConditions.elementToBeClickable(firstname));
        fn1.sendKeys(mid);
        WebElement ln = wait.until(ExpectedConditions.elementToBeClickable(lastname));
        ln.sendKeys(last);
    }

    public void clickingstuff (String first){
        this.clickevolves(first);
    }
    public void newpage(String mid, String last){
        this.nextmeth(mid,last);
    }
}
