package a_lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class A08_API_Predicate_BoxUnBox {
    /**
     * Boxed values are a wrapper around primitive types and are stored on the heap.
     * Therefore, boxed values use more memory and require additional memory lookups to fetch the wrapped primitive value.
     * <p>
     * Java 8 also added a specialized version of the functional interfaces we described earlier
     * in order to avoid autoboxing operations when the inputs or outputs are primitives.
     * <p>
     * For example, in the following code, using an IntPredicate avoids a boxing operation of the value 1000,
     * whereas using a Predicate<Integer> would box the argument 1000 to an Integer object
     * <p>
     * Quote from Modern Java in Action Book
     *
     * @param args
     */
    public static void main(String[] args) {
        testUnboxing();
        testBoxing();
    }

    public static void testUnboxing() {
        IntPredicate intPredicate = (int i) -> i % 2 == 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000000; i++) {
            intPredicate.test(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration);

    }

    public static void testBoxing() {
        Predicate<Integer> integerPredicate = (Integer i) -> i % 2 == 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000000; i++) {
            integerPredicate.test(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration);
    }

}