package testuniverse.easyqa.tests.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import testuniverse.easyqa.tests.objectModels.CardData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private  SessionHelper sessionHelper;
    private NavHelper navHelper;
    private PageHelper pageHelper;
    private CardHelper cardHelper;
    //private RemoteWebDriver rd;

    WebDriver rd;
    ChromeOptions co;
    FirefoxProfile fp;


    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() throws MalformedURLException {

        String browser = BrowserType.CHROME;
        if (browser == BrowserType.FIREFOX) {
            rd = new FirefoxDriver();
        }
        else if (browser == BrowserType.CHROME){
            co = new ChromeOptions();
            co.addArguments("--window-size=1800,1000");
            rd = new ChromeDriver(co);
        }
        else if (browser == BrowserType.IE){
            rd = new InternetExplorerDriver();
        }

        /*
        URL server = new URL("http://192.168.88.247:4444/wd/hub");
        URL cloudServer = new URL("http://acc4universetest:a5fea81d-875f-462b-b02c-a95681f41637@ondemand.saucelabs.com:80/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("48");

        rd = new RemoteWebDriver(server,capabilities);
        */
        rd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //rd.manage().window().maximize();
        navHelper = new NavHelper(rd);
        sessionHelper = new SessionHelper(rd);
        pageHelper = new PageHelper(rd);
        cardHelper = new CardHelper(rd);
        //вызываем логин с переданным паролем и логином
        sessionHelper.userLogin("acc4easyqatest@gmail.com", "acc4easyqatestQwe");
    }

    public void selectProject() {
        //кликаем по проекту
        pageHelper.clickOnLink("test project 1");
    }

    public void stop() {
        rd.quit();
    }

    public PageHelper getPageHelper() {
        return pageHelper;
    }

    public NavHelper getNavHelper() {
        return navHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public CardHelper getCardHelper() {
        return cardHelper;
    }
}
