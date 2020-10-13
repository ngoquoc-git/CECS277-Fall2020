public abstract class Entity {
    /**Entity's name*/
    private String name;
    /**Entity's max health points */
    private int maxHP;
    /**Entity's health points */
    private int hp;

    /**
     * Overload Constructor Entity
     * Create an entity with give name and maxhealth point
     * @param n Entity's  name
     * @param mHP Entity's max health point
     */
    public Entity(String n, int mHP){
        this.name = n;
        this.maxHP = mHP;
        this.hp = mHP; 
    }
    /**
    * method that allow one entity attack another
    * @param e the entity that will be trigger attack to this entity
    * @return other entity's name
    */
    public abstract String attack(Entity e);

    /**
     * retrive enity's name
     * @return enity's name
     */
    public String getName(){
        return name;
    }

    /**
     * retrive entity's health points
     * @return hp health points
     */
    public int getHP(){
        return hp;
    }

    /**
     * retrive maximum health points
     * @return maxHP maximum health points
     */
    public int getMaxHP(){
        return maxHP;
    }

    /**
     * Add health points
     * @param h input health points
     */
    public void heal(int h){
        hp += h;
        if (hp > maxHP) hp = maxHP;

    }

    /**
     * Lose heath points after taking damage
     * @param h heath points that is deducted by damage
     */
    public void takeDamage(int h){
        hp -= h;
        if (hp < 1) hp = 0;
    }

    /**
     * @return Entity's name and current health points
     */
    public String toString(){
        return name + "\nHP: " + hp + "/" + maxHP;
    }
} 
