package testuniverse.easyqa.tests.appManager;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * Created by Любовь on 01.07.2017.
 */
public class NavHelper extends BaseHelper {

    public NavHelper(WebDriver rd) {
        super(rd);
    }

    @Step
    public void gotoBugTracker() {
        //кликаем по баг-трекеру
        clickOnLink("Баг Трекер");
    }
    @Step
    public void gotoProjectsList() {
        //кликаем по списку проектов
        clickOnLink("Мои Проекты");
    }
    @Step
    public void selectProject() {
        //кликаем по проекту
        clickOnLink("test project 1");
    }
}
