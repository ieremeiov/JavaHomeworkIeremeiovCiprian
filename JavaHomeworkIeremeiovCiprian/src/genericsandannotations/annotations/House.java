/*
 * 
 */
package genericsandannotations.annotations;

/**
 *
 * @author Cip
 * The use of open is discouraged, use openFrontDoor or openBackDoor instead.
 */
public interface House {

    // In the Classroom we talked about making a method deprecated without giving it a specific implementation makes no sense.
    // Some OTHER people who have already solved the problem would sugest that "The documentation should reflect why open is deprecated and what to use instead."
    // So they actually sugested that I should add @deprecated in Javadoc

    /**
     *
     * @deprecated
     */

    @Deprecated
    public void open();

    /**
     *
     */
    public void openFrontDoor();

    /**
     *
     */
    public void openBackDoor();
}
