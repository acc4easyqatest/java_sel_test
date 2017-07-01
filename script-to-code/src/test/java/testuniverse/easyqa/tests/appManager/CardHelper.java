package testuniverse.easyqa.tests.appManager;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import testuniverse.easyqa.tests.objectModels.CardData;

public class CardHelper {
    private PageHelper pageHelper;
    private RemoteWebDriver rd;

    public CardHelper(RemoteWebDriver rd) {
        this.rd = rd;
        pageHelper = new PageHelper(rd);
    }

    public void createCardOnTracker(CardData cardData) {
        //создаем карточку
        initCardCreation();
        //название карточки
        pageHelper.typeTextIntoElement("issue_summary", cardData.getCardName());
        //описание карточки
        pageHelper.typeTextIntoElement("issue_description", cardData.getCardDescription());

        //выбираем тип и приоритет
        pageHelper.clickAtSelectItem("issue_priority", "Высокий");
        pageHelper.clickAtSelectItem("type-view", "Задание");

        //сохраняем
        rd.findElement(By.name("commit")).click();
    }

    public void initCardCreation() {
        //создаем карточку
        pageHelper.clickOnLink("Создать карточку");
    }
}
