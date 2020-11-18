public class Ice extends MonsterDecorator{

    public Ice(Monster mon) {
        super(mon, "Ice "+ mon.getName(), 2 + mon.getHP());
    }

    @Override
    public int attack() {
        return 1 + super.attack();
    }
}
