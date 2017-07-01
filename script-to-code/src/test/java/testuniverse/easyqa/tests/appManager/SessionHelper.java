package testuniverse.easyqa.tests.appManager;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SessionHelper {

    private PageHelper pageHelper;
    private RemoteWebDriver rd;

    public SessionHelper(RemoteWebDriver rd) {
        this.rd = rd;
        pageHelper = new PageHelper(rd);
    }

    public void userLogin(String userLogin, String userPassword) {

        rd.get("https://app.geteasyqa.com/users/sign_in");

        //вводим емейл
        pageHelper.typeTextIntoElement("user_email", userLogin);

        //вводим пароль
        pageHelper.typeTextIntoElement("user_password", userPassword);

        //нажимаем на кнопку войти
        rd.findElement(By.name("commit")).click();
    }
}
