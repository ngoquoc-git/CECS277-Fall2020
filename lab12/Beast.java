public class Beast extends Monster{
    
    private int damage;

    public Beast(){
        super("Beast Master ", 10);
        damage = 3;
    }

    @Override
    public int attack(){
        return damage;
    }
}

