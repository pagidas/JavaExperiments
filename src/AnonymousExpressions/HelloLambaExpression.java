package AnonymousExpressions;

import utils.Person;
import utils.PersonDetailsInterface;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  This class demonstrates how a lambda expression can implement a functional interface
 *  but still use the rest of the default and static methods defined.
 */
public class HelloLambaExpression {

    static Person person1;

    static {
        person1 = new Person("Kostas", 27, Person.Sex.MALE);
    }

    public void run() {

        // implements the abstract single-method interface using lambda expression to print the person's age
        PersonDetailsInterface personDetailsInterface = person -> System.out.println(person.getAge());
        personDetailsInterface.printPersonDetail(person1);

        // prints the person's name to a .txt file, using a default method in the interface
        try {
            personDetailsInterface.printPersonNameUtf8To(person1, new FileOutputStream("person_data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // prints the person's name using a static method in the interface
        PersonDetailsInterface.printPersonNameAsItIs(person1);
    }

    public static void main(String[] args) {

        HelloLambaExpression myApp = new HelloLambaExpression();
        myApp.run();

    }

}
