/*
 * Class that is modelling a scenario where the husband is cleaning the room with a vacuum cleaner
 * while the TV is running and when a special TV Show starts he will notice it and try to wake up his sleeping Wife 
 * who holds a burning cigarette right above an ashtray 
 */
package multithreading;

/**
 *
 * @author Cip
 */
public class Scenario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Wife wife = new Wife();
        Husband husband = new Husband(wife);

        Thread cigarette = new Cigarette();
        Thread tray = new Ashtray();

        cigarette.start();
        tray.start();
        
        TvShow show = new TvShow(husband);
        Thread tv = new Tv(show);

        tv.start();
        husband.start();
        wife.start();

    }

}
