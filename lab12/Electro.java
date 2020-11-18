public class Electro extends MonsterDecorator{

    public Electro(Monster mon) {
        super(mon, "Electro "+ mon.getName(), 2 + mon.getHP());
    }

    @Override
    public int attack() {
        return 2 + super.attack();
    }
}
