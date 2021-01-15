package a_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class A05_API_Predicate {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc1", "abc2", "abc3", "abc4", "xyz1", "xyz2");

        //The test method needs a boolean, so we give a boolean to the lambda
        List<String> stringListThatStartsWithAbc = filter(stringList, (String str) -> str.startsWith("abc"));
        stringListThatStartsWithAbc.forEach(System.out::println);
    }

    /**
     * Predicate provides a test method, that's all
     *
     * @param from
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> from, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < from.size(); i++) {
            T t = from.get(i);
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
