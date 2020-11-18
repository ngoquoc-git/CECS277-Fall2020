public class Fire extends MonsterDecorator{

    public Fire(Monster mon) {
        super(mon, "Fire "+ mon.getName(), 2 + mon.getHP());
    }

    @Override
    public int attack() {
        return 3 + super.attack();
    }
}
