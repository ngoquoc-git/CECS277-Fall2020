public abstract class Monster{
    private String name;
    private int hp;

    public Monster(String n, int h){
        name = n;
        hp = h;
    }

    public String getName(){
        return name;
    }
    
    public int getHP(){
        return hp;
    }

    public abstract void attack();

}