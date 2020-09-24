import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    Card card;

    @Before
    public void before(){
        card = new Card(Face.JACK,Suit.CLUBS);
    }

    @Test
    public void hasFace(){
        assertEquals(Face.JACK, card.getFace());
    }
    @Test
    public void hasSuit(){
        assertEquals(Suit.CLUBS, card.getSuit());
    }
    @Test
    public void hasValue(){
        assertEquals(11, card.getValue());
    }

}
