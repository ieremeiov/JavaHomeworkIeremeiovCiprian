
package anonymousnomore;

/**
 * greets in English
 * @author Cip
 */
class EnglishGreeting implements HelloWorld {

    private String name = "world";

    @Override
    public void greet() {
        greetSomeone("world");
    }

    @Override
    public void greetSomeone(String someone) {
        setName(someone);
        System.out.println("Hello, " + getName());
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
