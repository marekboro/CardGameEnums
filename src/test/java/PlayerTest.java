import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Card card1;
    Player player;

    @Before
    public void before(){
        player = new Player("Doc Holliday");
        card1 = new Card(Face.ACE,Suit.CLUBS);
    }

    @Test
    public void hasName(){
        assertEquals("Doc Holliday", player.getName());

    }
    @Test
    public void hasScore0atStart(){
        assertEquals(0, player.getScore());

    }
    @Test
    public void hasNoCardAtStart(){
        assertEquals(null, player.getCard());

    }
    @Test
    public void canAddCardToPlayer(){
        player.setCard(card1);
        assertEquals(card1, player.getCard());

    }

    @Test
    public void canRemoveCardFromPlayer(){
        player.setCard(card1);
        assertEquals(card1, player.getCard());
        player.setCard(null);
        assertEquals(null, player.getCard());

    }

    @Test
    public void canChangePlayerScore(){
        player.setScore(1);
        assertEquals(1, player.getScore());

    }



}
