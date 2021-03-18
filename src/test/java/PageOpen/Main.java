package PageOpen;

import org.openqa.selenium.WebDriver;

public class Main extends PageBase {
        String SITE_URL = "http://bcvm636/fins_rus/start.swe?";
    public Main(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(SITE_URL);
    }

}
