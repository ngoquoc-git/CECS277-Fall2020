public class DoorFactory{
    public Door createDoor(int type){
        switch(type){
            case 1: return new BasicDoor();
            case 2: return new LockedDoor();
            case 3: return new DeadboltDoor();
            case 4: return new ComboDoor();
            case 5: return new CodeDoor();
            default: return null;
        }
    }

    public void openDoor(int type){
        Door dr = createDoor(type);
        dr.examine();
    }
}