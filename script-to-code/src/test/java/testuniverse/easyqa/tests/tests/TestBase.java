package testuniverse.easyqa.tests.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;
import testuniverse.easyqa.tests.appManager.ApplicationManager;

@Listeners(TestListener.class)

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));


    @BeforeSuite
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
