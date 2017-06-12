package testuniverse.easyqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ScriptsToCode {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ScriptsToCode() {
        wd.get("https://app.geteasyqa.com/users/sign_in");
        //вводим емейл
        wd.findElement(By.id("user_email")).click();
        wd.findElement(By.id("user_email")).sendKeys("acc4easyqatest@gmail.com");

        //вводим пароль
        wd.findElement(By.id("user_password")).click();
        wd.findElement(By.id("user_password")).sendKeys("acc4easyqatestQwe");

        //нажимаем на кнопку войти
        wd.findElement(By.name("commit")).click();

        //кликаем по списку проектов
        wd.findElement(By.linkText("Мои Проекты")).click();

        //кликаем по проекту
        wd.findElement(By.linkText("test project 1")).click();

        //кликаем по баг-трекеру
        wd.findElement(By.linkText("Баг Трекер")).click();

        //создаем карточку
        wd.findElement(By.linkText("Создать карточку")).click();
        //название карточки
        wd.findElement(By.id("issue_summary")).click();
        wd.findElement(By.id("issue_summary")).sendKeys("карточка 3");
        //описание карточки
        wd.findElement(By.id("issue_description")).click();
        wd.findElement(By.id("issue_description")).sendKeys("описание карточки 3");
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
