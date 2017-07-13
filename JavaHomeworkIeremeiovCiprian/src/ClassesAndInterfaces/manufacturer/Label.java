/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.manufacturer;

/**
 *
 * @author Cip
 */
public class Label {

   

    
    public enum Color {
        WHITE,
        RED,
        YELLOW,
        GREEN,
        GRAY,
        BLACK
    };
    /**
     * Internal hidden fields / attributes
     */
    private Color color;
    private String name;
    private String manufacturer;
    private short maxSpeed;
    private int salePrice = -1;
    private int dailyRentPrice = -1;
    private int paintPrice = -1;
    private boolean isSold = false;
    private boolean isRented = false;
    
    public Label() {
        name = "Default Car Name";
        maxSpeed = 90;
    }
    
    public Label(String manufacturer, String name) {
        this.manufacturer = manufacturer;
        this.name = name;
        maxSpeed = 90;
    }
    
    public Label(String manufacturer, String name, Color color) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.color = color;
        maxSpeed = 90;
    }
    
     public String getManufacturer() {
        return manufacturer;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public boolean isSold() {
        return isSold;
    }

    public boolean isRented() {
        return isRented;
    }
    
    
    
    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public short getMaxSpeed() {
        return maxSpeed;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public int getDailyRentPrice() {
        return dailyRentPrice;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(short maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public void setDailyRentPrice(int dailyRentPrice) {
        this.dailyRentPrice = dailyRentPrice;
    }
    
    public void setPaintPrice(int paintPrice) {
        this.paintPrice = paintPrice;
    }
    
    public int getPaintPrice() {
        return paintPrice;
    }
    
    
    

    @Override
    public String toString() {
        return String.format(
                " brand%11s %20s \n model%11s %20s \n color%11s %20s \n maxSpeed%8s %20s \n "
                        + "salePrice%7s %20s \n dailyRentPrice %s %20s \n paintPrice%6s %20s \n SOLD%12s %20s\n RENTED%10s %20s\n",
                
                ":", 
                manufacturer, 
                ":", 
                name, 
                ":", 
                color, 
                ":", 
                maxSpeed, 
                ":", ((getSalePrice() > 0) ? Integer.toString(getSalePrice()) : "NOT_SET"),
                ":", ((getDailyRentPrice() > 0) ? Integer.toString(getDailyRentPrice()) : "NOT_SET"),
                ":", ((getPaintPrice() > 0) ? Integer.toString(getPaintPrice()) : "NOT_SET"),
                ":", isSold ? "TRUE" : "FALSE",
                ":", isRented ? "TRUE" : "FALSE"
        ); 
    }
    
//    @Override
//    public String toString() {
//        return "{" 
//                + "brand: " + manufacturer + ", "
//                + "model: " + name + ", "
//                + "color: " + color + ", "
//                + "maxSpeed: " + maxSpeed + ", "
//                + "salePrice: " + ((getSalePrice() > 0) ? Integer.toString(getSalePrice()) : "NOT_SET") + ", "
//                + "dailyRentPrice: " + ((getDailyRentPrice() > 0) ? Integer.toString(getDailyRentPrice()) : "NOT_SET") + ", "
//                + "paintPrice: " + ((getPaintPrice() > 0) ? Integer.toString(getPaintPrice()) : "NOT_SET") + " }";
//    }


    
    
    
    
    
    
    
}
