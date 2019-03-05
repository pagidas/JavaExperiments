package AnonymousExpressions;

public class HelloAnonymousClasses {

    interface DogBarking {
        void bark();
        void bark(String dog);

        default void barkTo(String dog) {
            bark(dog);
        }
    }

    public void dogsBark() {

        /*
         *  Traditional way to implement an interface by declaring a new Class
         *  and creating an instance of that class to call a specific method.
         */
        class LabradorRetriever implements DogBarking {
            @Override
            public void bark() {
                System.out.println("Labrador Retriever barks!");
            }

            @Override
            public void bark(String dog) {
                System.out.println("Labrador Retriever barks at " + dog + "!");
            }
        }

        LabradorRetriever labradorRetriever = new LabradorRetriever();

        /*
         *  Creates an anonymous class, implementing that interface
         *  and calls the method directly from the specified reference.
         */
        DogBarking beagle = new DogBarking() {
            @Override
            public void bark() {
                System.out.println("Beagle barks!");
            }

            @Override
            public void bark(String dog) {
                System.out.println("Beagle barks at " + dog + "!");;
            }
        };

        labradorRetriever.bark();
        beagle.bark("Labrador");
        labradorRetriever.barkTo("Beagle");
    }

    public static void main(String[] args) {

        HelloAnonymousClasses app = new HelloAnonymousClasses();
        app.dogsBark();

    }

}
