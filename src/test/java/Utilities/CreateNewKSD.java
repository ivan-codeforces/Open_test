package Utilities;

import TestOpen.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
            new WebDriverWait(driver, 10).until(visibilityOfElementLocated(By.name("Договоры")));
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
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

        for (String nameOfFile :
                newKSD.readFilesFromFolder()) {
            System.out.println(nameOfFile);
            newKSD.addNewFile("s_11_1_8_0s_SweFileName", "C:\\Users\\ivank\\Downloads\\testAvto\\src\\main\\resources\\files\\" + nameOfFile + ".txt");
            newKSD.clickButtonById("1_s_11_l_Doc_Type");
            newKSD.wrightText("1_Doc_Type", nameOfFile);
//            newKSD.clickButtonById("1_s_11_l_Doc_Type");
//            newKSD.clickButtonById("s_11_2_35_0_icon");
//            newKSD.clickButtonById("ui-id-700");

            int i = 1;
            Select selectTypeOfContract = new Select(driver.findElement(By.id("ui-id-604")));
            selectTypeOfContract.selectByVisibleText("Выписка");
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
