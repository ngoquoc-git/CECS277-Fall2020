public class Undead extends Monster{
    private int damage;

    public Undead(){
        super("Zombie", 5);
        damage = 1;
    }

    @Override
    public int attack(){
        return damage;
    }
}
