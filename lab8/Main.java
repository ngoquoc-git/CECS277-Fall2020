/**
 * A Escape Room with 3 random doors.
 * @authors Ngo Quoc and Kevin Garcia
 * 10/13/2020
 * Copyright (C) 2020 Ngo Quoc and Kevin Garcia. All Rights Reserved.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Escape Room.");
        System.out.println("You must unlock 3 doors to escape...");

        for (int i = 0; i < 3; i++) {

            Door d;
            int door = (int) (Math.random() * 5) + 1;

            if (door == 1) {
                d = new BasicDoor();
                openDoor(d);
            } else if (door == 2) {
                d = new LockedDoor();
                openDoor(d);
            } else if (door == 3) {
                d = new DeadboltDoor();
                openDoor(d);
            } else if (door == 4) {
                d = new ComboDoor();
                openDoor(d);
            } else if (door == 5) {
                d = new CodeDoor();
                openDoor(d);
            }
        }

        System.out.println("Congratulations! You escaped...this time.");

    }

    /**
     * Passes in the door the user will try to unlock
     * @param d Random door to be opened
     */
    public static void openDoor(Door d) {

        System.out.println(d.examine());

        while (!d.open()) {

            System.out.println(d.menu());

            int num = CheckInput.getInt();
            System.out.println(d.unlock(num));

            if (!d.open()) System.out.println(d.clue());

        }

        System.out.println(d.success());

    }

}