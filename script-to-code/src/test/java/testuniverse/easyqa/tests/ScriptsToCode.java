package testuniverse.easyqa.tests;

import org.testng.annotations.Test;


public class ScriptsToCode extends TestBase {

    @Test
    public void testCardCreation() {

        gotoProjectsList();
        selectProject();
        gotoBugTracker();
        //а тут не просто параметр, а сразу инициализация объекта класса карточка с данными
        createCardOnTracker(new CardData("карточка 3", "описание карточки 3"));

    }

}
