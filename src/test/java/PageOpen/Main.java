package PageOpen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main extends PageBase {
        String SITE_URL = "http://bcvm636/fins_rus/start.swe?";
    public Main(WebDriver driver) {
        super(driver);
    }

    public PageOpen.Main goTo() {
        driver.get(SITE_URL);
        return this;
    }

    public void chooseTask(String taskNumber) {
        click(By.xpath("//h2[text()='Zadanie " + taskNumber + "']"));
//        return this;
    }
}
