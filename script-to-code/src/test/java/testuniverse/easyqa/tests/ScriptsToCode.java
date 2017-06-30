package testuniverse.easyqa.tests;

import org.testng.annotations.Test;


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
