/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.carselling;

/**
 *
 * @author Cip
 */
public class Label {

    /**
     *
     */
    public enum Color {

        /**
         *
         */
        WHITE,

        /**
         *
         */
        RED,

        /**
         *
         */
        YELLOW,

        /**
         *
         */
        GREEN,

        /**
         *
         */
        GRAY,

        /**
         *
         */
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
    
    /**
     *
     */
    Label() {
        name = "Default Car Name";
        maxSpeed = 90;
    }
    
    /**
     *
     * @param manufacturer Brand's name
     * @param name Car Model
     */
    Label(String manufacturer, String name) {
        this.manufacturer = manufacturer;
        this.name = name;
        maxSpeed = 90;
    }
    
    /**
     *
     * @param manufacturer Brand's name
     * @param name Car Model
     * @param color car's Color
     */
    Label(String manufacturer, String name, Color color) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.color = color;
        maxSpeed = 90;
    }
    

    /**
     *
     * @param isSold true if the Car is going to be sold
     */
    void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    /**
     *
     * @param isRented true if the Car is going to be Rented
     */
    void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    /**
     *
     * @return if the Car is sold
     */
    boolean isSold() {
        return isSold;
    }

    /**
     *
     * @return if the Car is rented
     */
    boolean isRented() {
        return isRented;
    }
    
    /**
     *
     * @return Car's current color
     */
    Color getColor() {
        return color;
    }

    /**
     *
     * @return Car Model
     */
    String getName() {
        return name;
    }

    /**
     *
     * @return Car's maximum speed
     */
    short getMaxSpeed() {
        return maxSpeed;
    }

    /**
     *
     * @return Car's Sale Price
     */
    int getSalePrice() {
        return salePrice;
    }

    /**
     *
     * @return Car's Daily Rent Price
     */
    int getDailyRentPrice() {
        return dailyRentPrice;
    }
    
    /**
     *
     * @param color 
     */
    void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @param name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param maxSpeed
     */
    void setMaxSpeed(short maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     *
     * @param salePrice
     */
    void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    /**
     *
     * @param dailyRentPrice
     */
    void setDailyRentPrice(int dailyRentPrice) {
        this.dailyRentPrice = dailyRentPrice;
    }
    
    /**
     *
     * @param paintPrice
     */
    void setPaintPrice(int paintPrice) {
        this.paintPrice = paintPrice;
    }
    
    /**
     *
     * @return
     */
    int getPaintPrice() {
        return paintPrice;
    }
    
    /**
     *
     * @return the Label's parameters and their values in String format
     */
    @Override
    public String toString() {
        String strSalePrice = String.format("$%s", Integer.toString(getSalePrice()));
        String strRentPrice = String.format("$%s", Integer.toString(getDailyRentPrice()));
        String strPaintPrice = String.format("$%s", Integer.toString(getPaintPrice()));
        
        return String.format(
                " BRAND%11s %16s \n"
                        + " MODEL%11s %16s \n"
                        + " COLOR%11s %16s \n "
                        + "MAX_SPEED%7s %16s \n "
                        + "SALE_PRICE%6s %16s \n "
                        + "RENT_PRICE%6s %16s \n "
                        + "PAINT_PRICE%5s %16s \n "
                        + "SOLD%12s %16s\n "
                        + "RENTED%10s %16s\n",
                
                ":",manufacturer, 
                ":", name, 
                ":", color, 
                ":", maxSpeed, 
                ":", ((salePrice > 0) ? strSalePrice : "NOT_SET"),
                ":", ((dailyRentPrice > 0) ? strRentPrice : "NOT_SET"),
                ":", ((paintPrice > 0) ? strPaintPrice : "NOT_SET"),
                ":", isSold ? "TRUE" : "FALSE",
                ":", isRented ? "TRUE" : "FALSE"
        ); 
    }
    
    
}