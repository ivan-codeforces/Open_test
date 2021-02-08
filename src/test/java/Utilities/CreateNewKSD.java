package Utilities;

import TestOpen.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CreateNewKSD extends BaseTest {

    @Test
    public void createKSD() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        main.goTo();
        newKSD.fillInLogin("MRADKOVA")
                .fillInPassword("MRADKOVA")
                .loginButtonClick();
        try {
            wait.until(visibilityOfElementLocated(By.name("Договоры")));
        } catch (TimeoutException ignore) {
        }
//    Перейти в договор
        newKSD.clickButtonByName("Договоры");
        String contract = "1-67-54";
        newKSD.chooseContract(contract);
//    Перейти во вкладку "Вложения"
        Select select = new Select(driver.findElement(By.id("j_s_vctrl_div_tabScreen")));
        select.selectByVisibleText("Вложения");
//    Выбрать файлы для загрузки и загрузить (кнопка "Новый файл")
//        newKSD.clickButtonById("1_s_11_l_Doc_Type");
//        Select selectTypeOfContract = new Select(driver.findElement(By.id("1_s_11_l_Doc_Type")));
//        selectTypeOfContract.selectByVisibleText("Выписка");
        for (String nameOfFile :
                newKSD.readFilesFromFolder()) {
            System.out.println(nameOfFile);
            newKSD.addNewFile("s_11_1_8_0s_SweFileName", "C:\\Users\\ivank\\Downloads\\testAvto\\src\\main\\resources\\files\\" + nameOfFile + ".txt");

            newKSD.wrightText("1_s_11_l_Doc_Type", nameOfFile);
//            Select selectTypeOfContract = new Select(driver.findElement(By.id("1_s_11_l_Doc_Type")));
//            selectTypeOfContract.selectByVisibleText(nameOfFile);
        }


    }


//
//    через админку переводим на этап досудебное пр-во, статус=рекомендован к передаче, вешаем на садмина, если не на нем
//
//    потом на мои договоры ищем этот договор и жмем передать
//
//    там выбираем суд конвейер
//
//    задача отсуживание
}
