
/**
 *
 * The ant class represents an ant that can be placed on board
 * It extends Creature class
 */
public class Ant extends Creature {



    public Ant(char representation) {
        super(representation);


    }

    @Override
    public String Move() {
        return "a";
    }

    @Override
    public boolean Breed() {
        if (this.getSurvivedForTurns() % 3 == 0 && this.getSurvivedForTurns() != 0) {
            return true;
        }
        return false;
    }

}
