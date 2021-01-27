package Test;

import org.junit.jupiter.api.Test;

public class TestSix extends TestBase {
    @Test
    public void sixTest() {
        main.goTo().chooseTask("6");
        taskSix.fillInLogin("tester");
        taskSix.fillInPassword("123-xyz");
        taskSix.loginButtonClick();
        taskSix.isLoginCorrect();
    }
}
