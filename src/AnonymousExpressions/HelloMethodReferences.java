package AnonymousExpressions;

import java.util.stream.IntStream;

/*
 *  This class demonstrates the usage of Method References.
 *
 *  When an argument of a lambda expression is simply passed
 *  in another method, thus no extra intelligence, instead of
 *  the traditional syntax, another more readable way can be used.
 */
public class HelloMethodReferences {

    private static boolean isGreaterThanThree(int number) {
        System.out.println("isGreaterThanThree at number: " + number);
        return number > 3;
    }

    private static boolean isGreaterThanFive(int number) {
        System.out.println("isGreaterThanFive at number: " + number);
        return number > 5;
    }

    private static int doubleIt(int number) {
        System.out.println("doubleIt at number: " + number);
        return number * 2;
    }

    public static void main(String[] args) {

        // From numbers 0 to 10 inclusive, double all the numbers that are greater than 5 and 3
        IntStream.rangeClosed(0, 10)
                .filter(HelloMethodReferences::isGreaterThanThree)
                .filter(HelloMethodReferences::isGreaterThanFive)
                .map(HelloMethodReferences::doubleIt)
                .forEach(System.out::println);
    }

}
