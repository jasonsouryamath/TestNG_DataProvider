package AutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class evolvesovertime {
    WebDriver driver;
    WebDriverWait wait;

    By evo = By.xpath("//a[contains(text(),'Learn how to automate an application that evolves over time')]");

    public evolvesovertime(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickevolves(){
        WebElement evolve = driver.findElement(evo);
        evolve.click();
    }

    public void clickingstuff (){
        this.clickevolves();
    }

}
