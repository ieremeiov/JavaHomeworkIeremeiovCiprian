
package anonymousnomore;

/**
 * greets in French
 * @author Cip
 */
class FrenchGreeting implements HelloWorld {

    private String name = "tout le monde";

    @Override
    public void greet() {
        greetSomeone("tout le monde");
    }

    @Override
    public void greetSomeone(String someone) {
        setName(someone);
        System.out.println("Salut, " + getName());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
