import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Deck deck1;

    @Before
    public void before(){
        dealer = new Dealer("The Machine");
        deck1 = new Deck();
        deck1.createDeck();

    }

    @Test
    public void dealerHasName(){
        assertEquals("The Machine",dealer.getName());
    }


}
