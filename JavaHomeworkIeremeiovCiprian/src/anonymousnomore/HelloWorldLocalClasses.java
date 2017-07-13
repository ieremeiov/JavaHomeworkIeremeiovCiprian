
package anonymousnomore;

/**
 * Greets the world or specific names in specific/all languages
 * @author Cip
 */
public class HelloWorldLocalClasses {

    /**
     * Greets the world in different languages
     */
    public static void sayHello() {

        sayHelloIn(Language.ENGLISH);
        sayHelloIn(Language.FRENCH);
        sayHelloIn(Language.SPANISH);
        
    }

    /**
     *
     * @param name to greet in different languages
     */
    public static void sayHelloTo(String name) {

        sayHelloToIn(name, Language.ENGLISH);
        sayHelloToIn(name, Language.FRENCH);
        sayHelloToIn(name, Language.SPANISH);
        
    }

    /**
     *
     * @param language used to say Hello to the world
     */
    public static void sayHelloIn(Language language) {

        sayHelloToIn("world", language);
    }
    
    /**
     *
     * @param name to greet in the specified "language"
     * @param language used to greet the specified "name"
     */
    public static void sayHelloToIn(String name, Language language) {

        switch (language) {
            case ENGLISH:
                HelloWorld englishGreeting = new EnglishGreeting();
                englishGreeting.greetSomeone(name);
                break;
            case FRENCH:
                HelloWorld frenchGreeting = new FrenchGreeting();
                frenchGreeting.greetSomeone(name);
                break;
            case SPANISH:
                HelloWorld spanishGreeting = new SpanishGreeting();
                spanishGreeting.greetSomeone(name);
                break;

        }
    }
    
}
