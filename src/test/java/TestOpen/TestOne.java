package TestOpen;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestOne extends BaseTest {


    @Test
    public void sixTest() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        main.goTo();
        taskOne.fillInLogin("MRADKOVA")
                .fillInPassword("MRADKOVA")
                .loginButtonClick();
        try {
            wait.until(visibilityOfElementLocated(By.name("Судебный конвейер")));
        } catch (TimeoutException ignore) {
        }
        taskOne.clickButtonByName("Судебный конвейер");
        taskOne.scrollToElementByName("Порядковый номер подачи");
        taskOne.clickButtonByName("Порядковый номер подачи");
    }
}
