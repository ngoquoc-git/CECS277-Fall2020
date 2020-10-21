import java.util.ArrayList;
import java.util.Random;
public class Hero extends Entity implements Magical{
    /** Create an array list to store items*/
    private ArrayList<Item> items;

    private Map map;

    private Point location;

    /**
     * Overloaded Constructor
     * Create a new item and find start point for hero
     * @param n hero's name
     * @param m map that will be used to find start point
     */
    public Hero(String n, Map m){
        super(n, 25);
        items = new ArrayList<Item>();
        map = m;
        location = map.findStart();
    }

    /**
     * Skill fire ball
     * @param e the entity that will be attacked
     * @return fire ball attack status
     */
    @Override
    public String fireBall(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);
        return getName() + " throw a firebal at " + e.getName() + ", it deals " + damage + " damages.\n";
    }

    /**
     * Skill thunder clap
     * @param e the entity that will be attacked
     * @return thunder clap attack status
     */
    @Override
    public String thunderClap(Entity e){
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);
        return getName() + " does a thunder clap and shocks " + e.getName() + " for " + damage + " damages.\n";
    }

    /**
     * Skill magical missiles
     * @param e the entity that will be attacked
     * @return magical missiles attack status
     */
    @Override
    public String magicalMissile(Entity e) {
        Random rand = new Random();
        int damage = rand.nextInt(7) + 1;
        e.takeDamage(damage);
        return getName() + " shot magical missiles to " + e.getName() + ". It deals "+ damage +" damages";
    }

    /**
     * Method for physical damage
     * @param e the entity that is attacked
     * @return physical attack status
     */
    @Override
    public String attack(Entity e) {
        Random rand = new Random();
        int dealDamage = rand.nextInt(7);
        e.takeDamage(dealDamage);
        if (dealDamage == 0) return getName() + " tried to attack " + e.getName() + ", but it is missed";
        return getName() + " slashed " + e.getName() + " and deals " + dealDamage + " damages";
    }

    /**
     * Show Hero's status
     * @return hero's name and current health points
     */
    public String toString(){
        return getName() + "\nHP: " + getHP() + "/" + getMaxHP() + "\n";
    }

    /**
     * Get the total number of items that the hero is currently holding
     * @return number of item
     */
    public int getNumItems(){
        return items.size();
    }

    /**
     * Show hero's inventory
     * @return hero's inventory
     */
    public String itemsToString(){
        String inventory = "Inventory:";
        for (int i = 0; i < getNumItems();i++){
            inventory += "\n" + (i+1) + ". " + this.items.get(i).getName() ;
        }
        return inventory;
    }

    /**
     * Method that let hero pick up an item aftyer killing an enemy
     * @param i the item that will be picked
     * @return true if the item is picked, false if it is not
     */
    public boolean pickUpItem(Item i){
        int bagSize = 5;
        Boolean replaceItem;
        System.out.println("You received " + i.getName() + " from its corpse");
        if(items.size() < bagSize){
            items.add(i);
            return true;
        }
        else{
            System.out.print("Your bag is fulled, Do you want to erase an item to add this (y/n): ");
            replaceItem = CheckInput.getYesNo();
            if(replaceItem){
                itemsToString();
                System.out.print("What will you drop? ");
                int dropI = CheckInput.getIntRange(0, 4);
                dropItem(dropI);
                items.add(i);
                return true;

            }
            else return false;
        }
    }

    /**
     * Drop an item if the iventory is full
     * @param index the item that will be deleted
     */
    public void dropItem(int index){
        items.remove(index);
    }

    /**
     * Check if potion exists in the inventory
     * @return true if potion exists, false otherwise
     */
    public boolean hasPotion(){
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals("Health Potion")) return true;
        }
        return false;
    }

    /**
     * Use Potion to heal hero for 8 HP
     */
    public void drinkPotion(){
        heal(8);
        for (int i = 0; i < this.items.size();i++){
            if (items.get(i).getName().equals("Health Potion")) {
                items.remove(i);
            }
        }
        toString();
    }

    /**
     * Get hero's location
     * @return current location
     */
    public Point getLocation(){
        return location;
    }

    /**
     * Indicate hero to go north if it does not hit the boundary
     * reveal its previous footstep
     * @return hero's location
     */
    public char goNorth(){
        if (location.x == 0){
            return map.getCharAtLoc(location);
        }
        map.reveal(location);
        location.x--;
        return map.getCharAtLoc(location);
    }

    /**
     * Indicate hero to go south if it does not hit the boundary
     * reveal its previous footstep
     * @return hero's location
     */
    public char goSouth(){
        if (location.x == 4){
            return map.getCharAtLoc(location);
        }
        map.reveal(location);
        location.x++;
        return map.getCharAtLoc(location);
    }

    /**
     * Indicate hero to go east if it does not hit the boundary
     * reveal its previous footstep
     * @return hero's location
     */
    public char goEast(){
        if (location.y == 4){
            return map.getCharAtLoc(location);
        }
        map.reveal(location);
        location.y++;
        return map.getCharAtLoc(location);
    }

    /**
     * Indicate hero to go west if it does not hit the boundary
     * reveal its previous footstep
     * @return hero's location
     */
    public char goWest(){
        if (location.y == 0){
            return map.getCharAtLoc(location);
        }
        map.reveal(location);
        location.y--;
        return map.getCharAtLoc(location);
    }
}
