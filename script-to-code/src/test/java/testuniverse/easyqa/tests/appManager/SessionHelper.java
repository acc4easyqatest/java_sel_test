package testuniverse.easyqa.tests.appManager;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver rd) {
        super(rd);
    }

    @Step
    public void userLogin(String userLogin, String userPassword) {

        //вводим емейл
        typeTextIntoElement("user_email", userLogin);

        //вводим пароль
        typeTextIntoElement("user_password", userPassword);

        //нажимаем на кнопку войти
        rd.findElement(By.name("commit")).click();
    }
}
