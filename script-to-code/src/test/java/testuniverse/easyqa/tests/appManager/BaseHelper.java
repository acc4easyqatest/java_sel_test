package testuniverse.easyqa.tests.appManager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseHelper {
    protected WebDriver rd;

    public BaseHelper(WebDriver rd) {
        this.rd = rd;
    }

    public void clickAtSelectItem(String selectId, String selectItem) {
        WebElement selectList = new RemoteWebElement();
        selectList = rd.findElement(By.id(selectId));
        selectList.click();
        selectList.findElement(By.linkText(selectItem)).click();
    }

    public void clickOnLink(String linkText) {
        rd.findElement(By.linkText(linkText)).click();
    }

    public void typeTextIntoElement(String inputElementId, String textToInput) {
        rd.findElement(By.id(inputElementId)).click();
        rd.findElement(By.id(inputElementId)).sendKeys(textToInput);
    }

    public boolean isAlertPresent() {
        try {
            rd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
