package testuniverse.easyqa.tests.appManager;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private  SessionHelper sessionHelper;
    private NavHelper navHelper;
    private CardHelper cardHelper;

    WebDriver rd;
    ChromeOptions co;
    FirefoxProfile fp;

    @Parameter
    public String browser;

    public ApplicationManager(String browser)  {

        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        // String browser = System.getProperty("browser", "browser");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


        if (browser.equals(BrowserType.FIREFOX)) {
            rd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)){
            co = new ChromeOptions();
            co.addArguments("--window-size=1800,1000");
            rd = new ChromeDriver(co);
        }
        else if (browser.equals(BrowserType.IE)){
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
//        rd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //rd.manage().window().maximize();
        rd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        rd.get(properties.getProperty("baseUrl"));
       // rd.get("https://app.geteasyqa.com/users/sign_in");
        navHelper = new NavHelper(rd);
        sessionHelper = new SessionHelper(rd);
        cardHelper = new CardHelper(rd);
        //вызываем логин с переданным паролем и логином
        sessionHelper.userLogin(properties.getProperty("login"), properties.getProperty("pass"));
//        rd.wait(10);
    }

    public void stop() {
        rd.quit();
    }

    public NavHelper getNavHelper() {
        return navHelper;
    }

    public CardHelper getCardHelper() {
        return cardHelper;
    }

    //метод для снятия скринов
    public byte[] takeScreen (){
        return ((TakesScreenshot) rd).getScreenshotAs(OutputType.BYTES);
    }
}
