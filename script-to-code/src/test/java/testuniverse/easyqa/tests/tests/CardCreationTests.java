package testuniverse.easyqa.tests.tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import testuniverse.easyqa.tests.objectModels.CardData;


public class CardCreationTests extends TestBase {

    @Test
    public void testCardCreation() {

        app.getNavHelper().gotoProjectsList();
        app.getNavHelper().selectProject();
        app.getNavHelper().gotoBugTracker();
        //а тут не просто параметр, а сразу инициализация объекта класса карточка с данными
        app.getCardHelper().createCardOnTracker(new CardData("карточка 3", "описание карточки 3"));

    }

}
