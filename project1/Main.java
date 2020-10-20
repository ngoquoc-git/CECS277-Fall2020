import java.util.Random;

class Main{
    /**
     * The whole program will be executed here
     * @param args
     */
    public static void main(String[] args){
        System.out.print("What is your name traveler? ");
        String name = CheckInput.getString();
        int usrChoice = 0;//directional choice for the game
        int level = 0; //level++ to move on to next level
        int[] levels = { 1, 2, 3 }; //store level numbers in array

        //load in necessary components needed for the game
        Map map = new Map();
        map.loadMap(levels[level % levels.length]); // use modulus operator to get num from [0-2] for index of levels array
        Hero hero = new Hero(name, map);
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);

        //loop where the game takes place, prints out hero info and looks through map for 'm', 'i', or 'n'
        //to use appropriate methods for rooms
        do{
            System.out.println(hero.toString());
            map.displayMap(hero.getLocation());
            System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");

            usrChoice = CheckInput.getIntRange(1, 5);
            if (usrChoice == 1){
                hero.goNorth();
            }
            else if (usrChoice == 2){
                hero.goSouth();
            }
            else if (usrChoice == 3){
                hero.goEast();
            }
            else if (usrChoice == 4){
                hero.goWest();
            }
            else if (usrChoice == 5){
                break;
            }
            //returning to the start
            if (map.getCharAtLoc(hero.getLocation()) == 's'){
                System.out.println("You are back at the start.");
            }
            //Item room
            else if (map.getCharAtLoc(hero.getLocation()) == 'i'){
                itemRoom(hero, map, ig);
            }
            //Monster room
            else if (monsterRoom(hero, map, eg, levels[level % levels.length])){
                Enemy e = eg.generateEnemy(0);
                System.out.println("You've encountered a " + e.getName());

                while(fight(hero, e));
                if (e.getHP() == 0) {
                    map.removeCharAtLoc(hero.getLocation());
                }
            }
            //Empty room
            else if(map.getCharAtLoc(hero.getLocation()) == 'n'){
                System.out.println("There was nothing here.");
            }
            //Final spot of map, move onto next map
            else if (map.getCharAtLoc(hero.getLocation()) == 'f') {
                System.out.println("Next level:\n");
                level++;
                map.loadMap(levels[level % levels.length]);
                hero.heal(hero.getMaxHP());
            }
        }while(hero.getHP() != 0);
        //display messages for when game is over
        if (hero.getHP() <= 0){
            System.out.println("Game Over. You died");
        }
        else{
            System.out.println("Game Over.");
        }
    }

    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level){
        if (m.getCharAtLoc(h.getLocation()) == 'm'){
            return true;
        }
        return false;
    }
    public static boolean fight(Hero h, Enemy e){
        int decision;
        
        if (e instanceof Magical) e = (MagicalEnemy) e;
        System.out.println(e.toString());
        
        if(h.hasPotion()){
            System.out.println("1. Fight.\n2. Run Away.\n3. Drink Health Potion.\n");
            decision = CheckInput.getIntRange(1, 3);
        }
        else{
            System.out.println("1. Fight.\n2. Run Away.\n");
            decision = CheckInput.getIntRange(1, 2);
        }

        if (decision == 1){
            System.out.println("1.Physical Attack\n2.Magical Attack");
            int attack = CheckInput.getIntRange(1, 2);
            if (attack == 1){
                System.out.println(h.attack(e));
                if (e.getHP() > 0){
                    System.out.println(e.attack(h));
                }
            }
            else if (attack == 2){
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
            if (e.getHP() < 1) {
                System.out.println("You defeated the " + e.getName());
                h.pickUpItem(e.getItem());
                return false;
            }
            if (h.getHP() < 0){
                System.out.println(h.getName() + "died. Game Over.\n");
                return false;
            }
            return true;
        }
        //Run Away
        else if(decision == 2){
            Random rand = new Random();
            int getAway = rand.nextInt(2);
            if(getAway == 1){
                System.out.println(h.getName() + " successfully got away.");
                if(h.getLocation().x == 0 && h.getLocation().y == 0) h.goEast();
                else if(h.getLocation().x == 0 && h.getLocation().y == 4) h.goSouth();
                else if(h.getLocation().x == 4 && h.getLocation().y == 0) h.goNorth();
                else if(h.getLocation().x == 4 && h.getLocation().y == 4) h.goWest();
                else { 
                    int run = rand.nextInt(3);
                    switch(run){
                        case 0: h.goSouth(); break;
                        case 1: h.goNorth(); break;
                        case 2: h.goEast(); break;
                        case 3: h.goWest(); break;
                    }   
                }
                return false;
            }
            else{
                System.out.println(e.getName() + " did not let you get away.");
                return true;
            }
        }
        else {
            h.drinkPotion();
            return true;
        }   
    }

    /**
     * Remove item after player pick it up
     * @param h in-game hero 
     * @param m current map
     * @param ig item in the room                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
     */
    public static void itemRoom(Hero h, Map m, ItemGenerator ig){
        if(h.pickUpItem(ig.generateItem())) m.removeCharAtLoc(h.getLocation());
    }
}