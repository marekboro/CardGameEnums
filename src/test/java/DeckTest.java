import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Card card1;
    Card card2;

    @Before
    public void before(){
        deck = new Deck();
        card1 = new Card(Face.ACE,Suit.CLUBS);
        card2 = new Card(Face.KING,Suit.HEARTS);

    }
    @Test
    public void deckIsEmptyOnInitialisation(){
        assertEquals(0,deck.getCards().size());
    }


    @Test
    public void deckHas52CardsOnceInitialised(){
        deck.createDeck();
        assertEquals(52,deck.getCards().size());
    }
    @Test
    public void canRemoveCardFromTopOfDeck(){
        deck.addCard(card1);
        deck.addCard(card2);
        assertEquals(2,deck.getCards().size());
        Card card3 = deck.getCardFromDeck();
        assertEquals(card1,card3);
        assertEquals(1,deck.getCards().size());

    }
    @Test
    public void canRandomiseDeck(){
        deck.createDeck();
        assertEquals("142345678910", deck.stringOfIntsfromfirst10Cards());
        Card freshCard1 = deck.getCards().get(0);
        Card freshCard2 = deck.getCards().get(1);
        assertEquals(freshCard1,deck.getCards().get(0));
        assertEquals(freshCard2,deck.getCards().get(1));
        deck.shuffleDeck();
        assertEquals(52,deck.getCards().size());
        assertNotEquals("142345678910", deck.stringOfIntsfromfirst10Cards());
    }



}
