public class DoorFactory{
    public Door createDoor(int type){
        switch(type){
            case 1: return new BasicDoor();
            case 2: return new Locke
        }
    }

    public void openDoor(int type){
        Door dr = creatDoor(type);
        dr.examine();
    }
}