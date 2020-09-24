import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;


    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void createDeck() {
        for (Suit valueSuit : Suit.values()) {
            for (Face valueFace : Face.values()) {


                Card card = new Card(valueFace, valueSuit);
                this.cards.add(card);
            }
        }
    }

    public Card getCardFromDeck() {
        Card cardToReturn = cards.get(0);
        cards.remove(0);
        return cardToReturn;
    }

    public String stringOfIntsfromfirst10Cards() {
        String code = "";
        for (int i = 0; i < 10; i++) {
            code += cards.get(i).getFace().getValue();
        }
        return code;
    }

    public void shuffleDeck() {

//        Collections.shuffle(cards);

        ArrayList<Card> newDeck = new ArrayList<Card>();

        while (cards.size()>0){
            int max = cards.size();
            double randX = Math.random()*max;
            int randomIndex = (int)randX;
            newDeck.add(cards.get(randomIndex));
            cards.remove(randomIndex);
        }
        cards = newDeck;
//    }
}
}
