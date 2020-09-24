import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Dealer dealer;

    @Before
    public void before(){
        player1 = new Player("John Rambo");
        player2 = new Player("John Matrix");
        dealer = new Dealer("John Wick");
        game = new Game();
        game.setDealer(dealer);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
    }
//    @Test
//    public void gameSetupWillAddAShuffledDeck(){
//
//    }

    @Test
    public void gameHasDealerAndPlayers(){
        Player p1 = game.getPlayer1();
        Player p2 = game.getPlayer2();
        Dealer d1 = game.getDealer();
        assertEquals("John Rambo",p1.getName());
        assertEquals("John Matrix",p2.getName());
        assertEquals("John Wick",d1.getName());
    }
    @Test
    public void gameHasARandomDeckAtStart(){
        game.setupGame();
        assertNotEquals("142345678910",game.getDealer().getDeck().stringOfIntsfromfirst10Cards());
    }

    @Test
    public void gameCanProgressThroughRound(){
        game.setupGame();
        game.runRound();
        assertEquals(2,game.getGameRound());
        assertEquals("",game.getWinner());
    }
    @Test
    public void gameCanEnd(){
        game.setupGame();
        game.runGame();
        assertEquals(6,game.getGameRound());
        assertNotEquals("",game.getWinner());

    }
}
