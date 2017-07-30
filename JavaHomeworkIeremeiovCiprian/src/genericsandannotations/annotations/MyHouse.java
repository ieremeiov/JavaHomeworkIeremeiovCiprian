/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsandannotations.annotations;

/**
 *
 * @author Cip
 */
//@Deprecated   // Deprecated annotation removes all warnings about deprecation inside the class, not only the 'open()' method.
public class MyHouse implements House {
    
    // @Deprecated //for some reason I still have a warning on implementing 'House', if I add @deprecated Javadoc annotation in the interface,
                                                                                                            // so I've chosen to leave that out for this example
    
    // @SuppressWarnings("deprecation") // for some other reason with @SuppressWarning I still have a warning on open() being deprecated

    /**
     *
     * @deprecated
     */
    @Override
    @Deprecated
    public void open() {}

    /**
     *
     */
    @Override
    public void openFrontDoor() {}

    /**
     *
     */
    @Override
    public void openBackDoor() {}
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
    }
    
}
