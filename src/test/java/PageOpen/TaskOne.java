package PageOpen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;

public class TaskOne extends PageBase {
    public TaskOne(WebDriver driver) {
        super(driver);
    }
    public TaskOne(Action actions) {
        super((WebDriver) actions);
    }

    public TaskOne fillInLogin(String login){
        WebElement element = driver.findElement(By.name("SWEUserName"));
        element.sendKeys(login);
        return this;
    }

    public TaskOne fillInPassword(String password){
        driver.findElement(By.name("SWEPassword")).sendKeys(password);
        return this;
    }

    public void loginButtonClick(){
        driver.findElement(By.id("s_swepi_22")).click();
//        return this;
    }

    public TaskOne clickButtonById(String byId){
        driver.findElement(By.id(byId)).click();
        return this;
    }

    public TaskOne clickButtonByClass(String byClass){
        driver.findElement(By.tagName(byClass)).click();
        return this;
    }

    public TaskOne clickButtonByName(String byName){
        driver.findElement(By.linkText(byName)).click();
        return this;
    }

    public TaskOne scrollToElementByName(String byName){
        actions.moveToElement(driver.findElement(By.name(byName)));
        return this;
    }

    public TaskOne clickButtonByXPath(String byXPath){
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(byXPath))).click();
        return this;
    }

    public TaskOne clickButtonName(String byName){
        driver.findElement(By.name(byName)).click();
        return this;
    }

    public void isLoginCorrect(){
        driver.findElement(By.linkText("Pobierz plik")).isDisplayed();
    }

    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }
}
