package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@FunctionalInterface
public interface PersonDetailsInterface {

    void printPersonDetail(Person person);

    default void printPersonNameUtf8To(Person person, OutputStream output) {
        try {
            output.write(person.getName().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static void printPersonNameAsItIs(Person person) {
        System.out.printf(person.getName());
    }

}