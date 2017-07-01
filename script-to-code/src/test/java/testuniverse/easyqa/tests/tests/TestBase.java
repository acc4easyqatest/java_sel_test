package testuniverse.easyqa.tests.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testuniverse.easyqa.tests.appManager.ApplicationManager;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
