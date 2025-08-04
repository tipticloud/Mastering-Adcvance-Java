package Lambda;

import java.util.function.Predicate;

public class UsingPredicate {
    public static void main(String[] args) {
        Predicate<String> isLong = str -> str.length() > 5;

        System.out.println(isLong.test("Hello"));     // false
        System.out.println(isLong.test("Welcome"));   // true
    }
}
