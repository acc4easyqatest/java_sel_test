package testuniverse.easyqa.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.*;

public class ScriptsToCode {
   // FirefoxDriver wd;
    ChromeDriver wd;
    ChromeOptions o;
    RemoteWebDriver rd;
    
    @BeforeMethod
    public void setUp() throws Exception {

        URL server = new URL("http://192.168.88.247:4444/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");

        rd = new RemoteWebDriver(server,capabilities);

        rd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        rd.manage().window().maximize();
    }
    
    @Test
    public void ScriptsToCode() {
        //вызываем логин с переданным паролем и логином
        userLogin("acc4easyqatest@gmail.com", "acc4easyqatestQwe");
        gotoProjectsList();
        selectProject();
        gotoBugTracker();
        //а тут не просто параметр, а сразу инициализация объекта класса карточка с данными
        createCardOnTracker(new CardData("карточка 3", "описание карточки 3"));

    }

    public void createCardOnTracker(CardData cardData) {
        //создаем карточку
        clickOnLink("Создать карточку");
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

    @AfterMethod
    public void tearDown() {
        rd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
