import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DealerTest {

    Dealer dealer;
    Deck deck1;
    Player player1;

    @Before
    public void before(){
        dealer = new Dealer("The Machine");
        deck1 = new Deck();
        deck1.createDeck();
        player1 = new Player("Teseter");


    }

    @Test
    public void dealerHasName(){
        assertEquals("The Machine",dealer.getName());
    }

    @Test
    public void dealerHasDeckEmptyOnStartup(){
        assertEquals(0,dealer.getDeck().getCards().size());
    }

    @Test
    public void dealerHasFullDeckOnceDeckCreated(){
        dealer.getNewDeck();
        assertEquals(52,dealer.getDeck().getCards().size());
    }
    @Test
    public void dealerCanIssueCard(){
        assertEquals(0,dealer.getDeck().getCards().size());
        dealer.getNewDeck();
        assertEquals(52,dealer.getDeck().getCards().size());
        Card cardOriginal = dealer.getDeck().getCards().get(0);
        dealer.issueCard(player1);
        Card card = player1.getCard();
        assertEquals(cardOriginal,card);
        assertEquals(51,dealer.getDeck().getCards().size());
    }

    @Test
    public void dealerCanShuffleCards(){
        dealer.getNewDeck();
        String code1 = dealer.getDeck().stringOfIntsfromfirst10Cards();
        dealer.getDeck().shuffleDeck();
        String code2 = dealer.getDeck().stringOfIntsfromfirst10Cards();
        assertNotEquals(code1,code2);

    }


}
