/**
 * Class: CECS 277
 * Project : Project 1
 * Authors: Quoc Ngo, Alnahwi Abdullah
 */
import java.util.Random;
//Monstyer Dungeon game is executed
class Main{
    /**
     * The whole program will be executed here
     * @param args nothing is passed in args
     */
    public static void main(String[] args){
        // All variables are decalred here
        Map map = Map.getInstance();
        ItemGenerator ig = ItemGenerator.getInstance();
        EnemyGenerator eg = EnemyGenerator.getInstance();
        Enemy enemy;
        int decision;
        int level = 1;
        int[] mazeLevels = { 1, 2, 3 };
        String heroName;
        boolean endGame  = false;
        Hero myHero;

        //Get user's name and load map
        System.out.print("What is your name traveler? ");
        heroName = CheckInput.getString();
        map.loadMap(mazeLevels[level + 1]);
        myHero = new Hero(heroName, map);

        //Loop to break the game if plaer decide to quit, hero dies, or complete 3 levels
        do{
            System.out.println(myHero.toString());
            map.displayMap(myHero.getLocation());
            System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");
            decision = CheckInput.getIntRange(1, 5);
            switch (decision){
                case 1: myHero.goNorth(); break;
                case 2: myHero.goSouth(); break;
                case 3: myHero.goEast(); break;
                case 4: myHero.goWest(); break;
                case 5: endGame = true; break;
            }
            //End game immediately if user chooses quit
            if(endGame == false){
                //Choose actions base on location's character
                if (map.getCharAtLoc(myHero.getLocation()) == 's') {
                    System.out.println("You are back at the start.");
                    store(myHero);
                }
                else if (map.getCharAtLoc(myHero.getLocation()) == 'i') itemRoom(myHero, map, ig);
                else if (monsterRoom(myHero, map, eg, level)){
                    enemy = eg.generateEnemy(level);
                    System.out.println("You've encountered a " + enemy.getName());
                    while(fight(myHero, enemy));
                    if (enemy.getHP() == 0) map.removeCharAtLoc(myHero.getLocation());
                }
                else if (map.getCharAtLoc(myHero.getLocation()) == 'f') {
                    level++;
                    System.out.println("You have reached the finish point. Move on to the next level. \n");
                    map.loadMap(mazeLevels[level]);
                    myHero.heal(myHero.getMaxHP());
                    if(level < 4) System.out.println ("Level: " + level); 
                }
                else System.out.println("Go Ahead.");
            }
        } while(myHero.getHP() > 0 && level < 4 && endGame == false);
        
        //Print out result based on hero's health points
        if (myHero.getHP() < 1){
            System.out.println("Game Over. You died.\n");
        }

        if (level < 4) System.out.println("Game Over, Try again sometimes.\n");
        else System.out.println("Congratulation, you successfully seized the maze.\n");
    }

