import java.util.Random;

class Main{
    /**
     * The whole program will be executed here
     * @param args nothing is passed in args
     */
    public static void main(String[] args){
        int decision;
        int level = 0;
        int[] levels = { 1, 2, 3 };
        Map map = new Map();
        String heroName;
        
        System.out.print("What is your name traveler? ");
        heroName = CheckInput.getString();
        map.loadMap(levels[level % levels.length]);
        Hero myHero = new Hero(heroName, map);

        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);

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
                default: break;
            }

            if (map.getCharAtLoc(myHero.getLocation()) == 's') System.out.println("You are back at the start.");
            else if (map.getCharAtLoc(myHero.getLocation()) == 'i') itemRoom(myHero, map, ig);
            else if (monsterRoom(myHero, map, eg, levels[level % levels.length])){
                Enemy e = eg.generateEnemy(0);
                System.out.println("You've encountered a " + e.getName());
                while(fight(myHero, e));
                if (e.getHP() == 0) map.removeCharAtLoc(myHero.getLocation());
            }
            else if(map.getCharAtLoc(myHero.getLocation()) == 'n') System.out.println("There was nothing here.");
            
            else if (map.getCharAtLoc(myHero.getLocation()) == 'f') {
                System.out.println("Next level:\n");
                level++;
                map.loadMap(levels[level % levels.length]);
                myHero.heal(myHero.getMaxHP());
            }
        } while(myHero.getHP() != 0);
        
        if (myHero.getHP() < 1){
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
        //Fight
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