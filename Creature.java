
/**
 *
 * The creature class is an abstract class representing a creature that
 * can be placed on the board
 */
public abstract class Creature {

    private char symbol;
    private int survivedForTurns;


    public Creature(char symbol) {
        this.symbol = symbol;
        
        this.survivedForTurns = 0;
    }

    public abstract String Move();

    public abstract boolean Breed();

    //Getters
    public char getSymbol() {
        return symbol;
    }

    void incrementSurvivedForTurns(){
        this.survivedForTurns++;
    }

    public int getSurvivedForTurns() {
        return survivedForTurns;
    }
    
    
    
    
    

}
