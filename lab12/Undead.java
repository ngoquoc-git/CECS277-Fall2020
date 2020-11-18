public class Undead extends Monster{
    private int damage;

    public Undead(){
        super("Zombie ", 15);
        damage = 1;
    }

    @Override
    public int attack(){
        return damage;
    }
}
