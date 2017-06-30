package testuniverse.easyqa.tests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import testuniverse.easyqa.tests.objectModels.CardData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    // FirefoxDriver wd;
     ChromeDriver wd;ChromeOptions o;
    RemoteWebDriver rd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() throws MalformedURLException {
        URL server = new URL("http://192.168.88.247:4444/wd/hub");
        URL cloudServer = new URL("http://acc4universetest:a5fea81d-875f-462b-b02c-a95681f41637@ondemand.saucelabs.com:80/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("48");

        rd = new RemoteWebDriver(cloudServer,capabilities);

        rd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        rd.manage().window().maximize();
        //вызываем логин с переданным паролем и логином
        userLogin("acc4easyqatest@gmail.com", "acc4easyqatestQwe");
    }

    public void createCardOnTracker(CardData cardData) {
        //создаем карточку
        initCardCreation();
        //название карточки
        typeTextIntoElement("issue_summary", cardData.getCardName());
        //описание карточки
        typeTextIntoElement("issue_description", cardData.getCardDescription());

        //выбираем тип и приоритет
        clickAtSelectItem("issue_priority", "Высокий");
        clickAtSelectItem("type-view", "Задание");

        //сохраняем
        rd.findElement(By.name("commit")).click();
    }

    public void initCardCreation() {
        //создаем карточку
        clickOnLink("Создать карточку");
    }

    public void clickAtSelectItem(String selectId, String selectItem) {
        WebElement selectList = new RemoteWebElement();
        selectList = rd.findElement(By.id(selectId));
        selectList.click();
        selectList.findElement(By.linkText(selectItem)).click();
    }

    public void gotoBugTracker() {
        //кликаем по баг-трекеру
        clickOnLink("Баг Трекер");
    }

    public void selectProject() {
        //кликаем по проекту
        clickOnLink("test project 1");
    }

    public void clickOnLink(String linkText) {
        rd.findElement(By.linkText(linkText)).click();
    }

    public void gotoProjectsList() {
        //кликаем по списку проектов
        clickOnLink("Мои Проекты");
    }

    public void userLogin(String userLogin, String userPassword) {

        rd.get("https://app.geteasyqa.com/users/sign_in");

        //вводим емейл
        typeTextIntoElement("user_email", userLogin);

        //вводим пароль
        typeTextIntoElement("user_password", userPassword);

        //нажимаем на кнопку войти
        rd.findElement(By.name("commit")).click();
    }

    public void typeTextIntoElement(String inputElementId, String textToInput) {
        rd.findElement(By.id(inputElementId)).click();
        rd.findElement(By.id(inputElementId)).sendKeys(textToInput);
    }

    public void stop() {
        rd.quit();
    }
}
