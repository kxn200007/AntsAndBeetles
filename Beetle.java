

/**
 * 
 * The beetle class represents a beetle on the board.
 * It extends the creature class
 */
public class Beetle extends Creature{

    private int antsEaten;
    private int turnsSinceAnt;
    

    
    public Beetle(char representation) {
        super(representation);
        
        //Initially the beetle has eaten zero ants and survived for 0 turns
        antsEaten = 0;
        turnsSinceAnt = 0;

    }

    

    @Override
    public String Move() {
        return "B";
    }

    @Override
    public boolean Breed() {
        if (this.getSurvivedForTurns() % 8 == 0 && this.getSurvivedForTurns() != 0) {
            return true;
        }
        return false;
    }
    
    public boolean Starve(){
        
        
        //The beatle dies if the amount of ants its eaten is less than the required amount
        if(this.turnsSinceAnt >= 5){
            return true;
        }
        
        
        return false;
    }
    
    
    void incrementAntsEaten(){
        this.antsEaten++;
        this.turnsSinceAnt = 0;
    }
    
    void incrementTurnsSinceAnt(){
        this.turnsSinceAnt++;
    }
    

    
}
