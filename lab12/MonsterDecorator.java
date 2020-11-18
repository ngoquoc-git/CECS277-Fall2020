public abstract class MonsterDecorator extends Monster{

    private Monster mon;
    
    public MonsterDecorator(Monster monster, String n, int h) {
        super(n, h);
        mon = monster;
    }
    
    @Override
    public int attack() {
        return mon.attack();
    }
}
