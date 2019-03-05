package AnonymousExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HelloFunctionalInterfaces {

    static List<Person> people = new ArrayList<Person>();

    static {
        people.add(new Person("Kostas", 27, Person.Sex.MALE));
        people.add(new Person("Maria", 17, Person.Sex.FEMALE));
        people.add(new Person("George", 16, Person.Sex.MALE));
        people.add(new Person("Faye", 30, Person.Sex.FEMALE));
    }

    public void fetchPersons(Person p, Predicate<Person> personTester) {
        if(personTester.test(p))
            p.displayPerson();
    }

    public void run() {

        for (Person aPerson : people) {
            fetchPersons(aPerson, new Predicate<Person>() {
                @Override
                public boolean test(Person p) {
                    return p.getAge() > 18 && p.getAge() < 30;
                }
            });
        }

    }

    public static void main(String[] args) {

        HelloFunctionalInterfaces app = new HelloFunctionalInterfaces();
        app.run();

    }

}
