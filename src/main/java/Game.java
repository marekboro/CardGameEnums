import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private Player player1;
    private Player player2;
    private String gameState;
    private int gameRound;
    private int maxRounds;
    private String winner;
    private Dealer chosenDealer;
    private Dealer dealer1 = new Dealer("John Wick");
    private Dealer dealer2= new Dealer("Doc Holliday");
    private Dealer dealer3= new Dealer("Gambit");

    public Game() {
        this.dealer = dealer;
        this.player1 = player1;
        this.player2 = player2;
        this.gameState = "";
        this.gameRound = 0;
        this.maxRounds = 6;
        this.winner = "";
    }

    Scanner scanner = new Scanner(System.in);

    public void greeting(){
        System.out.println(" - Welcome to the WAR card game --");
        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
    }

    public Dealer getChosenDealer() {
        return chosenDealer;
    }

    public void chooseDealer(){

        boolean dealerNotFound = true;
        while(dealerNotFound) {
            System.out.println("Available dealers: ");
            System.out.println("1. "+ dealer1.getName());
            System.out.println("2. "+ dealer2.getName());
            System.out.println("3. "+ dealer3.getName());
            System.out.println("Please select you dealer number: ");
            String input = scanner.next();
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1:
                    chosenDealer = dealer1;
                    dealerNotFound = false;
                    break;
                case 2:
                    chosenDealer = dealer2;
                    dealerNotFound = false;
                    break;
                case 3:
                    chosenDealer = dealer3;
                    dealerNotFound = false;
                    break;
            }
        }
        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
        this.dealer = chosenDealer;
    }

    public void askToProgress(){
        System.out.println("press any key to continue");
    }

    public void chooseRounds(){
        boolean roundsNotEstablished = true;

        while(roundsNotEstablished){
        System.out.println("Enter how many rounds you would like to play [1-26]: ");
        String choice = scanner.next();
        int madechoice = Integer.parseInt(choice);
       if (Integer.parseInt(choice) <26 && Integer.parseInt(choice)>0 ){
           roundsNotEstablished = false;

       }
       setMaxRounds(madechoice);

        }

    }
    public void getNames(){

        System.out.println("Enter name for Player 1: ");
        String input1 = scanner.next();
        player1 = new Player(input1);
        System.out.println("Enter name for Player 2: ");
        String input2 = scanner.next();
        player2 = new Player(input2);
    }

    public void setupGame(){
//        player1.setName("John Rambo");
//        player2.setName("John Matrix");
//        dealer.setName("John McClain");
        Deck deck = new Deck();
        deck.createDeck();
        dealer.setDeck(deck);
        dealer.shuffleDeck();
    }



    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public int getGameRound() {
        return gameRound;
    }

    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void runRound(){
        player1.setCard(null);
        player2.setCard(null);
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

    public void summarise(){

        System.out.println(player1.getName() + " played a " +player1.getCard().getFace() + " of " + player1.getCard().getSuit() +", "+player2.getName() + " played a " +player2.getCard().getFace() + " of " + player2.getCard().getSuit() );
    }

    public void endGame(){
        System.out.println(winner);
    }

    public void runGame(){
        while (gameRound <= maxRounds){
            runRound();
            summarise();
        }
        if(player1.getScore() > player2.getScore()){
//            winner = player1.getName();
            setWinner(player1.getName() + " WON! with " + player1.getScore()+ " points");
        }
        if(player2.getScore() > player1.getScore()){
//            winner = player2.getName();
            setWinner(player2.getName() + " WON! with " + player2.getScore()+ " points");
        }
        if(player1.getScore() == player2.getScore()){
            setWinner("It was a draw, both players managed to get "+ player2.getScore() +" points");
        }

    }



}
