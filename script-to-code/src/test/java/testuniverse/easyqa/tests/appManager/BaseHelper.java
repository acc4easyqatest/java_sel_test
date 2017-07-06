package testuniverse.easyqa.tests.appManager;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseHelper {
    protected WebDriver rd;

    public BaseHelper(WebDriver rd) {
        this.rd = rd;
    }

    @Step
    public void clickAtSelectItem(String selectId, String selectItem) {
        WebElement selectList = new RemoteWebElement();
        selectList = rd.findElement(By.id(selectId));
        selectList.click();
        selectList.findElement(By.linkText(selectItem)).click();
    }

    @Step
    public void clickOnLink(String linkText) {
        Actions actions = new Actions(rd);
        WebElement el = rd.findElement(By.linkText(linkText));
        actions.moveToElement(el);
        el.click();
      //  rd.findElement(By.linkText(linkText)).click();
    }

    @Step
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
