public class Player extends Person {

    private int score;
    private Card card;

    public Player(String name) {
        super(name);
        this.score = 0;
        this.card = null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
