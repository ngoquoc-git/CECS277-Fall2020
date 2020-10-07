public class Player {
    /**
     * Player's current health point 
     */
    private int hp;

    /**
     * Default Constructor Player
     * A player with 10HP
     */
    public Player(){
        hp = 10;
    }
    /**
     * get the value of player's hp from instance variable
     * @return current health points
     */
    public int getHp(){
        return hp;
    }

    /**
     * Cat attckes player and a new hp is updated
     * @param d represents the damage cat inflicts
     */
    public void takeDamage(int d){
        hp -= d;
    }
    /**
     * Check player's current hp to determine if he is alive
     * @return true if player hp > 0, false otherwise
     */
    public boolean isDead(){
        return hp < 1;
    }
    
    /**
     * Display player's hp in String
     * @return player's current hp in String
     */
    public String toString(){
        return "You have " + hp + "/10 HP";
    }
}
