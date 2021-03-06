package AnonymousExpressions;

import utils.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 *  This class demonstrates how to use the Predicate<T> functional interface
 *  in a generic way to "fetch" any object of an entity with one method, giving
 *  the criteria the moment we need them
 */
public class HelloPredicateInterface {

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

        HelloPredicateInterface app = new HelloPredicateInterface();
        app.run();

    }

}
