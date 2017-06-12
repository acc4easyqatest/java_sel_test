package testuniverse.easyqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ScriptsToCode {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
        wd.findElement(By.linkText("Создать карточку")).click();
        //название карточки
        wd.findElement(By.id("issue_summary")).click();
        wd.findElement(By.id("issue_summary")).sendKeys(cardData.getCardName());
        //описание карточки
        wd.findElement(By.id("issue_description")).click();
        wd.findElement(By.id("issue_description")).sendKeys(cardData.getCardDescription());
        //выбираем тип и приоритет
        /*
        *пока спрячем, потому что добраться тяжело
        wd.findElement(By.linkText("Ошибка")).click();
        wd.findElement(By.xpath("//div[@id='mCSB_11_container']//label[.='Ошибка']")).click();
        wd.findElement(By.linkText("Средний")).click();
        wd.findElement(By.linkText("Критический")).click();
        */
        //сохраняем
        wd.findElement(By.name("commit")).click();
    }

    public void gotoBugTracker() {
        //кликаем по баг-трекеру
        wd.findElement(By.linkText("Баг Трекер")).click();
    }

    public void selectProject() {
        //кликаем по проекту
        wd.findElement(By.linkText("test project 1")).click();
    }

    public void gotoProjectsList() {
        //кликаем по списку проектов
        wd.findElement(By.linkText("Мои Проекты")).click();
    }

    public void userLogin(String userLogin, String userPassword) {

        wd.get("https://app.geteasyqa.com/users/sign_in");
        //вводим емейл
        wd.findElement(By.id("user_email")).click();
        wd.findElement(By.id("user_email")).sendKeys(userLogin);

        //вводим пароль
        wd.findElement(By.id("user_password")).click();
        wd.findElement(By.id("user_password")).sendKeys(userPassword);

        //нажимаем на кнопку войти
        wd.findElement(By.name("commit")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
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
