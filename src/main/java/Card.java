public class Card {
    
    private Face face;
    private Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }
    
    public int getValue(){
    return this.face.getValue();   
    }
    
    public Face getFace(){
        return this.face;
    }
    public Suit getSuit(){
        return this.suit;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
