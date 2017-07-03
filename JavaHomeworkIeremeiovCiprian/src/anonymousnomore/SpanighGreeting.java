
package anonymousnomore;

/**
 * greets in Spanish
 * @author Cip
 */
class SpanishGreeting implements HelloWorld {

    private String name = "mundo";

    @Override
    public void greet() {
        greetSomeone("mundo");
    }

    @Override
    public void greetSomeone(String someone) {
        setName(someone);
        System.out.println("Hola, " + getName());
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
