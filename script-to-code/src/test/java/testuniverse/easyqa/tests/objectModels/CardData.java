package testuniverse.easyqa.tests.objectModels;

public class CardData {
    private final String cardName;
    private final String cardDescription;

    public CardData(String cardName, String cardDescription) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }
}
