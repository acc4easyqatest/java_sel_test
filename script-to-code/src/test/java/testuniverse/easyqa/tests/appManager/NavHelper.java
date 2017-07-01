package testuniverse.easyqa.tests.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Любовь on 01.07.2017.
 */
public class NavHelper {
    private PageHelper pageHelper;
    private WebDriver rd;
    public NavHelper(WebDriver rd) {
        this.rd = rd;
        pageHelper = new PageHelper(rd);
    }

    public void gotoBugTracker() {
        //кликаем по баг-трекеру
        pageHelper.clickOnLink("Баг Трекер");
    }

    public void gotoProjectsList() {
        //кликаем по списку проектов
        pageHelper.clickOnLink("Мои Проекты");
    }
}
