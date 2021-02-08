package PageOpen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewKSD extends PageBase {
    public NewKSD(WebDriver driver) {
        super(driver);
    }

    public NewKSD fillInLogin(String login) {
        WebElement element = driver.findElement(By.name("SWEUserName"));
        element.sendKeys(login);
        return this;
    }

    public NewKSD fillInPassword(String password) {
        driver.findElement(By.name("SWEPassword")).sendKeys(password);
        return this;
    }

    public void loginButtonClick() {
        driver.findElement(By.id("s_swepi_22")).click();
//        return this;
    }

    public NewKSD clickButtonByName(String byName) {
        driver.findElement(By.linkText(byName)).click();
        return this;
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    public NewKSD chooseContract(String byName) {
        driver.findElement(By.linkText(byName)).click();
        return this;
    }

    public NewKSD clickButtonById(String byId) {
        driver.findElement(By.id(byId)).click();
        return this;
    }

    public NewKSD findElementByName(String byName) {
        driver.findElement(By.name(byName)).isDisplayed();
        return this;
    }

    public NewKSD wrightText(String byId, String name) {
        driver.getWindowHandle();
        driver.findElement(By.name(byId)).click();
        driver.findElement(By.name(byId)).sendKeys(name);
        return this;
    }

    public List<String> readFilesFromFolder() {
        File dir = new File("C:\\Users\\ivank\\Downloads\\testAvto\\src\\main\\resources\\files"); //path указывает на директорию
        List<String> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                String name = file.toString();
                int beginIndex = name.lastIndexOf("\\") + 1;
                int lastIndex = name.lastIndexOf(".");
                String nameOfFile = name.substring(beginIndex, lastIndex);
                lst.add(nameOfFile);
            }
        }
        return lst;
    }

    public NewKSD addNewFile(String byId, String fileName) {
        driver.findElement(By.id(byId)).sendKeys(fileName);
        return this;
    }
}
