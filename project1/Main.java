import java.util.Random;

class Main{
    /**
     * The whole program will be executed here
     * @param args nothing is passed in args
     */
    public static void main(String[] args){
        Map map = new Map();
        Random rand = new Random();
        ItemGenerator ig = new ItemGenerator();
        EnemyGenerator eg = new EnemyGenerator(ig);
        Enemy enemy;
        int decision;
        int level = 1;
        int[] mazeLevels = { 1, 2, 3 };
        String heroName;
        int mapSelection;
        
        System.out.print("What is your name traveler? ");
        heroName = CheckInput.getString();
        mapSelection= rand.nextInt(mazeLevels.length) + 1;
        map.loadMap(mazeLevels[mapSelection]);
        Hero myHero = new Hero(heroName, map);

        

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
                case 5: break;
            }

            if (map.getCharAtLoc(myHero.getLocation()) == 's') System.out.println("You are back at the start.");
            else if (map.getCharAtLoc(myHero.getLocation()) == 'i') itemRoom(myHero, map, ig);
            else if (map.getCharAtLoc(myHero.getLocation()) == 'm'){
                enemy = eg.generateEnemy(level);
                System.out.println("You've encountered a " + enemy.getName());
                while(fight(myHero, enemy));
                if (enemy.getHP() == 0) map.removeCharAtLoc(myHero.getLocation());
            }
            else if (map.getCharAtLoc(myHero.getLocation()) == 'f') {
                level++;
                System.out.println("You have reached the finish point. Move on to the next level. \n");
                mapSelection = rand.nextInt(3) + 1;
                map.loadMap(mapSelection);
                myHero.heal(myHero.getMaxHP());
                System.out.println ("Level: " + level);
            }
            else System.out.println("Go Ahead.");
        } while(myHero.getHP() != 0 || level < 4 || decision == 5);
        
        if (myHero.getHP() < 1){
            System.out.println("Game Over. You died");
        }
        else{
            System.out.println("Congratulation, you successfully seized the maze.\n");
        }
    }

    public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level){
        if (m.getCharAtLoc(h.getLocation()) == 'm') return true;
        return false;
    }

    public static boolean fight(Hero h, Enemy e){
        int decision;
        int attack;
        
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
            else{
                System.out.println(e.getName() + " did not let you get away.");
                e.attack(h);
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