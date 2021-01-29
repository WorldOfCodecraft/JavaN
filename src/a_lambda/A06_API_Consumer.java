package a_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class A06_API_Consumer {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc1", "abc2", "abc3", "abc4", "xyz1", "xyz2");

        //The test method needs a boolean, so we give a boolean to the lambda
        filter(stringList, (String str) -> System.out.println(str));
    }

    /**
     * Consumer.accept() consumes a T, and returns nothing, so it's used to do some operation to the T
     *
     * @param from
     * @param consumer
     * @param <T>
     * @return
     */
    public static <T> void filter(List<T> from, Consumer<T> consumer) {
        for (int i = 0; i < from.size(); i++) {
            T t = from.get(i);
            consumer.accept(t);
        }
    }
}
