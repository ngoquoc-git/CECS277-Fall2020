public class Ocelot extends Cat {
    
    /**
     * Create Ocelot the cat
     * @param n name of Ocelot
     */
    public Ocelot(String n){
        super(n);
    }

    /**
     * Allow player to feed Ocelot
     * @param p player's action
     * @return string display Ocelot's status and action
     */
    public String feed(Player p) {
        String status;
        if (getHunger() > 0 && getHunger() < 3){ 
            status = toString() + ", and starts chomping down the food right away.";
            incrementHunger(2);
            return status;
        }
        else if (getHunger() < 6){
            status = toString() + ", and enjoy the treat.";
            incrementHunger(2);
            return status;
        }
        else if(getHunger() < 10){ 
            status = toString() + ", but still eats the food.";
            incrementHunger(1);
            return status;
        }
        else {
            status = toString() + ", and bites and scratches you for insulting them with food. You take 2 damage.";
            p.takeDamage(1);
            return status; 
        }
    }

    /**
     * Allow player to play with Ocelot
     * @param p player's action
     * @return string display Ocelot's status and action
     */
    public String play(Player p) {
        String status;
        if (getHunger() > 0 && getHunger() < 4){
            status = toString() + ", and bite you as its food, you take 3 damage.";
            incrementHunger(-2);
            p.takeDamage(2);
            return status;
        }
        else if (getHunger() < 7){
            status = getName() + ", rolling on the carpet.";
            incrementHunger(-2);
            return status;
        }
        else if (getHunger() == 7){
            status = toString() + ", chilling in your arms, but it accidentially scratches you. You take 1 damage.";
            p.takeDamage(1);
            incrementHunger(-2);
            return status;
        }
        else {
            status = toString() + ", happily playing with you";
            incrementHunger(-2);
            return status;
        }
    }

    /**
     * Allow player to pet with Ocelot
     * @param p player's action
     * @return string display Ocelot's status and action
     */
    public String pet(Player p) {
        String status;
        if (getHunger() > 0 && getHunger() < 2){
            status = toString() + ", does not want to play, and bite you. You take 2 damage";
            p.takeDamage(2);
            incrementHunger(-1);
            return status;
        }
        else if (getHunger() < 6){
            status = toString() + ", and stay still for you to pet.";
            incrementHunger(-2);
            return status;
        }
        else if (getHunger() < 10){
            status = toString() + ", and waiting for you on the floor.";
            incrementHunger(-3);
            return status;
        }
        else {
            status = toString() + ", and peacefully sleep for an hour.";
            incrementHunger(-2);
            return status;
        }
    }
}
