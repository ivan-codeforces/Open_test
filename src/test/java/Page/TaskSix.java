package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskSix extends BasePage {
    public TaskSix(WebDriver driver) {
        super(driver);
    }

    public void fillInLogin(String login){
        WebElement element = driver.findElement(By.id("LoginForm__username"));
        element.sendKeys(login);
    }

    public void fillInPassword(String password){
        driver.findElement(By.name("LoginForm[_password]")).sendKeys(password);
    }

    public void loginButtonClick(){
        driver.findElement(By.cssSelector(".btn-default.btn")).click();
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
