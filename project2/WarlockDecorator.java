public abstract class WarlockDecorator extends Enemy{
    
    private Enemy em;

    public WarlockDecorator(Enemy enemy, String n, int mHP, Item i) {
        super(n, mHP+1, i);
        em = enemy;
    }
    
}
