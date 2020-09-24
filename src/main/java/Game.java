import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private Player player1;
    private Player player2;
    private int gameRound;
    private int maxRounds;
    private String winner;
    private Dealer chosenDealer;
    private final Dealer dealer1 = new Dealer("John Wick");
    private final Dealer dealer2 = new Dealer("Doc Holliday");
    private final Dealer dealer3 = new Dealer("Gambit");

    public Game() {

        this.gameRound = 1;
        this.maxRounds = 6;
        this.winner = "";
    }

    Scanner scanner = new Scanner(System.in);

    public void greeting() {
        System.out.println(" - Welcome to the WAR card game --");
        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
    }

    public void chooseDealer() {

        boolean dealerNotFound = true;
        while (dealerNotFound) {
            System.out.println("Available dealers: ");
            System.out.println("1. " + dealer1.getName());
            System.out.println("2. " + dealer2.getName());
            System.out.println("3. " + dealer3.getName());
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

    public void chooseRounds() {
        boolean roundsNotEstablished = true;

        while (roundsNotEstablished) {
            System.out.println("Enter how many rounds you would like to play [1-26]: ");
            String choice = scanner.next();
            int madeChoice = Integer.parseInt(choice);
            if (Integer.parseInt(choice) < 26 && Integer.parseInt(choice) > 0) {
                roundsNotEstablished = false;

            }
            setMaxRounds(madeChoice);

        }

    }

    public void getNames() {

        System.out.println("Enter name for Player 1: ");
        String input1 = scanner.next();
        player1 = new Player(input1);
        System.out.println("Enter name for Player 2: ");
        String input2 = scanner.next();
        player2 = new Player(input2);
    }

    public void setupGame() {
        Deck deck = new Deck();
        deck.createDeck();
        System.out.println(getDealer().getName() + " Opens a new deck of cards.");
        dealer.setDeck(deck);
        System.out.println(getDealer().getName() + " shuffles the cards.");
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


    public int getGameRound() {
        return gameRound;
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

    public void runRound() {
        player1.setCard(null);
        player2.setCard(null);
        dealer.issueCard(player1);
        dealer.issueCard(player2);

        if (player1.getCard().getFace().getValue() > player2.getCard().getFace().getValue()) {
            int oldScore = player1.getScore();
            System.out.print(getGameRound() + ": " + player1.getName() + " WON the round! - ");
            player1.setScore(oldScore + 1);
        }
        if (player2.getCard().getFace().getValue() > player1.getCard().getFace().getValue()) {
            int oldScore = player2.getScore();
            System.out.print(getGameRound() + ": " + player2.getName() + " WON the round! - ");
            player2.setScore(oldScore + 1);
        }
        if (player2.getCard().getFace().getValue() == player1.getCard().getFace().getValue()) {
            System.out.print(getGameRound() + ":   A DRAW!:   ");
        }
        summarise();
        gameRound += 1;

    }

    public void summarise() {

        System.out.println((player1.getName() + " had a " + player1.getCard().getFace() + " of " + player1.getCard().getSuit() + ", " + player2.getName() + " had a " + player2.getCard().getFace() + " of " + player2.getCard().getSuit()));
    }

    public void endGame() {
        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
        System.out.println(getDealer().getName() + " lit up a cuban and said:");
        System.out.println(winner);
        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
    }

    public void runGame() {
        while (gameRound <= maxRounds) {
            runRound();

        }
        if (player1.getScore() > player2.getScore()) {
//
            setWinner(player1.getName() + " WON! with " + player1.getScore() + " points");
        }
        if (player2.getScore() > player1.getScore()) {
//
            setWinner(player2.getName() + " WON! with " + player2.getScore() + " points");
        }
        if (player1.getScore() == player2.getScore()) {
            setWinner("It was a draw, both players managed to get " + player2.getScore() + " points");
        }

    }


}
