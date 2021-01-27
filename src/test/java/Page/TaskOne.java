package Page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskOne extends BasePage {
    public TaskOne(WebDriver driver) {
        super(driver);
    }

    @Test
    public void checkPageIsCorrect() {
        isElementDisplayed(By.xpath("//li[text()='Zadanie 1']"));
    }
}
