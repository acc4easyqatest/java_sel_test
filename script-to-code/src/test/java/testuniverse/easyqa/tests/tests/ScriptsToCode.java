package testuniverse.easyqa.tests.tests;

import org.testng.annotations.Test;
import testuniverse.easyqa.tests.objectModels.CardData;


public class ScriptsToCode extends TestBase {

    @Test
    public void testCardCreation() {

        app.gotoProjectsList();
        app.selectProject();
        app.gotoBugTracker();
        //а тут не просто параметр, а сразу инициализация объекта класса карточка с данными
        app.createCardOnTracker(new CardData("карточка 3", "описание карточки 3"));

    }

}