    /**
     * Method that let hero and enemy attack each other
     * @param h hero
     * @param e enemy
     * @return true if they attack, false if one dies or herob runs away
     */
    public static boolean fight(Hero h, Enemy e){
        int decision;
        int attack;
        
        //check if hero has potions to use
        if(h.hasPotion()){
            System.out.println("1. Fight.\n2. Run Away.\n3. Drink Health Potion.\n");
            decision = CheckInput.getIntRange(1, 3);
        }
        else{
            System.out.println("1. Fight.\n2. Run Away.\n");
            decision = CheckInput.getIntRange(1, 2);
        }

        //Fight
        if (decision == 1){
            System.out.println("1.Physical Attack\n2.Magical Attack");
            attack = CheckInput.getIntRange(1, 2);

            if (attack == 1){
                System.out.println(h.attack(e));
                if (e.getHP() > 0){
                    System.out.println(e.attack(h));
                }
            }

            else{
                System.out.println(Magical.MAGIC_MENU);
                int magicalAttack = CheckInput.getIntRange(1, 3);
                if(magicalAttack == 1){
                    System.out.println(h.magicalMissile(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
                    }
                }
                else if (magicalAttack == 2){
                    System.out.println(h.fireBall(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
                    }
                }
                else {
                    System.out.println(h.thunderClap(e));
                    if (e.getHP() > 0){
                        System.out.println(e.attack(h));
                    }
                }
            }
            //end fight if enemy is death and let hero pick up item if possible
            if (e.getHP() < 1) {
                System.out.println("You defeated the " + e.getName());
                h.pickUpItem(e.getItem());
                return false;
            }
            return true;
        }
        //Run Away
        else if(decision == 2){
            Random rand = new Random();
            int getAway = rand.nextInt(2);
            int run;
            //Run successfully
            if(getAway == 1){
                System.out.println(h.getName() + " successfully got away.");
                if(h.getLocation().x == 0 && h.getLocation().y == 0) h.goEast();
                else if(h.getLocation().x == 0 && h.getLocation().y == 4) h.goSouth();
                else if(h.getLocation().x == 4 && h.getLocation().y == 0) h.goNorth();
                else if(h.getLocation().x == 4 && h.getLocation().y == 4) h.goWest();
                else { 
                    run = rand.nextInt(3);
                    switch(run){
                        case 0: h.goSouth(); break;
                        case 1: h.goNorth(); break;
                        case 2: h.goEast(); break;
                        case 3: h.goWest(); break;
                    }   
                }
                return false;
            }
            //hero got hit if run failed
            else{
                System.out.println(e.getName() + " did not let you get away.");
                System.out.println(e.attack(h));
                System.out.println(h.toString());
                if(h.getHP() > 0) return true;
                else return false;
            }
        }
        else {
            h.drinkPotion();
            return true;
        }   
    }

    /**
     * Check if current location is a spot that has monster
     * @param h hero is passed
     * @param m current map is passed
     * @param eg enemy generator
     * @param level enemy's level based on maze level
     * @return true if this location has a monster, false otherwise
     */
    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level){
        if (m.getCharAtLoc(h.getLocation()) == 'm') return true;
        return false;
    }

    /**
     * Remove item after player pick it up
     * @param h in-game hero 
     * @param m current map
     * @param ig item in the room                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
     */
    public static void itemRoom(Hero h, Map m, ItemGenerator ig){
        if(m.getCharAtLoc(h.getLocation()) == 'i') {
            h.pickUpItem(ig.generateItem());
            m.removeCharAtLoc(h.getLocation());
        }
    }

    public static void store(Hero h){
        
        int dec;

        System.out.println("Store only opens once every level, buy carefully.");
        System.out.println("You have: " + h.getGold());
        System.out.println("Store Capacity: " + h.getNumItems() + "/5.");
        System.out.println("1. Buy.\n2. Sell.\3.Quit.");
        dec = CheckInput.getIntRange(1, 3);
        do{
            if(dec == 1){
                System.out.println("You have: " + h.getGold());
                System.out.println("Store Capacity: " + h.getNumItems() + "/5.");
                System.out.println("1. Health Potion: 7 coins.\n2. Key: 5 coins.\n3.Quit.");
                int buy = CheckInput.getIntRange(1, 3);
                if (buy == 1){
                    if(h.getGold() < 7) System.out.println("You don't have enough coins");
                    else{
                        h.spendGold(7);
                        h.pickUpItem(ItemGenerator.getInstance().getPotion());
                    }
                }
                else if(buy == 2){
                    if(h.getGold() < 5) System.out.println("You don't have enough coins");
                    else{
                        h.spendGold(5);
                        h.pickUpItem(ItemGenerator.getInstance().getKey());
                    }
                }

            }
            else if(dec == 2){
                if(h.getNumItems() < 1) System.out.println("Bag is empty");
                else{
                    h.itemsToString();
                    System.out.println("Choose the item you weant to sell: ");
                    int sell = CheckInput.getIntRange(1, h.getNumItems());
                    h.collectGold(h.dropItem(sell - 1).getValue());
                }

            }
            else{
                if(!h.hasKey()){
                    System.out.println("You have to have a key to complete the mission");
                    dec = CheckInput.getIntRange(1, 3);
                }
            }
        }while(dec != 3);
    }
}