import java.util.ArrayList;

public class Dealer extends Person{
    private Deck deck;

    public Dealer(String name) {

        super(name);
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public void getNewDeck(){
        deck.createDeck();
    }
    
    public void shuffleDeck(){
        this.deck.shuffleDeck();
    }

    public void issueCard(Player player){
        player.setCard(deck.getCardFromDeck());
    }

}

