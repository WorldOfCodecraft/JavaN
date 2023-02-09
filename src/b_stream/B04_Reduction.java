package b_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B04_Reduction {
    public static void main(String[] args) {
        List<String> words = List.of("hello", "hello", "hello", "word");
        /**
         * Get the largest result
         * section 2.6 from "Impatient"
         */
        Optional<String> max = words.stream().max(String::compareToIgnoreCase);
        if (max.isPresent()) System.out.println(max.get());

        /**
         * Get the first
         */
        Optional<String> first = words.stream().filter(s -> s.startsWith("h")).findFirst();
        if (first.isPresent()) System.out.println(first.get());

        /**
         * Get any
         */
        Optional<String> any = words.stream().parallel().filter(s -> s.startsWith("h")).findAny();
        if (any.isPresent()) System.out.println(any.get());

        /**
         * Any matching
         */
        boolean hasMatching = words.stream().parallel().anyMatch(s -> s.startsWith("C"));
        System.out.println(hasMatching);

        /**
         * Join array elements
         */
        int[] intArray = {1, 2, 3, 4};
        //we want a string "1234"
        String string1234 = Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining());

        /**
         * Another set of data
         */
        int[][] patients =
                {
                        {2200, 1100, 1200, 1000, 1015, 2000, 1092, 2204},
                        {5020, 6105, 2009, 9047, 1016, 2014, 2708, 2308},
                        {1720, 2406, 3054, 1018, 1023, 3100, 1406, 1502},
                        {1490, 2002, 2016, 5008, 2044, 1055, 1607, 2201},
                        {1520, 1007, 1092, 2065, 1023, 1010, 1046, 1502},
                        {1670, 1201, 2008, 2001, 1086, 1009, 1041, 1706},
                        {1870, 2001, 2078, 1006, 1053, 1702, 1009, 1406}

                };

        /**
         * Get the largest number in a COLUMN
         */
        for (int i = 0; i < patients.length; i++) {
            final int index = i;
            Optional<Integer> maxNumber = Stream.of(patients).map(row -> row[index]).collect(Collectors.toList()).stream().max(Integer::compare);
            System.out.printf("%7s", maxNumber.orElse(-1));
        }

        /**
         * Get the largest number in a COLUMN
         */
        System.out.println();
        for (int i = 0; i < patients.length; i++) {
            final int index = i;
            OptionalInt maxNumber = Stream.of(patients).mapToInt(row -> row[index]).max();
            System.out.printf("%7s", maxNumber.orElse(-1));
        }

        /**
         * Get the sum of the numbers in a COLUMN
         */
        System.out.println();
        for (int i = 0; i < patients.length; i++) {
            final int index = i;
            Optional<Integer> sum = Stream.of(patients).map(row -> row[index]).collect(Collectors.toList()).stream().reduce(Integer::sum);
            System.out.printf("%7s", sum.orElse(-1));
        }

        /**
         * Get the sum of the numbers in a COLUMN
         */
        System.out.println();
        for (int i = 0; i < patients.length; i++) {
            final int index = i;
            int sum = Stream.of(patients).mapToInt(row -> row[index]).sum();
            System.out.printf("%7s", sum);
        }

    }
}
