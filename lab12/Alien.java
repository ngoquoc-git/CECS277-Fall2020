public class Alien extends Monster{
    
    private int damage;

    public Alien(){
        super("Alien", 4);
        damage = 2;
    }

    @Override
    public int attack(){
        return damage;
    }
}
