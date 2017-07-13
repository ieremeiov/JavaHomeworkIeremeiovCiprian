/*
 * Rectangle Class that can calculate a rectangle's area based on it's width and height
 */
package somethingiswrong;

/**
 *
 * @author Cip
 */
public class Rectangle {

    private int width;
    private int height;

    public int area() {
        return (this.width * this.height);
    }

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Width must be greater than 0");
        }
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be greater than 0");
        }
    }

}
