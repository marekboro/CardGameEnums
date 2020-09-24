public class Game {
    private Dealer dealer;
    private Player player1;
    private Player player2;
    private int gameState;
    private int gameRound;
    private int maxRounds;
    private String winner;

    public Game(Dealer dealer, Player player1, Player player2, int gameState, int gameRound) {
        this.dealer = dealer;
        this.player1 = player1;
        this.player2 = player2;
        this.gameState = gameState;
        this.gameRound = gameRound;
        this.maxRounds = 6;
        this.winner = "";
    }

    public void setupGame(){
        player1.setName("John Rambo");
        player2.setName("John Matrix");
        dealer.setName("John McClain");
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();
    }



    public void runRound(){
        dealer.issueCard(player1);
        dealer.issueCard(player2);

        if(player1.getCard().getFace().getValue() > player2.getCard().getFace().getValue()) {
            int oldScore = player1.getScore();
            player1.setScore(oldScore +1);
        }
        if(player2.getCard().getFace().getValue() > player1.getCard().getFace().getValue()) {
            int oldScore = player2.getScore();
            player2.setScore(oldScore +1);
        }
        gameRound +=1;
    }

    public void runGame(){
        while (gameRound < maxRounds){
            runRound();
        }
        if(player1.getScore() > player2.getScore()){
            winner = player1.getName();
        }
        if(player2.getScore() > player1.getScore()){
            winner = player2.getName();
        }

    }



}
