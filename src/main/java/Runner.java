
import java.util.Scanner;

public class Runner {

//    Scanner scanner = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Dealer chosenDealer;
    private Dealer dealer1 = new Dealer("John Wick");
    private Dealer dealer2= new Dealer("Doc Holliday");
    private Dealer dealer3= new Dealer("Gambit");
    private int maxRounds;
    private int gamestate;
    private String[] dealers;

    public static void main(String[] args) {

        Game game = new Game();
        game.greeting();
        game.chooseDealer();
        game.getNames();
        game.chooseRounds();
        game.setupGame();
        game.runGame();
        game.endGame();


    }






//    public void greeting(){
//        System.out.println(" - Welcome to the WAR card game --");
//        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
//    }
//    public void chooseDealer(){
//
//        boolean dealerNotFound = true;
//        while(dealerNotFound) {
//            System.out.println("Available dealers: ");
//            System.out.println("1. "+ dealer1.getName());
//            System.out.println("2. "+ dealer2.getName());
//            System.out.println("3. "+ dealer3.getName());
//            System.out.println("Please select you dealer number: ");
//            String input = scanner.next();
//            int intInput = Integer.parseInt(input);
//            switch (intInput) {
//                case 1:
//                    chosenDealer = dealer1;
//                    dealerNotFound = false;
//                    break;
//                case 2:
//                    chosenDealer = dealer2;
//                    dealerNotFound = false;
//                    break;
//                case 3:
//                    chosenDealer = dealer3;
//                    dealerNotFound = false;
//                    break;
//            }
//        }
//        System.out.println(" --- -- --  -  -  -  - - -- -- --- ");
//    }
//    public void getNames(){
//
//        System.out.println("Enter name for Player 1: ");
//        String input1 = scanner.next();
//        player1 = new Player(input1);
//        System.out.println("Enter name for Player 1: ");
//        String input2 = scanner.next();
//        player2 = new Player(input2);
//    }
//    Game game = new Game()

}
