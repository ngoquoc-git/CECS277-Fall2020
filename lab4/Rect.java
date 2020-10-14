class Rect{
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Constructor for class Rect
   * @param x location of the rectangle in x-axis
   * @param y location of the rectangle in y-axis
   * @param width the width of rectangle
   * @param height the height of the rectangle 
   */
  public Rect(int x, int y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /** 
   * Method for returning x of rectangle
   * @return int x
   */
  public int getX(){
    return x;
  }

  /** 
   * Method for returning y of rectangle
   * @return int y
   */
  public int getY(){
    return y;
  }

  /** 
   * Method for returning width of rectangle
   * @return int width
   */
  public int getWidth(){
    return width;
  }

  /** 
   * Method for returning height of rectangle
   * @return int height
   */
  public int getHeight(){
    return height;
  }

}