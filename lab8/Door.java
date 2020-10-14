public interface Door {

    /**
     * Let users know what door is it
     * @return door's name and description
     */
    public String examine();
    
    /**
     * Available options for users
     * @return a set of options
     */
    public String menu();

    /**
     * Check if the door is unlocked from given option
     * @param option Users' option from menu
     * @return User's action
     */
    public String unlock(int option);

    /**
     * Check if the door is open
     * @return true if door is open, false otherwise
     */
    public boolean open();

    /**
     * Clue appears when users failed to open the door
     * @return help message
     */
    public String clue();
    
    /**
     * Success message if door is open
     * @return success message
     */
    public String success();
}
